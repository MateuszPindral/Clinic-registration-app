package pl.sda.clinic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.clinic.entity.Patient;

@Repository
public interface PatientsRepository extends JpaRepository<Patient, Long> {

    Patient findFirstByEmail(String email);

}
