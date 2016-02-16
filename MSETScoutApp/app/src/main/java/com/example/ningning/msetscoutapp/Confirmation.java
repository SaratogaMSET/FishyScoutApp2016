package com.example.ningning.msetscoutapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {
    TextView matchD;
    TextView teamD;
    TextView scouterD;
    TextView spyD;
    TextView reachD;
    TextView crossD;
    TextView highGoalD1;
    TextView lowGoalD1;
    TextView ballD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matchD = (TextView) findViewById(R.id.matchDisplay);
        teamD = (TextView) findViewById(R.id.teamDisplay);
        scouterD = (TextView) findViewById(R.id.scouterDisplay);
        spyD = (TextView) findViewById(R.id.spyDisplay);
        reachD = (TextView) findViewById(R.id.reachDisplay);
        crossD = (TextView) findViewById(R.id.crossDisplay);
        highGoalD1 = (TextView) findViewById(R.id.highGoalDisplay);
        lowGoalD1 = (TextView) findViewById(R.id.lowGoalDisplay);
        ballD = (TextView) findViewById(R.id.ballDisplay);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
            } else {
                matchD.setText(extras.getString("matchText"));
                teamD.setText(extras.getString("teamText"));
                scouterD.setText(extras.getString("scouterText"));
                //  spyD.setText(extras.getString("matchText"));
                // reachD.setText(extras.getString("matchText"));
                //crossD.setText(extras.getString("matchText"));
            }

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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