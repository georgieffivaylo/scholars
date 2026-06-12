package eu.leadconsult.scholars.module.scholar.repository;

import eu.leadconsult.scholars.module.scholar.entity.Course;
import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import eu.leadconsult.scholars.module.scholar.entity.ScholarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarRepository extends JpaRepository<Scholar, Long> {

    String COUNT_QUERY = """
            SELECT COUNT(DISTINCT(s.id))
            FROM SCHOLARS s
            WHERE
            """;

    @Query(value = COUNT_QUERY + "s.SCHOLAR_TYPE = :scholarType", nativeQuery = true)
    int countByScholarType(String scholarType);

    @Query(value = COUNT_QUERY + "s.COURSE = :courseType", nativeQuery = true)
    int countByCourseType(String courseType);

    List<Scholar> findAllByScholarTypeAndCourse(ScholarType scholarType, Course course);

    List<Scholar> findAllByScholarTypeAndGroup(ScholarType scholarType, int group);
}
