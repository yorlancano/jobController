package com.employee_Management.employment.Setting;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration

public class FirebaseSetting {
    @Bean
    public Firestore firebaseSettings() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("./KeyServer.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        FirebaseApp app = null;

        if(FirebaseApp.getApps().isEmpty()){
            app = FirebaseApp.initializeApp(options,"data-api-controller-employee");
        }else{
            app = FirebaseApp.getApps().get(0);
        }
        return FirestoreClient.getFirestore(app);
    }
}
