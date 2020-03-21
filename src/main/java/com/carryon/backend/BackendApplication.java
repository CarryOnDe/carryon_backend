package com.carryon.backend;

import com.carryon.backend.entities.HelpRequest;
import com.carryon.backend.entities.Organization;
import com.carryon.backend.repositories.HelpRequestRepository;
import com.carryon.backend.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	HelpRequestRepository helpRequestRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	public @PostConstruct void init() {
		Organization org = new Organization(null, "Mock organization 1");
		organizationRepository.save(org);

		HelpRequest req1 = new HelpRequest(null, org, "Mock Request 1", "Mock Request 1 description", LocalDateTime.now(), "Ort 1");
		HelpRequest req2 = new HelpRequest(null, org, "Mock Request 2", "Mock Request 2 description", LocalDateTime.now(), "Ort 2");
		helpRequestRepository.saveAll(Arrays.asList(new HelpRequest[] {req1, req2}));
	}

}
