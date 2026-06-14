package eu.leadconsult.scholars.module.scholar.service.manage;

import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.rest.dto.manage.ScholarCreateDto;
import eu.leadconsult.scholars.module.scholar.rest.dto.manage.ScholarEditDto;

public interface ScholarManageService {

    Scholar addScholar(ScholarCreateDto scholarCreateDto);

    boolean deleteScholar(Long id);

    Scholar editScholar(ScholarEditDto scholarEditDto);
}
