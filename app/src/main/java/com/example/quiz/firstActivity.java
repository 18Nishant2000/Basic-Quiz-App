package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firstActivity extends AppCompatActivity {

    TextView ques;
    Button choice1,choice2,choice3,choice4;
 //   FirebaseDatabase database=FirebaseDatabase.getInstance();
//    DatabaseReference myRef=database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ques=findViewById(R.id.ques);
        choice1=findViewById(R.id.c1);
        choice2=findViewById(R.id.c2);
        choice3=findViewById(R.id.c3);
        choice4=findViewById(R.id.c4);

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value=dataSnapshot.getValue(String.class);
//                ques.setText(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                Toast.makeText(firstActivity.this, "Failed to read the data", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
