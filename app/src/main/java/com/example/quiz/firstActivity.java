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
    Button choice1,choice2,choice3,choice4,next;
    FirebaseDatabase database;
    DatabaseReference myRef;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ques=findViewById(R.id.ques);
        choice1=findViewById(R.id.c1);
        choice2=findViewById(R.id.c2);
        choice3=findViewById(R.id.c3);
        choice4=findViewById(R.id.c4);
        next=findViewById(R.id.next);
        database=FirebaseDatabase.getInstance();

        next_ques(count);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<12){
                    count+=1;
                    next_ques(count);
                }
                else {
                    ques.setText("GAME OVER!!");
                    Toast.makeText(firstActivity.this, "GAME OVER!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    void next_ques(int count){
        myRef=database.getReference("questions/"+count);
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String q=dataSnapshot.child("question").getValue().toString();
                String c1="A. "+dataSnapshot.child("choices").child("0").getValue().toString();
                String c2="B. "+dataSnapshot.child("choices").child("1").getValue().toString();
                String c3="C. "+dataSnapshot.child("choices").child("2").getValue().toString();
                String c4="D. "+dataSnapshot.child("choices").child("3").getValue().toString();
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

    }
}
