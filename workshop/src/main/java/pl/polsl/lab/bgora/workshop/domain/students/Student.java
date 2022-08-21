package pl.polsl.lab.bgora.workshop.domain.students;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;


}
