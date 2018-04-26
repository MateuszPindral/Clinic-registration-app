package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.clinic.entity.Doctor;

public interface DoctorsRepository extends JpaRepository<Doctor,Long> {
}
