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
		Organization caritas = new Organization(null, "Caritas Konstanz", "Frau Mustermann", "+49 9988 1122", "mock@example.org");
		Organization tierheim = new Organization(null, "Tierheim Singen", "Frau Mustermann", "+49 9988 1122", "mock@example.org");
		Organization rotKreuz = new Organization(null, "Rotes Kreuz Singen", "Frau Mustermann", "+49 9988 1122", "mock@example.org");
		organizationRepository.saveAll(Arrays.asList(new Organization[] {caritas, tierheim, rotKreuz}));

		LocalDateTime requestDate = LocalDateTime.of(2020, 03, 18, 0, 0);
		HelpRequest kochen = new HelpRequest(null, caritas, "Kochen für Obdachlose und Bedürftige", "Hilf uns für die Obdachlosen und Bedürftigen zu kochen, die unter der Corona-Krise leiden!", requestDate, "Konstanz", "19.07., Dienstag", "3 Stunden");
		HelpRequest hunde = new HelpRequest(null, tierheim, "Mit Tierheimhunden Gassi gehen", "Wir suchen Hundelieberhaber, die ein bis zweimal am Tag Gassi gehen können und uns so ein bisschen Arbeit im Tierheim abnehmen würden.", requestDate, "Singen", "18.07., Montag", "1 Stunde");
		HelpRequest sanitaeter = new HelpRequest(null, rotKreuz, "Sanitätshilfe gesucht!", "Wir in der Gemeinde Singen sind vollkommen ausgelastet. Wir brauchen unbedingt Zulauf!", requestDate, "Singen", "19.07., Dienstag", "offen");
		helpRequestRepository.saveAll(Arrays.asList(new HelpRequest[] {kochen, hunde, sanitaeter}));
	}

}
