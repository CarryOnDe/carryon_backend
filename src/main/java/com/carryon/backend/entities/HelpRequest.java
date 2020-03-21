package com.carryon.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class HelpRequest {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Organization organization;

    String title;

    String description;

    LocalDateTime requestDate;

    String location;

}
