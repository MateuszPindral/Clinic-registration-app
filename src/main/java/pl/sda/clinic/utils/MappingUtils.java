package pl.sda.clinic.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.clinic.dto.NewPatientRegistrationDto;
import pl.sda.clinic.entity.Patient;

@Service
public class MappingUtils {

    @Autowired
    PasswordEncoder passwordEncoder;

    public Patient mapNewPatientDtoToPatient(NewPatientRegistrationDto newPatientRegistrationDto){



        Patient patient = Patient.builder()
                .firstName(newPatientRegistrationDto.getFirstName())
                .lastName(newPatientRegistrationDto.getLastName())
                .email(newPatientRegistrationDto.getEmail())
                .login(newPatientRegistrationDto.getLogin())
                .password(passwordEncoder.encode(newPatientRegistrationDto.getPassword()))
                .build();


        return patient;
    }


}
