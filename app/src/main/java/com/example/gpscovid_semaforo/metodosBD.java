package com.example.gpscovid_semaforo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class metodosBD {

    private DatabaseReference mDatabase;

    public void ReadAndWriteSnippets(DatabaseReference database) {
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]
    }

}
