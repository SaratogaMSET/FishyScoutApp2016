package com.example.ningning.msetscoutapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

//part 1 of input activity
public class Autonomous extends Fragment {
    ToggleButton zero;
    ToggleButton one;
    ToggleButton two;
    ToggleButton three;

    Button highHit;
    Button highMiss;
    Button highDelete;
    Button lowHit;
    Button lowMiss;
    Button lowDelete;
    TextView highView;
    TextView lowView;

    Button submit;

    static

    EditText matchText;
    EditText teamText;
    EditText scouterText;
    ToggleButton spyButton;
    ToggleButton reachButton;
    Spinner crossSpinner;


    public static final String ARG_OBJECT = "object";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_autonomous, container,false); // adds Autonomous tab to input activity

        //set up radiogroup-like behaviors for toggle buttons
        zero = (ToggleButton) in.findViewById(R.id.zeroBallsToggle);
        one = (ToggleButton) in.findViewById(R.id.oneBallsToggle);
        two = (ToggleButton) in.findViewById(R.id.twoBallsToggle);
        three = (ToggleButton) in.findViewById(R.id.threeBallsToggle);

        zero.setOnCheckedChangeListener(changeChecker);
        one.setOnCheckedChangeListener(changeChecker);
        two.setOnCheckedChangeListener(changeChecker);
        three.setOnCheckedChangeListener(changeChecker);

        highHit = (Button) in.findViewById(R.id.highGoalHitButton1);
        highMiss = (Button) in.findViewById(R.id.highGoalMissButton1);
        highDelete = (Button) in.findViewById(R.id.highGoalDeleteButton1);
        lowHit = (Button) in.findViewById(R.id.lowGoalHitButton1);
        lowMiss = (Button) in.findViewById(R.id.lowGoalMissButton1);
        lowDelete = (Button) in.findViewById(R.id.lowGoalDeleteButton1);

        highView = (TextView) in.findViewById(R.id.highGoalView1);
        lowView = (TextView) in.findViewById(R.id.lowGoalView1);

        highHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highView.append("1");
            }
        });

        highMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highView.append("O");
            }
        });

        highDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highView.getText().length() > 0) {
                    highView.setText(highView.getText().subSequence(0, highView.getText().length() - 1));
                }
            }
        });

        lowHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowView.append("1");
            }
        });

        lowMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowView.append("O");
            }
        });

        lowDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lowView.getText().length() > 0) {
                    lowView.setText(lowView.getText().subSequence(0, lowView.getText().length() - 1));
                }
            }
        });
        matchText = (EditText) in.findViewById(R.id.matchNumberEdit);
        Intent toActivity = new Intent(getActivity().getBaseContext(), Input.class);
        toActivity.putExtra("matchText", matchText.getText().toString());

        return in;
    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != zero) {
                    zero.setChecked(false);
                }
                if (buttonView != one) {
                    one.setChecked(false);
                }
                if (buttonView != two) {
                    two.setChecked(false);
                }
                if (buttonView != three) {
                    three.setChecked(false);
                }
            }
        }
    };

}
