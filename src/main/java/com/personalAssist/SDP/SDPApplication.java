package com.personalAssist.SDP;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
//
//import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class SDPApplication {

	public static void main(String[] args) {
		
		Dotenv dotenv = Dotenv.configure().load();

        // Export to real environment so Spring Boot can read them as ${ENV_VAR}
        Map<String, String> envs = Map.of(
            "MYSQLHOST", dotenv.get("MYSQLHOST"),
            "MYSQLPORT", dotenv.get("MYSQLPORT"),
            "MYSQLDATABASE", dotenv.get("MYSQLDATABASE"),
            "MYSQLUSER", dotenv.get("MYSQLUSER"),
            "MYSQLPASSWORD", dotenv.get("MYSQLPASSWORD")
        );

        envs.forEach((key, value) -> System.setProperty(key, value));

		SpringApplication.run(SDPApplication.class, args);
	}
	
	

}
