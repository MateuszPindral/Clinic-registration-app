package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.clinic.entity.Visit;

public interface VisitsRepository extends JpaRepository<Visit,Long> {
}
