package com.example.practicemapapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.util.GeoPoint;
import org.w3c.dom.Text;

import android.app.Activity;
import java.util.ArrayList;

public class Navigation extends Activity { //implements OnItemSelectedListener {

    ArrayList<Marker> markerList = MainActivity.getMarkerList();
    String[] markerArray = markerArraylistToArray(markerList);
    ArrayList<GeoPoint> geopointList = MainActivity.getGeoPointsList();
    //double[][] geopointArray = geopointArraylistToArray(geopointList);
    ArrayAdapter adapterStart;
    ArrayAdapter adapterDest;

    Spinner startingPointSpinner;
    Spinner destinationSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);


        startingPointSpinner = findViewById(R.id.StartingPointSpinner);
        destinationSpinner = findViewById(R.id.DestinationSpinner);

        adapterStart = new ArrayAdapter(this, android.R.layout.simple_spinner_item, markerArray);
        adapterStart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startingPointSpinner.setAdapter(adapterStart);

        adapterDest = new ArrayAdapter(this, android.R.layout.simple_spinner_item, markerArray);
        adapterDest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(adapterDest);

        final TextView startTextView = findViewById(R.id.startGeoPoint);
        final TextView destTextView = findViewById(R.id.destGeoPoint);


        startingPointSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int startPosition = startingPointSpinner.getSelectedItemPosition();
                startTextView.setText(startPosition);
                Toast.makeText(getApplicationContext(), markerArray[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            //startTextView.setText(startPosition);

        });

        //startTextView.setText(String.valueOf((long)geopointArray[position][0]));

        final Button goButton = findViewById(R.id.GoButton);
        goButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

            }
        });
    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //startTextView.setText(String.valueOf((long)geopointArray[position][0]));
        //destTextView.setText(String.valueOf((long)geopointArray[position][1]));
        Toast.makeText(getApplicationContext(), markerArray[position], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/

    public String[] markerArraylistToArray(ArrayList<Marker> arr) {
        String[] mArr = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            mArr[i] = arr.get(i).getTitle();
        }
        return mArr;
    }

    public double[][] geopointArraylistToArray(ArrayList<GeoPoint> arr) {
        double[][] gArr = new double[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    gArr[i][j] = arr.get(i).getLatitude();
                } else {
                    gArr[i][j] = arr.get(i).getLongitude();
                }
            }
        }
        return gArr;
    }
}