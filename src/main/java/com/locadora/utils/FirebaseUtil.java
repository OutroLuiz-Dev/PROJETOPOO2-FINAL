package com.locadora.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.io.InputStream;

public class FirebaseUtil {

    private static boolean initialized = false;

    public static void initFirebase() {
        if (initialized) {
            return;
        }

        try {

            InputStream serviceAccount = FirebaseUtil.class.getClassLoader().getResourceAsStream("chave.json");


            if (serviceAccount == null) {
                throw new IOException("Arquivo de credenciais chave.json não encontrado.");
            }

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://poo2-952b4-default-rtdb.firebaseio.com")
                    .build();


            FirebaseApp.initializeApp(options);
            initialized = true;

            System.out.println("Firebase inicializado com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro ao inicializar o Firebase: " + e.getMessage());
        }
    }
}
