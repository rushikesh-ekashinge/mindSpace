package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {
    Button takeTestBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);


        takeTestBtn = (Button) findViewById(R.id.takeTestBtn);
        takeTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTestPage();
            }
        });
    }

    protected void openTestPage() {
        Intent testPage = new Intent(this, MainActivity.class);
        startActivity(testPage);
    }
}