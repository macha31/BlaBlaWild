package fr.app.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    SearchRequestModel date;
    Intent intent;
    ListView mListViewResults;
    ListAdapter mResultsAdapter;


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

        // [...]
        mListViewResults = (ListView) findViewById(R.id.driveList);
        ArrayList<TripResultModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        mResultsAdapter = new TripResultAdapter(this, results);

        mListViewResults.setAdapter(mResultsAdapter);

        // [...]
    }


}
