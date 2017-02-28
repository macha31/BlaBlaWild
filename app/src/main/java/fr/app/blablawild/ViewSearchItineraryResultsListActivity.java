package fr.app.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();

        String depart = intent.getStringExtra("depart");
        String destination = intent.getStringExtra("destination");

        setTitle(depart + " " + getString(R.string.fleche) + " " + destination);




    }
}
