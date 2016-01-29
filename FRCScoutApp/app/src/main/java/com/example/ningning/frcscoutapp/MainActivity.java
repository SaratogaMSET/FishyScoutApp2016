package com.example.ningning.frcscoutapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    Button submit;
    Spinner dDown1;
    Spinner dDown2;
    Spinner dDown3;
    Spinner dDown4;
    Spinner dDown5;
    String def1;
    String def2;
    String def3;
    String def4;
    String def5;
    EditText match;
    EditText tNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        match = (EditText)findViewById(R.id.editMatchNum);
        tNumber = (EditText)findViewById(R.id.editTeamNumber);

        dDown1 = (Spinner)findViewById(R.id.Ddown1);
        def1 = String.valueOf(dDown1.getSelectedItem());
        dDown2 = (Spinner)findViewById(R.id.Ddown2);
        def2 = String.valueOf(dDown2.getSelectedItem());
        dDown3 = (Spinner)findViewById(R.id.Ddown3);
        def3 = String.valueOf(dDown3.getSelectedItem());
        dDown4 = (Spinner)findViewById(R.id.Ddown4);
        def4 = String.valueOf(dDown4.getSelectedItem());
        dDown5 = (Spinner)findViewById(R.id.Ddown5);
        def5 = String.valueOf(dDown5.getSelectedItem());
        submit = (Button) findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toConfirmation = new Intent(MainActivity.this, Confirmation.class);
                toConfirmation.putExtra("defense1", String.valueOf(dDown1.getSelectedItem()).toString());
                toConfirmation.putExtra("defense2", String.valueOf(dDown2.getSelectedItem()).toString());
                toConfirmation.putExtra("defense3", String.valueOf(dDown3.getSelectedItem()).toString());
                toConfirmation.putExtra("defense4", String.valueOf(dDown4.getSelectedItem()).toString());
                toConfirmation.putExtra("defense5", String.valueOf(dDown5.getSelectedItem()).toString());
                toConfirmation.putExtra("matchNum", match.getText().toString());
                toConfirmation.putExtra("teamNum", tNumber.getText().toString());
                startActivity(toConfirmation);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
