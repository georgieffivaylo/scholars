package eu.leadconsult.scholars.module.scholar.repository;

import eu.leadconsult.scholars.module.scholar.entity.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarRepository extends JpaRepository<Scholar, Long>, QuerydslPredicateExecutor<Scholar> {

}
