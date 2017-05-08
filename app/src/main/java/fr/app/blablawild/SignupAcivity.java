package fr.app.blablawild;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignupAcivity extends AppCompatActivity implements View.OnClickListener{
    private EditText inputEmail;
    private EditText inputPassword;
    private Button btnSignUp;
    private FirebaseAuth auth;
    private ProgressDialog progressDialog;
    private TextView textViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_acivity);

        auth = FirebaseAuth.getInstance();


        btnSignUp = (Button) findViewById(R.id.buttonRegister);
        inputEmail = (EditText) findViewById(R.id.editTextEmailUser);
        inputPassword = (EditText) findViewById(R.id.editTextPasswordUser);
        textViewSignIn = (TextView) findViewById(R.id.textViewSignin);


        progressDialog = new ProgressDialog(this);


        btnSignUp.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);

    }



    private void registerUser() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Renseigne ton email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Renseigne ton mot de passe", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Inscription en cours...");
        progressDialog.show();



        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignupAcivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(SignupAcivity.this, AccountActivity.class));

                        } else {
                            Toast.makeText(SignupAcivity.this, "Email et mot de passe requis", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();

                    }
                });

    }
    public void onClick(View view) {

        if (view == btnSignUp) {
            registerUser();
        }

        if (view == textViewSignIn) {
            startActivity(new Intent(SignupAcivity.this, ProfileActivity.class));
        }



    }

}