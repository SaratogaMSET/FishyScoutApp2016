package com.example.ningning.frcscoutapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    Button submit;
    EditText teamName;
    EditText teamNumber;
    EditText highGoal;
    ToggleButton lowGoal;
    CheckBox a, b, c, d, e;
    RatingBar rating;
    EditText hang;
    EditText totalPoints;
    public String sTeamName;
    public String sTeamNumber;
    public String sHighGoal;
    public String sHang;
    public String sTotalP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamName = (EditText)findViewById(R.id.editTeamName);
        teamNumber = (EditText)findViewById(R.id.editTeamNumber);
        highGoal = (EditText)findViewById(R.id.editHighGoal);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toConfirmation = new Intent(MainActivity.this, Confirmation.class);
                toConfirmation.putExtra("sTeamName",teamName.getText().toString());
                toConfirmation.putExtra("sTeamNumber", teamNumber.getText().toString());
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
