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

    TextView ques,score;
    String answer;
    Button choice1,choice2,choice3,choice4,next;
    FirebaseDatabase database;
    DatabaseReference myRef;
    int count=0,choice=0,marks;


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
        score=findViewById(R.id.score);
        database=FirebaseDatabase.getInstance();


        choice1.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));
        choice2.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));
        choice3.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));
        choice4.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));

        next_ques(count);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //choice=0;
                reset();
                if(count<=11){
                    count+=1;
                    choice1.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));
                    choice2.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));
                    choice3.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));
                    choice4.setBackgroundColor(getColor(R.color.common_google_signin_btn_text_dark));
                    next_ques(count);
                }
                else {
                    ques.setText("GAME OVER!!");
                    Toast.makeText(firstActivity.this, "GAME OVER!!!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


    void reset()
    {
        choice1.setVisibility(View.VISIBLE);
        choice2.setVisibility(View.VISIBLE);
        choice3.setVisibility(View.VISIBLE);
        choice4.setVisibility(View.VISIBLE);
    }

    void click(int choice)
    {
        if(choice==1){
            choice2.setVisibility(View.INVISIBLE);
            choice3.setVisibility(View.INVISIBLE);
            choice4.setVisibility(View.INVISIBLE);
        }
        else if(choice==2){
            choice1.setVisibility(View.INVISIBLE);
            choice3.setVisibility(View.INVISIBLE);
            choice4.setVisibility(View.INVISIBLE);
        }
        else if(choice==3){
            choice2.setVisibility(View.INVISIBLE);
            choice1.setVisibility(View.INVISIBLE);
            choice4.setVisibility(View.INVISIBLE);
        }
        else{
            choice2.setVisibility(View.INVISIBLE);
            choice3.setVisibility(View.INVISIBLE);
            choice1.setVisibility(View.INVISIBLE);
        }
    }

    void next_ques(int count){
        myRef=database.getReference("questions/"+count);
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
                    choice1.setBackgroundColor(getColor(R.color.colorPrimary));
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    marks+=1;
                }
                else {
                    choice1.setBackgroundColor(getColor(R.color.colorAccent));
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    marks-=1;
                }
                choice=1;
                click(choice);

                score.setText("Score: "+marks);
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(choice2.getText().toString())){
                    choice2.setBackgroundColor(getColor(R.color.colorPrimary));
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    marks+=1;
                }
                else {
                    choice2.setBackgroundColor(getColor(R.color.colorAccent));
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    marks-=1;
                }
                choice=2;
                click(choice);
                score.setText("Score: "+marks);
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(choice3.getText().toString())){
                    choice3.setBackgroundColor(getColor(R.color.colorPrimary));
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    marks+=1;
                }
                else {
                    choice3.setBackgroundColor(getColor(R.color.colorAccent));
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    marks-=1;
                }
                choice=3;
                click(choice);
                score.setText("Score: "+marks);
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(choice4.getText().toString())){
                    choice4.setBackgroundColor(getColor(R.color.colorPrimary));
                    Toast.makeText(firstActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    marks+=1;
                }
                else {
                    choice4.setBackgroundColor(getColor(R.color.colorAccent));
                    Toast.makeText(firstActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    marks-=1;
                }
                choice=4;
                click(choice);
                score.setText("Score: "+marks);
            }
        });

    }
}
