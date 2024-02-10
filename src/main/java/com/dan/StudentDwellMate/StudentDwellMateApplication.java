package com.dan.StudentDwellMate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentDwellMateApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentDwellMateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(

			new BCryptPasswordEncoder() .encode("12345")
			);
		}

}
