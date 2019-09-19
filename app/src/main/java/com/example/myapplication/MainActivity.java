package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    Spinner CtrlSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CtrlSpinner = (Spinner) findViewById(R.id.spinner1);

        CtrlSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                if (pos ==1)
                {
                    Toast.makeText(parent.getContext(),
                            "Has elegido español", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("es");
                }else if(pos ==2) {
                    Toast.makeText(parent.getContext(),
                            "You selected english", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("en");

                }else if (pos ==3){
                    Toast.makeText(parent.getContext(),
                            "you selected french", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("fr");

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void setLocale(String lang){

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale=myLocale;
        res.updateConfiguration(conf,dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);

    }

}

