package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button signin;
    TextView signup;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signin=(Button) findViewById(R.id.in_sign);
        signup=(TextView) findViewById(R.id.up_sign);

        mAuth=FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=email.getText().toString();
                String p=password.getText().toString();
                mAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Sign in successfully!!!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,firstActivity.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Sign in Failed!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,firstActivity.class));
            }
        });

    }
}









//public class MainActivity extends AppCompatActivity {
//    EditText email,password;
//    Button signin;
//    TextView signup;
//    private FirebaseAuth mAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        email=findViewById(R.id.email);
//        password=findViewById(R.id.password);
//        signin=findViewById(R.id.in_sign);
//        signup=findViewById(R.id.up_sign);
//
//        mAuth=FirebaseAuth.getInstance();
//
//        signin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String e=email.getText().toString();
//                String p=password.getText().toString();
//                mAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Sign in successfully!!!", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(MainActivity.this,firstActivity.class));
//                        }
//                        else {
//                            Toast.makeText(MainActivity.this, "Sign in Failed!!!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
//
//
////        sign_in.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                String e=email.getText().toString();
////                String p=password.getText().toString();
////                mAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
////                    @Override
////                    public void onComplete(@NonNull Task<AuthResult> task) {
////                        if(task.isSuccessful()){
////                            Toast.makeText(MainActivity.this, "Sign in successfully!!!", Toast.LENGTH_SHORT).show();
////                            startActivity(new Intent(MainActivity.this,firstActivity.class));
////                        }
////                        else {
////                            Toast.makeText(MainActivity.this, "Sign in Failed!!!", Toast.LENGTH_SHORT).show();
////                        }
////                    }
////                });
////            }
////        });
////
////        sign_up.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                startActivity(new Intent(MainActivity.this,SignUp.class));
////            }
////        });
//
//    }
//
//}
