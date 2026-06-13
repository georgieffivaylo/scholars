package eu.leadconsult.scholars.module.scholar.rest;

import eu.leadconsult.scholars.module.scholar.rest.dto.DeleteScholarResultDto;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarCreateDto;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarDto;
import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarEditDto;
import eu.leadconsult.scholars.module.scholar.service.ScholarManageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/scholars/modify")
public class ScholarModifyController {

    private final ScholarManageService scholarManageService;
    private final ModelMapper modelMapper;

    @PostMapping("add")
    public ResponseEntity<ScholarDto> addScholar(@RequestBody ScholarCreateDto scholarCreateDto) {
        ScholarDto result = modelMapper.map(scholarManageService.addScholar(scholarCreateDto), ScholarDto.class);
        return ResponseEntity.status(CREATED).body(result);
    }

    @PutMapping("edit")
    public ResponseEntity<ScholarDto> editScholar(@RequestBody ScholarEditDto scholarEditDto) {
        ScholarDto result = modelMapper.map(scholarManageService.editScholar(scholarEditDto), ScholarDto.class);
        return ResponseEntity.status(OK).body(result);
    }

    @DeleteMapping("delete/{scholarId}")
    public ResponseEntity<DeleteScholarResultDto> deleteScholar(@PathVariable Long scholarId) {
        boolean deleted = scholarManageService.deleteScholar(scholarId);
        return ResponseEntity.status(OK).body(new DeleteScholarResultDto(scholarId, deleted));
    }

}
