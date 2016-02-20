package com.example.ningning.msetscoutapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

//part 3 of input activity
public class PostMatch extends Fragment {
    ToggleButton win;
    ToggleButton lose;
    ToggleButton tie;

    Button submit;

    String match;
    View fromAuto;

    EditText notes;
    ToggleButton breach;
    ToggleButton capture;

    EditText points;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_post_match, container, false); // adds PostMatch tab to input activity

        win = (ToggleButton) in.findViewById(R.id.winToggle);
        lose = (ToggleButton) in.findViewById(R.id.loseToggle);
        tie = (ToggleButton) in.findViewById(R.id.tieToggle);

        win.setOnCheckedChangeListener(changeChecker);
        lose.setOnCheckedChangeListener(changeChecker);
        tie.setOnCheckedChangeListener(changeChecker);

      /*  fromAuto = inflater.inflate(R.layout.activity_autonomous, null);
        Log.d("post", "1");
        TextView matchT = (TextView) fromAuto .findViewById(R.id.textView4);
        final String match = matchT.getText().toString();
        Log.d("post", "2");*/

        notes = (EditText) in.findViewById(R.id.notesEdit);
        breach = (ToggleButton) in.findViewById(R.id.breachToggle);
        capture = (ToggleButton) in.findViewById(R.id.captureToggle);
        points = (EditText) in.findViewById(R.id.pointsEdit);

        View auto = inflater.inflate(R.layout.activity_autonomous, null);
       // final TextView matchT = (TextView) auto.findViewById(R.id.setMatchText);
        submit = (Button) in.findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toConfirmation = new Intent(getActivity(), Confirmation.class);

                //from Autonomous
                String match = Input.myBundle.getString("match");
                String team = Input.myBundle.getString("team");
                String scout = Input.myBundle.getString("scout");
                String spy = Input.myBundle.getString("spy");
                String reach = Input.myBundle.getString("reach");
                String high = Input.myBundle.getString("highV");
                String low = Input.myBundle.getString("lowV");
                String balls = Input.myBundle.getString("balls");
                String cross = Input.myBundle.getString("cross");
                toConfirmation.putExtra("matchT", match);
                toConfirmation.putExtra("teamT", team);
                toConfirmation.putExtra("scoutT", scout);
                toConfirmation.putExtra("spyT", spy);
                toConfirmation.putExtra("reachT", reach);
                toConfirmation.putExtra("highT", high);
                toConfirmation.putExtra("lowT", low);
                toConfirmation.putExtra("ballsT", balls);
                toConfirmation.putExtra("crossT", cross);

                //from Teleop
                String sp1 = Input.myBundle.getString("sp1");
                String sp2 = Input.myBundle.getString("sp2");
                String sp3 = Input.myBundle.getString("sp3");
                String sp4 = Input.myBundle.getString("sp4");
                String sp5 = Input.myBundle.getString("sp5");
                String r1 = Input.myBundle.getString("r1");
                String r2 = Input.myBundle.getString("r2");
                String r3 = Input.myBundle.getString("r3");
                String r4 = Input.myBundle.getString("r4");
                String r5 = Input.myBundle.getString("r5");
                String high2 = Input.myBundle.getString("high2");
                String low2 = Input.myBundle.getString("low2");
                String defense = Input.myBundle.getString("tdefense");
                String endgame = Input.myBundle.getString("endgame");
                toConfirmation.putExtra("sp1T", sp1);
                toConfirmation.putExtra("sp2T", sp2);
                toConfirmation.putExtra("sp3T", sp3);
                toConfirmation.putExtra("sp4T", sp4);
                toConfirmation.putExtra("sp5T", sp5);
                toConfirmation.putExtra("r1T", r1);
                toConfirmation.putExtra("r2T", r2);
                toConfirmation.putExtra("r3T", r3);
                toConfirmation.putExtra("r4T", r4);
                toConfirmation.putExtra("r5T", r5);
                toConfirmation.putExtra("high2T", high2);
                toConfirmation.putExtra("low2T", low2);
                toConfirmation.putExtra("tdefenseT", defense);
                toConfirmation.putExtra("endgameT", endgame);

                //from PostMatch
                toConfirmation.putExtra("notesT", notes.getText().toString());
                if (breach.isChecked()) {
                    toConfirmation.putExtra("breachT", "True");
                }
                else {
                    toConfirmation.putExtra("breachT", "False");
                }
                if (capture.isChecked()) {
                    toConfirmation.putExtra("captureT", "True");
                }
                else {
                    toConfirmation.putExtra("captureT", "False");
                }
                if (win.isChecked()) {
                    toConfirmation.putExtra("resultT", "Win");
                }
                else if (lose.isChecked()) {
                    toConfirmation.putExtra("resultT", "Lose");
                }
                else if (tie.isChecked()) {
                    toConfirmation.putExtra("resultT", "Tie");
                }
                else {
                    toConfirmation.putExtra("resultT", "None");
                }
                toConfirmation.putExtra("pointsT", points.getText().toString());
                startActivity(toConfirmation);
            }
        });

        return in;
    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != win) {
                    win.setChecked(false);
                }
                if (buttonView != lose) {
                    lose.setChecked(false);
                }
                if (buttonView != tie) {
                    tie.setChecked(false);
                }
            }
        }
    };
}
