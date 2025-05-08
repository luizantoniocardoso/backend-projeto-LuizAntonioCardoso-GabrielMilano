package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication
public class BackendProjetoLuizAntonioCardosoGabrielMilanoApplication {

	public static void main(String[] args) {
		try {
			// Carrega o arquivo diretamente da pasta resources
			InputStream serviceAccount = BackendProjetoLuizAntonioCardosoGabrielMilanoApplication.class
					.getClassLoader()
					.getResourceAsStream("serviceAccountKey.json");

			if (serviceAccount == null) {
				throw new RuntimeException("Arquivo 'serviceAccountKey.json' não encontrado em resources.");
			}

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // força saída com erro, para o Gradle capturar
		}

		SpringApplication.run(BackendProjetoLuizAntonioCardosoGabrielMilanoApplication.class, args);
	}
}
