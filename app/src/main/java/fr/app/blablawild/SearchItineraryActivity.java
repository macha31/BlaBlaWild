package fr.app.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SearchItineraryActivity extends AppCompatActivity {
    EditText editTextDeparture;
    EditText editTextDestination;
    EditText editTextDated;
    Button buttonSearch;
    TextView erreur;
    Context context;
    Toast toast;
    int toastDuration;

    public final static String EXTRA_REQUEST = "trip";
    private static final String TAG = "SearchItineraryActivity";
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editTextDeparture = (EditText) findViewById(R.id.editTextDeparture);
        editTextDestination = (EditText) findViewById(R.id.editTextDestination);
        editTextDated = (EditText) findViewById(R.id.editTextDated);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        erreur = (TextView) findViewById(R.id.erreur);
        context = getApplicationContext();
        toast = Toast.makeText(context, getString(R.string.toast), toastDuration);
        toastDuration = Toast.LENGTH_SHORT;

        editTextDated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        SearchItineraryActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year , int month, int day){
                month= month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy" + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                editTextDated.setText(date);
            }
        };

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextDeparture.length() != 0 && editTextDestination.length() != 0) {

                    String depart = editTextDeparture.getText().toString();
                    String destination = editTextDestination.getText().toString();
                    String date = editTextDated.getText().toString();
                    SearchRequestModel trip = new SearchRequestModel(depart, destination, date);
                    Intent myIntent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);

                    myIntent.putExtra(SearchItineraryActivity.EXTRA_REQUEST, trip);
                    startActivity(myIntent);
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.toast);
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });

    }


}
