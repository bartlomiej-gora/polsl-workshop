package pl.polsl.lab.bgora.workshop.domain.workshop;

import pl.polsl.lab.bgora.workshop.domain.students.Student;

public interface WorkshopFacade {

    Workshop addWorkshop(Workshop workshop);

    Student addStudentToWorkshop(String title, Student student);
}
