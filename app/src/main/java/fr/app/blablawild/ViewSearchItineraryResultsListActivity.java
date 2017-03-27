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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    SearchRequestModel date;
    Intent intent;
    ListView mListViewResults;
    DatabaseReference dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();
        date =intent.getParcelableExtra(SearchItineraryActivity.EXTRA_REQUEST);

        Toast.makeText(this , date.getmDate(), Toast.LENGTH_LONG).show();

        this.setTitle(date.getmVilleDepart() + " " + getString(R.string.arrow) + " " + date.getmVilleDestination());

       // String depart = intent.getStringExtra("departure");
      //  String destination = intent.getStringExtra("destination");

       // setTitle(depart + " " + getString(R.string.arrow) + " " + destination);

        // [...]
        dataBase = FirebaseDatabase.getInstance().getReference("Itinerary");
        TripResultAdapter tripResultAdapter = new TripResultAdapter(dataBase, this, R.layout.trip_item);
        mListViewResults = (ListView) findViewById(R.id.driveList);

        //mResultsAdapter = new TripResultAdapter(this, new TripResultModel());

        mListViewResults.setAdapter(tripResultAdapter);

        // [...]
    }


}
