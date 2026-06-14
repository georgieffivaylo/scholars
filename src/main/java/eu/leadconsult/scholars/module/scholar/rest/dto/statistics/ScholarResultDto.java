package eu.leadconsult.scholars.module.scholar.rest.dto.statistics;

import eu.leadconsult.scholars.module.scholar.rest.dto.ScholarDto;

import java.util.List;

public record ScholarResultDto(List<ScholarDto> scholars) {
}
