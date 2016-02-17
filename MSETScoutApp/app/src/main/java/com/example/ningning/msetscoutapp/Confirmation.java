package com.example.ningning.msetscoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity{
    TextView matchD;
    TextView teamD;
    TextView scouterD;
    TextView spyD;
    TextView reachD;
    TextView crossD;
    TextView highGoalD1;
    TextView lowGoalD1;
    TextView ballD;

    //DataUpdate dataUpdate;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

      //  RoboInfo test = new RoboInfo();

        matchD = (TextView) findViewById(R.id.matchDisplay);
        teamD = (TextView) findViewById(R.id.teamDisplay);
        scouterD = (TextView) findViewById(R.id.scouterDisplay);
        spyD = (TextView) findViewById(R.id.spyDisplay);
        reachD = (TextView) findViewById(R.id.reachDisplay);
        crossD = (TextView) findViewById(R.id.crossDisplay);
        highGoalD1 = (TextView) findViewById(R.id.highGoalDisplay);
        lowGoalD1 = (TextView) findViewById(R.id.lowGoalDisplay);
        ballD = (TextView) findViewById(R.id.ballDisplay);
       // matchD.setText(test.getMatchText());

        Bundle bundle = new Bundle();
        final String name = bundle.getString("a");
        matchD.setText(name);

      /*  Log.d("Con", "5");
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            Log.d("Con", "6");
            if (extras == null) {
                Log.d("Con", "7");
            } else {
                matchD.setText(extras.getString("matchT"));
                Log.d("Con", "8");
            }
        }*/
     /*   Log.d("con", "4");
        Input in = new Input();
        Log.d("con", "5");
        matchD.setText(in.inputinfo.getMatchText());
        Log.d("con", "6");*/
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