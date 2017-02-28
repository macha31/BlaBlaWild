package fr.app.blablawild;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {
    EditText editText7;
    EditText editText8;
    EditText editText9;
    Button button;
    TextView erreur;
    Context context;
    Toast toast;
    int toastDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        button = (Button) findViewById(R.id.button);
        erreur = (TextView) findViewById(R.id.erreur);
        context = getApplicationContext();
        toast = Toast.makeText(context, getString(R.string.toast), toastDuration);
        toastDuration = Toast.LENGTH_SHORT;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (editText7.length() != 0 && editText8.length() != 0) {
                    Intent myIntent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    String depart = editText7.getText().toString();
                    String destination = editText8.getText().toString();

                    myIntent.putExtra("depart", depart);
                    myIntent.putExtra("destination", destination);
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
