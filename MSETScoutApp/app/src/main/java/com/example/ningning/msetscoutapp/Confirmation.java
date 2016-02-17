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

    TextView sp1;
    TextView sp2;
    TextView sp3;
    TextView sp4;
    TextView sp5;
    TextView r1;
    TextView r2;
    TextView r3;
    TextView r4;
    TextView r5;

    TextView highGoalD2;
    TextView lowGoalD2;
    TextView defense;
    TextView endGame;

    TextView notes;
    TextView breach;
    TextView capture;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

      //  RoboInfo test = new RoboInfo();

        //Auto display
        matchD = (TextView) findViewById(R.id.matchDisplay);
        teamD = (TextView) findViewById(R.id.teamDisplay);
        scouterD = (TextView) findViewById(R.id.scouterDisplay);
        spyD = (TextView) findViewById(R.id.spyDisplay);
        reachD = (TextView) findViewById(R.id.reachDisplay);
        crossD = (TextView) findViewById(R.id.crossDisplay);
        highGoalD1 = (TextView) findViewById(R.id.highGoalDisplay);
        lowGoalD1 = (TextView) findViewById(R.id.lowGoalDisplay);
        ballD = (TextView) findViewById(R.id.ballDisplay);

        //Tele display
        sp1 = (TextView) findViewById(R.id.tspinnerDisplay1);
        sp2 = (TextView) findViewById(R.id.tspinnerDisplay2);
        sp3 = (TextView) findViewById(R.id.tspinnerDisplay3);
        sp4 = (TextView) findViewById(R.id.tspinnerDisplay4);
        sp5 = (TextView) findViewById(R.id.tspinnerDisplay5);
        r1 = (TextView) findViewById(R.id.ratingDisplay1);
        r2 = (TextView) findViewById(R.id.ratingDisplay2);
        r3 = (TextView) findViewById(R.id.ratingDisplay3);
        r4 = (TextView) findViewById(R.id.ratingDisplay4);
        r5 = (TextView) findViewById(R.id.ratingDisplay5);
        highGoalD2 = (TextView) findViewById(R.id.highGoalDisplay2);
        lowGoalD2 = (TextView) findViewById(R.id.lowGoalDisplay2);
        defense = (TextView) findViewById(R.id.defenseDisplay);
        endGame = (TextView) findViewById(R.id.endGameDisplay);

        //Post Match display
        notes = (TextView) findViewById(R.id.notesDisplay);
        breach = (TextView) findViewById(R.id.breachDisplay);
        capture = (TextView) findViewById(R.id.captureDisplay);
        result = (TextView) findViewById(R.id.resultDisplay);

      //  matchD.setText();
       // matchD.setText(test.getMatchText());

      /*  Bundle bundle = new Bundle();
        final String name = bundle.getString("a");
        matchD.setText(name);

        Log.d("Con", "5");*/
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            Log.d("Con", "6");
            if (extras == null) {
                Log.d("Con", "7");
            } else {

                //from Autonomous
                matchD.setText(extras.getString("matchT"));
                teamD.setText(extras.getString("teamT"));
                scouterD.setText(extras.getString("scoutT"));
                spyD.setText(extras.getString("spyT"));
                reachD.setText(extras.getString("reachT"));
                highGoalD1.setText(extras.getString("highT"));
                lowGoalD1.setText(extras.getString("lowT"));
                ballD.setText(extras.getString("ballsT"));
                crossD.setText(extras.getString("crossT"));

                //from Teleop
                sp1.setText(extras.getString("sp1T"));
                sp2.setText(extras.getString("sp2T"));
                sp3.setText(extras.getString("sp3T"));
                sp4.setText(extras.getString("sp4T"));
                sp5.setText(extras.getString("sp5T"));
                r1.setText(extras.getString("r1T"));
                r2.setText(extras.getString("r2T"));
                r3.setText(extras.getString("r3T"));
                r4.setText(extras.getString("r4T"));
                r5.setText(extras.getString("r5T"));
                highGoalD2.setText(extras.getString("high2T"));
                lowGoalD2.setText(extras.getString("low2T"));
                defense.setText(extras.getString("tdefenseT"));
                endGame.setText(extras.getString("endgameT"));

                //from PostMatch
                notes.setText(extras.getString("notesT"));
                breach.setText(extras.getString("breachT"));
                capture.setText(extras.getString("captureT"));
                result.setText(extras.getString("resultT"));
            }
        }
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