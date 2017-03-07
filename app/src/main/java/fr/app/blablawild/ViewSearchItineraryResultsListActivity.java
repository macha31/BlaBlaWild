package fr.app.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    SearchRequestModel date;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent  intent = getIntent();
        date =intent.getParcelableExtra(SearchItineraryActivity.EXTRA_REQUEST);

        Toast.makeText(this , date.getmDate(), Toast.LENGTH_LONG).show();

        this.setTitle(date.getmVilleDepart() + " " + getString(R.string.arrow) + " " + date.getmVilleDestination());

       // String depart = intent.getStringExtra("departure");
      //  String destination = intent.getStringExtra("destination");

       // setTitle(depart + " " + getString(R.string.arrow) + " " + destination);
    }


}
