package com.concessionaria;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcessionariaApplication {

	public static void main(String[] args) {
		try {
			new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor(); // Linux
		} catch (InterruptedException | IOException e) {
			Thread.currentThread().interrupt();
		}

		SpringApplication.run(ConcessionariaApplication.class, args);
	}

}
