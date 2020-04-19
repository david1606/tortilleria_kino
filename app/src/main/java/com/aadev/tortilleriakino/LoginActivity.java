package com.aadev.tortilleriakino;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout emailInputEditText, passwordInputEditText;
    private FirebaseAuth mAuth;
    private String emailStr, passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        emailInputEditText = findViewById(R.id.text_input_email);
        passwordInputEditText = findViewById(R.id.text_input_password);

        Button nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                if (checkEmpty(emailInputEditText)) {
                    a++;
                }
                if (checkEmpty(passwordInputEditText)) {
                    a++;
                }

                if (a == 0) {
                    emailStr = Objects.requireNonNull(emailInputEditText.getEditText()).getText().toString();
                    passwordStr = Objects.requireNonNull(passwordInputEditText.getEditText()).getText().toString();
                    signIn();
                }

            }
        });

    }

    private void signIn() {
        mAuth.signInWithEmailAndPassword(emailStr, passwordStr).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    Intent main = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main);
                    finish();
                } else {
                    Log.w("TAG", "signInWithEmail:failure", task.getException());
                    Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    checkError(Objects.requireNonNull(Objects.requireNonNull(task.getException()).getMessage()));
                }
            }
        });
    }

    private void checkError(String error) {
        //There is no user record corresponding to this identifier. The user may have been deleted.
        //We have blocked all requests from this device due to unusual activity. Try again later. [ Too many unsuccessful login attempts. Please try again later. ]
        //The password is invalid or the user does not have a password
        switch (error) {
            case "There is no user record corresponding to this identifier. The user may have been deleted.":
                emailInputEditText.setError("Correo no registrado");
                break;
            case "We have blocked all requests from this device due to unusual activity. Try again later. [ Too many unsuccessful login attempts. Please try again later. ]":
                emailInputEditText.setError("Actividad inusual, dispositivo bloqueado temporalmente");
                break;
            case "The password is invalid or the user does not have a password.":
                passwordInputEditText.setError("Incorrecta");
                break;
            case "The email address is badly formatted.":
                emailInputEditText.setError("Esto no parece un correo");
                break;
            default:
                emailInputEditText.setError("An unknown error occurred!");
                passwordInputEditText.setError("An unknown error occurred!");
                break;
        }
    }

    private boolean checkEmpty(TextInputLayout textInputLayout) {
        String checkText =
                Objects.requireNonNull(textInputLayout.getEditText()).getText().toString().trim();

        if (checkText.isEmpty()) {
            textInputLayout.setError("Campo vacio!");
            //progressBar.setVisibility(View.GONE);
            return true;
        } else {
            textInputLayout.setError(null);
            return false;
        }
    }
}
