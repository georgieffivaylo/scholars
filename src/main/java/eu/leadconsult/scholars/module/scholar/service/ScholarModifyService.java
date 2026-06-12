package eu.leadconsult.scholars.module.scholar.service;

import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarCreateDto;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarEditDto;

public interface ScholarModifyService {

    Scholar addScholar(ScholarCreateDto scholarCreateDto);

    boolean deleteScholar(Long id);

    Scholar editScholar(ScholarEditDto scholarEditDto);
}
