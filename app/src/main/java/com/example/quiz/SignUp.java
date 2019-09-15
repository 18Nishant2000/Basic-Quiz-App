package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    EditText email,password;
    Button signup;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        signup=findViewById(R.id.button);

        mAuth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=email.getText().toString();
                String p=password.getText().toString();

                startActivity(new Intent(SignUp.this,firstActivity.class));
//                mAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(SignUp.this, "Registered Successfully...", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(SignUp.this,firstActivity.class));
//                        }
//                        else {
//                            Toast.makeText(SignUp.this, "Failed!!!", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });
            }
        });

    }
}
