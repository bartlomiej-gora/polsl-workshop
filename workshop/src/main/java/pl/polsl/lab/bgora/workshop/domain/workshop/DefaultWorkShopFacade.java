package pl.polsl.lab.bgora.workshop.domain.workshop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.polsl.lab.bgora.workshop.domain.students.Student;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Component
class DefaultWorkShopFacade implements WorkshopFacade {

    private final WorkshopRepository workshopRepository;

    @Override
    public Workshop addWorkshop(final Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    @Override
    @Transactional
    public Student addStudentToWorkshop(final String title, final Student student) {
        var workshop = workshopRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("No workshop found"));
        if (workshop.getStudents() != null) {
            workshop.getStudents().add(student);
        } else {
            workshop.setStudents(List.of(student));
        }

        return student;
    }
}
