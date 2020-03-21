package com.carryon.backend.repositories;

import com.carryon.backend.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByName(String name);
    List<Organization> findAllByName(String name);
}
