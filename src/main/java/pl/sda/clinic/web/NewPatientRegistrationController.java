package pl.sda.clinic.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.clinic.bo.NewPatientRegistrationService;
import pl.sda.clinic.dto.NewPatientRegistrationDto;
import pl.sda.clinic.entity.Patient;
import pl.sda.clinic.exceptions.EmailExistsException;

import javax.validation.Valid;

@Controller
public class NewPatientRegistrationController {

    private final NewPatientRegistrationService newPatientRegistrationService;

    @Autowired
    public NewPatientRegistrationController(NewPatientRegistrationService newPatientRegistrationService) {
        this.newPatientRegistrationService = newPatientRegistrationService;
    }

    @GetMapping("/nowyPacjent")
    public ModelAndView showNewPatientPage() {

        ModelAndView mav = new ModelAndView("nowyPacjent");
        mav.addObject("newPatient", new NewPatientRegistrationDto());
        return mav;

    }

    @PostMapping("/nowyPacjent/zarejestruj")
    public ModelAndView registerPatientAccount(
            @ModelAttribute("newPatient") @Valid NewPatientRegistrationDto newPatientRegistrationDto,
            BindingResult result, Errors errors) {

        Patient registered = null;
        if (!result.hasErrors()) {
            registered = createPatientAccount(newPatientRegistrationDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("nowyPacjentBlad");
        } else {
            return new ModelAndView("nowyPacjentWynik", "newPatient", newPatientRegistrationDto);

        }

    }

    private Patient createPatientAccount(NewPatientRegistrationDto newPatientRegistrationDto, BindingResult result) {
        Patient registered = null;

        try {
            registered = newPatientRegistrationService.saveNewPatientToDB(newPatientRegistrationDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }


}
