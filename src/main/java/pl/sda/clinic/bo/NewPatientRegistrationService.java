package pl.sda.clinic.bo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.clinic.dto.NewPatientRegistrationDto;
import pl.sda.clinic.entity.Patient;
import pl.sda.clinic.exceptions.EmailExistsException;
import pl.sda.clinic.repository.PatientsRepository;
import pl.sda.clinic.utils.MappingUtils;

@Service
public class NewPatientRegistrationService {


    private PatientsRepository patientsRepository;
    private MappingUtils mappingUtils;

    @Autowired
    public NewPatientRegistrationService(PatientsRepository patientsRepository, MappingUtils mappingUtils) {
        this.patientsRepository = patientsRepository;
        this.mappingUtils = mappingUtils;
    }

    @Transactional
    public Patient saveNewPatientToDB(NewPatientRegistrationDto newPatientRegistrationDto) throws EmailExistsException {

        if (patientEmailExists(newPatientRegistrationDto.getEmail())) {
            throw new EmailExistsException(
                    "Użytkowniek o podanym adresie email już istnieje: " +
                            newPatientRegistrationDto.getEmail());

        }

        Patient patient = mappingUtils.mapNewPatientDtoToPatient(newPatientRegistrationDto);

        return patientsRepository.save(patient);

    }

    private boolean patientEmailExists(String email) {
//        Patient patient = patientsRepository.findFirstByEmail(email);
//        if(patient != null){
//            return true;
//        }
        return false;
    }
}
