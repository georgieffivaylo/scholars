package eu.leadconsult.scholars.module.scholar.service.manage;

import eu.leadconsult.scholars.exception.ScholarException;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.repository.ScholarRepository;
import eu.leadconsult.scholars.module.scholar.dto.manage.ScholarCreateDto;
import eu.leadconsult.scholars.module.scholar.dto.manage.ScholarEditDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static eu.leadconsult.scholars.exception.code.ErrorCode.RESOURCE_NOT_FOUND;

@Slf4j
@Service
@AllArgsConstructor
public class ScholarManageServiceImpl implements ScholarManageService {

    private final ScholarRepository scholarRepository;
    private final ModelMapper modelMapper;

    @Override
    public Scholar addScholar(ScholarCreateDto scholarCreateDto) {
        Scholar scholar = modelMapper.map(scholarCreateDto, Scholar.class);
        Scholar savedScholar = scholarRepository.save(scholar);
        log.info("Saved scholar: {}", savedScholar); // Print if no sensitive data ONLY!
        return savedScholar;
    }

    @Override
    public boolean deleteScholar(Long id) {
        Scholar scholar = getScholarOrElseThrow(id);
        scholarRepository.delete(scholar);
        log.info("Deleted scholar with id: {}", id);
        return true;
    }

    @Override
    @Transactional
    public Scholar editScholar(ScholarEditDto scholarEditDto) {
        Scholar scholar = getScholarOrElseThrow(scholarEditDto.getId());
        updateScholar(scholar, scholarEditDto);
        log.info("Edited scholar: {}", scholar); // Print if no sensitive data ONLY!
        return scholar;
    }

    private Scholar getScholarOrElseThrow(Long id) {
        return scholarRepository.findById(id).orElseThrow(() ->
                new ScholarException("Scholar with id " + id + " not found", RESOURCE_NOT_FOUND));
    }

    private void updateScholar(Scholar scholar, ScholarEditDto scholarEditDto) {
        scholar.setName(scholarEditDto.getName());
        scholar.setAge(scholarEditDto.getAge());
        scholar.setGroup(scholarEditDto.getGroup());
        scholar.setCourse(scholarEditDto.getCourse());
        scholar.setScholarType(scholarEditDto.getScholarType());
    }
}
