package eu.leadconsult.scholars.manage;

import eu.leadconsult.scholars.SpringConfigInitTest;
import eu.leadconsult.scholars.exception.ScholarException;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.repository.ScholarRepository;
import eu.leadconsult.scholars.module.scholar.dto.manage.ScholarCreateDto;
import eu.leadconsult.scholars.module.scholar.dto.manage.ScholarEditDto;
import eu.leadconsult.scholars.module.scholar.service.manage.ScholarManageService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import static eu.leadconsult.scholars.module.scholar.entity.enums.Course.MAIN;
import static eu.leadconsult.scholars.module.scholar.entity.enums.Course.SECONDARY;
import static eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType.STUDENT;
import static eu.leadconsult.scholars.module.scholar.entity.enums.ScholarType.TEACHER;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ScholarManageServiceTest extends SpringConfigInitTest {

    @Autowired
    private ScholarManageService scholarManageService;

    @Autowired
    private ScholarRepository scholarRepository;

    @Test
    @Order(1)
    void addScholar_ShouldIncreaseScholarCount_WhenOneScholarIsAdded() {
        int sizeBeforeAdding = scholarRepository.findAll().size();
        ScholarCreateDto scholarCreateDto = new ScholarCreateDto("Ivaylo 3", 20, 2, MAIN, TEACHER);
        Scholar savedScholar = scholarManageService.addScholar(scholarCreateDto);
        assertNotNull(savedScholar.getId());
        assertEquals(sizeBeforeAdding + 1, scholarRepository.findAll().size());
    }

    @Test
    @Order(2)
    void editScholar_ShouldEditScholar_WhenValidEditDtoIsProvided() {
        String modifiedName = "Ivaylo (Modified)";
        int modifiedAge = 25;
        int modifiedGroup = 5;
        ScholarEditDto scholarEditDto = new ScholarEditDto(3L, modifiedName, modifiedAge, modifiedGroup, SECONDARY, STUDENT);
        Scholar editedScholar = scholarManageService.editScholar(scholarEditDto);

        assertEquals(modifiedName, editedScholar.getName());
        assertEquals(modifiedAge, editedScholar.getAge());
        assertEquals(modifiedGroup, editedScholar.getGroup());
        assertEquals(SECONDARY, editedScholar.getCourse());
        assertEquals(STUDENT, editedScholar.getScholarType());
    }

    @Test
    @Order(3)
    void deleteScholar_ShouldDeleteScholar_WhenValidIdIsProvided() {
        int sizeBeforeDeleting = scholarRepository.findAll().size();
        boolean deleted = scholarManageService.deleteScholar(1L);
        assertTrue(deleted);
        assertEquals(sizeBeforeDeleting - 1, scholarRepository.findAll().size());
    }

    @Test
    @Order(4)
    void editScholar_ShouldThrowNotFound_WhenInvalidIdIsProvided() {
        long id = 9999999L;
        ScholarEditDto scholarEditDto = new ScholarEditDto(id, "Ivaylo (Modified)", 25, 5, SECONDARY, STUDENT);
        assertThrowsExactly(ScholarException.class, () -> scholarManageService.editScholar(scholarEditDto));
    }

}
