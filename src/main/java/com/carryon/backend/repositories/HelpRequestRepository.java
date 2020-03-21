package com.carryon.backend.repositories;

import com.carryon.backend.entities.HelpRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
    List<HelpRequest> findByTitle(String title);

    //TODO: Umstellen auf Georeferenzierung anhand von PLZ und Entfernung
    @Query("select h from HelpRequest h")
    List<HelpRequest> findByZipAndDistance(String zip, Integer disctance);
}
