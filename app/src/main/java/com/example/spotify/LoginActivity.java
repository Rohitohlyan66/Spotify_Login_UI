package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    ImageButton eyeToggle;
    Button login,loginWithoutPassword;

    boolean show =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email=findViewById(R.id.mail_edit_text);
        password=findViewById(R.id.password_edit_text);
        eyeToggle=findViewById(R.id.password_toggle);
        login=findViewById(R.id.login_btn);
        loginWithoutPassword=findViewById(R.id.login_without_password);

        eyeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show)
                {
                    show=false;
                    eyeToggle.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                   password.setTransformationMethod(new PasswordTransformationMethod());
                }
                else
                {
                    show=true;
                    eyeToggle.setImageResource(R.drawable.ic_baseline_visibility_24);
                    password.setTransformationMethod(null);
                }
            }
        });

       email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               if (hasFocus)
               {
                    email.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_focus_bg));
                    password.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_bg));
               }
           }
       });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    password.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_focus_bg));
                    email.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_bg));
                }
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             if (!TextUtils.isEmpty(password.getText()) && !TextUtils.isEmpty(s))
             {
                 login.setEnabled(true);
                 login.setClickable(true);
                 login.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                 login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_bg_active));
             }
             else {
                 login.setEnabled(false);
                 login.setClickable(false);
                 login.setTextColor(getResources().getColor(R.color.grey));
                 login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_bg));
             }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(email.getText()) && !TextUtils.isEmpty(s))
                {
                    login.setEnabled(true);
                    login.setClickable(true);
                    login.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_bg_active));
                }
                else {
                    login.setEnabled(false);
                    login.setClickable(false);
                    login.setTextColor(getResources().getColor(R.color.grey));
                    login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_bg));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Logging", Toast.LENGTH_SHORT).show();
            }
        });

        loginWithoutPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Login Without password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}