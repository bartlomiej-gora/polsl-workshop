package pl.polsl.lab.bgora.workshop.domain.workshop;

import lombok.Data;
import pl.polsl.lab.bgora.workshop.domain.students.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Workshop {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private LocalDateTime eventDate;

    @OneToMany(mappedBy = "id")
    private List<Student> students;


}
