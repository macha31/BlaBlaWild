package fr.app.blablawild;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubmitItineraryActivity extends AppCompatActivity {
    public Button ButtonPublish;
    public EditText EditTextDeparture;
    public EditText EditTextDestination;
    public EditText EditTextPrice;
    public EditText EditTextDate;
    public EditText EditTextHoure;
    public FirebaseDatabase database;
    public DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditTextDeparture = (EditText) findViewById(R.id.EditTextDeparture);
        EditTextDestination = (EditText) findViewById(R.id.EditTextDestination);
        EditTextPrice = (EditText) findViewById(R.id.EditTextPrice);
        EditTextDate = (EditText) findViewById(R.id.EditTextDate);
        EditTextHoure = (EditText) findViewById(R.id.EditTextHoure);
        ButtonPublish = (Button) findViewById(R.id.ButtonPublish);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.push().setValue("Hello, World!");

        ButtonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Itinerary");

                if(EditTextDeparture.length() != 0 && EditTextDestination.length() !=0 && EditTextPrice.length() != 0 && EditTextDate.length() != 0 && EditTextHoure.length() != 0) {
                    String LastName = "Devigne";
                    String FirstName = "Arlette";
                    int id = 0;
                    String Departure = EditTextDeparture.getText().toString();
                    String Destination = EditTextDestination.getText().toString();
                    int Price = Integer.parseInt(EditTextPrice.getText().toString());
                    String Date = EditTextDate.getText().toString();
                    String Houre = EditTextHoure.getText().toString();


                    database = FirebaseDatabase.getInstance();
                    myRef = database.getReference("Itinerary");

                    ItineraryModel mItineraryModel = new ItineraryModel(id, LastName, FirstName, Date, Price, Departure, Destination );
                    myRef.push().setValue(mItineraryModel);
                    finish();


                }

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
