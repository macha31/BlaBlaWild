package fr.app.blablawild;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView textViewEmail;
    private Button buttonLogout;
    private Button buttonMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }

        else {

            FirebaseUser user = firebaseAuth.getCurrentUser();


            textViewEmail = (TextView) findViewById(R.id.textViewEmail);
            buttonLogout = (Button) findViewById(R.id.buttonDisconnect);
            buttonMenu = (Button) findViewById(R.id.buttonMenu);


            textViewEmail.setText("Bienvenue "+user.getEmail());

            buttonLogout.setOnClickListener(this);
            buttonMenu.setOnClickListener(this);
        }}

    @Override
    public void onClick(View view) {

        if(view == buttonLogout){

            firebaseAuth.signOut();

            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }

        if(view == buttonMenu){
            startActivity(new Intent(this, MainActivity.class));
        }
    }

}
