package com.example.tendeuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tendeuse.main.Principale;

@SpringBootApplication
public class TendeuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TendeuseApplication.class, args);
		Principale principale =new Principale();
		principale.main(args);
	}

}
