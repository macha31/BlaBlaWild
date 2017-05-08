package fr.app.blablawild;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputEmail;
    private EditText inputPassword;
    private FirebaseAuth auth;
    private Button btnSignup;
    private Button btnLogin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            finish();
        }



        inputEmail = (EditText) findViewById(R.id.editTextEmailLogin);
        inputPassword = (EditText) findViewById(R.id.editTextPasswordLogin);
        btnSignup = (Button) findViewById(R.id.buttonInscription);
        btnLogin = (Button) findViewById(R.id.buttonLogin);

        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);

    }


    private void userLogin() {
        String email = inputEmail.getText().toString().trim();
        final String password = inputPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(ProfileActivity.this,"Renseigne ton email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(ProfileActivity.this,"Renseigne ton mot de passe",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Accès au compte...");
        progressDialog.show();


        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(ProfileActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), AccountActivity.class));

                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            userLogin();
        }

        if (view == btnSignup) {
            finish();
            startActivity(new Intent(ProfileActivity.this, SignupAcivity.class));

        }

    }
}

