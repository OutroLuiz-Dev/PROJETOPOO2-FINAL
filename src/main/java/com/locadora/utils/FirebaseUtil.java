package com.locadora.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FirebaseUtil {

    public static void initFirebase() {
        try {
            // Usar caminho relativo para acessar o arquivo na pasta resources
            InputStream serviceAccount = FirebaseUtil.class.getClassLoader()
                    .getResourceAsStream("chave.json");

            if (serviceAccount == null) {
                throw new FileNotFoundException("Arquivo chave.json não foi encontrado.");
            }

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://poo2-952b4-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase inicializado com sucesso.");

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo chave.json não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao inicializar o Firebase: " + e.getMessage());
        }
    }
}
