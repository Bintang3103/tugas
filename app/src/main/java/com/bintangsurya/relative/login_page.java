package com.bintangsurya.relative;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;

public class login_page extends AppCompatActivity {

    Button login, register;
    EditText email, password;
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=email.getText().toString();
                pass=password.getText().toString();

                if(user.equals("bintang@gmail.com") && pass.equals("bintang")){
                    Toast.makeText(login_page.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login_page.this, select.class));
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(login_page.this);
                    builder.setMessage("Login Gagal").
                            setNegativeButton("Retry", null).create().show();
                }
            }
        });

        register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_page.this, complete.class));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}