package com.carryon.backend.repositories;

import com.carryon.backend.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    List<Organisation> findByName(String name);
    List<Organisation> findAllByName(String name);
}
