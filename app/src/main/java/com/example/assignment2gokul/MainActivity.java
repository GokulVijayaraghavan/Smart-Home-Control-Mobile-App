package com.example.assignment2gokul;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;

import android.content.pm.PackageManager;

import android.util.Log;
import android.widget.Button;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner gesturebtn;
    public Button select;
    public static int getid;
    public String btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gesturebtn =   findViewById(R.id.gesturebtn);
        String[] items = getResources().getStringArray(R.array.gestures);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gesturebtn.setAdapter(adapter);
        //gesturebtn.setItemChangeListener(this);
        gesturebtn.setOnItemSelectedListener(this);

        select = findViewById(R.id.select);
        select.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                btn = gesturebtn.getSelectedItem().toString();

                next_page(v);
            }
        });
        handlePermissions(MainActivity.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        getid = position;
    }

    public void next_page(View v) {
        Intent intent = new Intent(MainActivity.this, Screen2.class);
    //    intent.putExtra("getid",getid);
        intent.putExtra("getid",getid);
        startActivity(intent);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static void handlePermissions(Activity activity) {

        int storagePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int REQUEST_EXTERNAL_STORAGE = 1;

        String[] PERMISSIONS = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA

        };

        if (storagePermission != PackageManager.PERMISSION_GRANTED) {
            Log.i("log", "Read/Write Permissions needed!");
        }

        ActivityCompat.requestPermissions(
                activity,
                PERMISSIONS,
                REQUEST_EXTERNAL_STORAGE
        );

        Log.i("log", "Permissions Granted!");

    }

    private boolean hasCamera() {

        if (getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY)){
            return true;
        } else {
            return false;
        }
    }
}

