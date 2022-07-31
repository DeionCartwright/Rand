package com.DC.app.database.Repo;

import com.DC.app.database.Models.VisitDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
@Repository
public interface VisitRepo extends JpaRepository<VisitDetails, Long> {
    @Query(value="SELECT a FROM VisitDetails a WHERE a.surveyDate >= :myStart AND a.surveyDate <= :myEnd")
    List<VisitDetails> findBetweenDates(@Param("myStart") Date myStart, @Param("myEnd") Date myEnd);
}
