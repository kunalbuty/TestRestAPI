package com.main.restAPI;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AuthUser {

    private String idToken;

    public AuthUser(String token) {
        this.idToken = token;
    }

    public String authorize() {
        FileInputStream serviceAccount = null;
        FirebaseOptions options = null;
        String uid;


        //following try catch block initializes firebase SDK and imports Service account credentials from PC
        try {
            serviceAccount = new FileInputStream("C:\\Users\\Kunal\\Downloads\\firebase_PK.json");
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://bugtrackerkunal.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
        //handle case for if idToken is null
        if(idToken==null || idToken.equals("")) {
            System.out.println("id token is null or empty");
            return null;
        }

        //verify idToken
        FirebaseToken decodedToken = null;
        try {

            decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            uid = decodedToken.getUid();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return null;
        }
        return uid;
    }
}
