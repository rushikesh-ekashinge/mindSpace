package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class SignUp extends AppCompatActivity {
    TextInputLayout regName,regUsername, regPassword, regEmail, regPhone;
    Button signUP_btn,haveAcc_btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        haveAcc_btn = findViewById(R.id.btn_haveAcc);
        regName = findViewById(R.id.txtv_name);
        regUsername = findViewById(R.id.txtv_uname);
        regPassword = findViewById(R.id.txtv_pass);
        regEmail = findViewById(R.id.txtv_email);
        regPhone = findViewById(R.id.txtv_phone);
        signUP_btn = findViewById(R.id.btn_signUp);

        signUP_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");

                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phone = regPhone.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name,username,email,phone,password);
                reference.child(username).setValue(helperClass);
            }
        });

        haveAcc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,Login_page.class);
                startActivity(intent);
                finish();
            }
        });
    }
}