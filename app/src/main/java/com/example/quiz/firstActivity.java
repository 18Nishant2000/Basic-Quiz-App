package com.example.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firstActivity extends AppCompatActivity {

    TextView ques;
    String answer;
    Button choice1,choice2,choice3,choice4;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("questions/0");

        ques=findViewById(R.id.ques);
        choice1=findViewById(R.id.c1);
        choice2=findViewById(R.id.c2);
        choice3=findViewById(R.id.c3);
        choice4=findViewById(R.id.c4);



        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String q=dataSnapshot.child("question").getValue().toString();
                String c1=dataSnapshot.child("choices").child("0").getValue().toString();
                String c2=dataSnapshot.child("choices").child("1").getValue().toString();
                String c3=dataSnapshot.child("choices").child("2").getValue().toString();
                String c4=dataSnapshot.child("choices").child("3").getValue().toString();
                answer=dataSnapshot.child("answer").getValue().toString();
                ques.setText(q);
                choice1.setText(c1);
                choice2.setText(c2);
                choice3.setText(c3);
                choice4.setText(c4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(choice1.getText().toString())){
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(choice2.getText().toString())){
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(choice3.getText().toString())){
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(choice4.getText().toString())){
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        if(answer.equals(choice1.getText().toString()))
//        {
//            choice1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        else if (answer.equals(choice2.getText().toString()))
//        {
//            choice2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        else if (answer.equals(choice3.getText().toString()))
//        {
//            choice3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        else if(answer.equals(choice4.getText().toString()))
//        {
//            choice4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        else
//        {
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//        }
    }
}
