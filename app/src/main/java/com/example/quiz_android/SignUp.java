package com.example.quiz_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private Button signUp;
    public EditText user;
    public EditText password;
    public EditText cPassword;
    public TextView errorcPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        signUp = findViewById(R.id.signUpButton);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        cPassword = findViewById(R.id.cPassword);
        errorcPassword = findViewById(R.id.errorcPassword);
        BDUser bdu = new BDUser(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(cPassword.getText().toString())) {
                    Log.d("TAG", String.valueOf(password.getText().toString().equals(cPassword.getText().toString())));
                    if(bdu.checkUserExist(user.getText().toString())){
                        User user1 = new User(user.getText().toString(),password.getText().toString());
                        if(bdu.addUser(user1)){
                            Intent intent = new Intent(SignUp.this, Benvinguda.class);
                            startActivity(intent);
                        };
                    }
                    else{
                        errorcPassword.setText("The user already exist");
                    }

                }
                else{
                    errorcPassword.setText("The passwords dosen't match");
                }
            }
        });
    }
}
