package eu.leadconsult.scholars;

import eu.leadconsult.scholars.exception.ScholarException;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.repository.ScholarRepository;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarCreateDto;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarEditDto;
import eu.leadconsult.scholars.module.scholar.service.ScholarModifyService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import static eu.leadconsult.scholars.module.scholar.entity.Course.MAIN;
import static eu.leadconsult.scholars.module.scholar.entity.Course.SECONDARY;
import static eu.leadconsult.scholars.module.scholar.entity.ScholarType.STUDENT;
import static eu.leadconsult.scholars.module.scholar.entity.ScholarType.TEACHER;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ScholarModifyServiceTest extends SpringConfigInitTest {

    @Autowired
    private ScholarModifyService scholarModifyService;

    @Autowired
    private ScholarRepository scholarRepository;

    @Test
    @Order(1)
    void addScholar_ShouldIncreaseScholarCount_WhenOneScholarIsAdded() {
        int sizeBeforeAdding = scholarRepository.findAll().size();
        ScholarCreateDto scholarCreateDto = new ScholarCreateDto("Ivaylo 3", 20, 2, MAIN, TEACHER);
        Scholar savedScholar = scholarModifyService.addScholar(scholarCreateDto);
        assertNotNull(savedScholar.getId());
        assertEquals(sizeBeforeAdding + 1, scholarRepository.findAll().size());
    }

    @Test
    @Order(2)
    void editScholar_ShouldEditScholar_WhenValidEditDtoIsProvided() {
        ScholarEditDto scholarEditDto = new ScholarEditDto(3L, "Ivaylo (Modified)", 25, 5, SECONDARY, STUDENT);
        Scholar editedScholar = scholarModifyService.editScholar(scholarEditDto);

        assertEquals("Ivaylo (Modified)", editedScholar.getName());
        assertEquals(25, editedScholar.getAge());
        assertEquals(5, editedScholar.getGroup());
        assertEquals(SECONDARY, editedScholar.getCourse());
        assertEquals(STUDENT, editedScholar.getScholarType());
    }

    @Test
    @Order(3)
    void deleteScholar_ShouldDeleteScholar_WhenValidIdIsProvided() {
        int sizeBeforeDeleting = scholarRepository.findAll().size();
        boolean deleted = scholarModifyService.deleteScholar(1L);
        assertTrue(deleted);
        assertEquals(sizeBeforeDeleting - 1, scholarRepository.findAll().size());
    }

    @Test
    @Order(4)
    void editScholar_ShouldThrowNotFound_WhenInvalidIdIsProvided() {
        ScholarEditDto scholarEditDto = new ScholarEditDto(9999L, "Ivaylo (Modified)", 25, 5, SECONDARY, STUDENT);
        assertThrows(ScholarException.class, () -> scholarModifyService.editScholar(scholarEditDto));
    }

}
