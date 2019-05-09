package com.example.practicemapapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;

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
    private int startPosition;
    private int destPosition;


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

        //final TextView startTextView = findViewById(R.id.startGeoPoint);
        //final TextView destTextView = findViewById(R.id.destGeoPoint);


        startingPointSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startPosition = startingPointSpinner.getSelectedItemPosition();
                Toast.makeText(getApplicationContext(), markerArray[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            //startTextView.setText(startPosition);

        });

        destinationSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                destPosition = destinationSpinner.getSelectedItemPosition();
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
                Intent viewMapwD = new Intent(Navigation.this, MainActivity.class);
                viewMapwD.putExtra("start", startPosition);
                viewMapwD.putExtra("dest", destPosition);
                MainActivity.turnDirectionsOn();
                startActivity(viewMapwD);
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
            mArr[i] = arr.get(i).getTitle().split(":")[0];
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