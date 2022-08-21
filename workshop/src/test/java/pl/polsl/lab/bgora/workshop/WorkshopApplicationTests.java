package pl.polsl.lab.bgora.workshop;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;
import pl.polsl.lab.bgora.workshop.domain.students.Student;
import pl.polsl.lab.bgora.workshop.domain.workshop.Workshop;
import pl.polsl.lab.bgora.workshop.domain.workshop.WorkshopFacade;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class WorkshopApplicationTests {

    @Autowired
    WorkshopFacade workshopFacade;

    @Autowired
    List<JpaRepository> repositiories;

    @BeforeEach
    void clearRepos() {
        repositiories.forEach(jpaRepository -> jpaRepository.deleteAll());
    }

    @Test
    void shouldAddWorkshop() {

        //given
        var workshop = new Workshop();
        workshop.setTitle("Demo workshop");

        //when
        var saved = workshopFacade.addWorkshop(workshop);

        //then
        assertThat(saved.getTitle()).isEqualTo("Demo workshop");
    }

    @Test
    void shouldAddStudentToWorkshop() {

        //given
        var workshop = new Workshop();
        var givenName = "Demo workshop";
        workshop.setTitle(givenName);
        workshopFacade.addWorkshop(workshop);
        var student = new Student();
        student.setFirstName("Janusz");
        student.setLastName("testowy");

        //when
        var saved = workshopFacade.addStudentToWorkshop(givenName, student);
        //then
        assertThat(saved.getFirstName()).isEqualTo(student.getFirstName());
        assertThat(saved.getLastName()).isEqualTo(student.getLastName());
    }


}
