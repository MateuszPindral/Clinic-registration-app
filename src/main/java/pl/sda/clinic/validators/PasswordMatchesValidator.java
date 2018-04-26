package pl.sda.clinic.validators;

import pl.sda.clinic.annotations.PasswordMatches;
import pl.sda.clinic.dto.NewPatientRegistrationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        NewPatientRegistrationDto patient = (NewPatientRegistrationDto) o;
        return patient.getPassword().equals(patient.getMatchingPassword());
    }
}
