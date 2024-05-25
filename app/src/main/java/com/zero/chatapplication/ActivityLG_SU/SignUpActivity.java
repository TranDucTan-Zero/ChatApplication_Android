package com.zero.chatapplication.ActivityLG_SU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zero.chatapplication.Helper.HelperClass;
import com.zero.chatapplication.R;

public class SignUpActivity extends AppCompatActivity {
 EditText signName, signEmail, signUserName, signPassword;
 TextView loginTxt;
 Button signBtn;
 FirebaseDatabase database;
 DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signName = findViewById(R.id.signup_name);
        signEmail = findViewById(R.id.signup_email);
        signUserName = findViewById(R.id.signup_username);
        signPassword =findViewById(R.id.signup_password);
        loginTxt = findViewById(R.id.loginTxt);
        signBtn = findViewById(R.id.button_signup);

        //xử lý sự kiêện btn sign (đăng kí)
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signName.getText().toString();
                String email = signEmail.getText().toString();
                String username = signUserName.getText().toString();  // Corrected variable name
                String password = signPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUpActivity.this, "Bạn đã đăng kí thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUpActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}