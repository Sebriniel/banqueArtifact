package com.banque.banqueArtifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class BanqueArtifactApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BanqueArtifactApplication.class, args);
	}
}
