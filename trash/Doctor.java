package pl.sda.clinic.entity;

import lombok.*;
import pl.sda.clinic.type.DocSpecType;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

//    @OneToMany(mappedBy = "doctor")
//    private Set<Visit> visits;

    @Column(name = "specialization")
    @Enumerated(value = EnumType.STRING)
    private DocSpecType specialization;
//
//    @OneToMany(mappedBy = "doctor")
//    private Set<DoctorTimetable> timetables;


}
