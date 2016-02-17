package com.example.ningning.msetscoutapp;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    String matchT;

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

    public EditText matchText;
    EditText teamText;
    EditText scouterText;
    ToggleButton spyButton;
    ToggleButton reachButton;
    Spinner crossSpinner;

    Button save;
    TextView matchD;
    String spy = "";
    public String high = "";
    public String low = "";


 //   private RoboInfo autoInfo = new RoboInfo();

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_autonomous, container, false); // adds Autonomous tab to input activity

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
                high += "1";
                highView.setText(high);

            }
        });

        highMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                high += "O";
                highView.setText(high);

            }
        });

        highDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highView.getText().length() > 0) {
                    high = high.substring(0, high.length() -1);
                    highView.setText(high);

                }
            }
        });

        lowHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low += "1";
                lowView.setText(low);
            }
        });

        lowMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low += "O";
                lowView.setText(low);
            }
        });


    /*      matchText = (EditText)in.findViewById(R.id.matchNumberEdit);
             //autoInfo.setMatchText(matchText.getText().toString());
            matchT = matchText.getText().toString();

        if (matchText.getText().toString() != null && !matchText.getText().toString().isEmpty()) {
            matchT = matchText.getText().toString();
        }*/

        lowDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lowView.getText().length() > 0) {
                    low = low.substring(0, low.length() -1);
                    lowView.setText(low);
                }
            }
        });

        save = (Button)in.findViewById(R.id.saveButton1);
        matchText = (EditText)in.findViewById(R.id.matchNumberEdit);
        teamText = (EditText) in.findViewById(R.id.teamNumberEdit);
        scouterText = (EditText) in.findViewById(R.id.scouterNameEdit);
        spyButton = (ToggleButton) in.findViewById(R.id.spyToggleButton);
        reachButton = (ToggleButton) in.findViewById(R.id.reachDefenseToggleButton);
        crossSpinner = (Spinner) in.findViewById(R.id.crossDefenseSpinner);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((TextView)getActivity().findViewById(R.id.matchDisplay)).setText(matchText.getText().toString());
             //   View con = inflater.inflate(R.layout.activity_confirmation, null);
              //  TextView text = (TextView) con.findViewById(R.id.matchDisplay);
               // text.append(matchText.getText().toString());
                Input.myBundle.putString("match", matchText.getText().toString());
                Input.myBundle.putString("team", teamText.getText().toString());
                Input.myBundle.putString("scout", scouterText.getText().toString());
                if (spyButton.isChecked()) {
                    Input.myBundle.putString("spy", "Yes");
                }
                else {
                    Input.myBundle.putString("spy", "No");
                }
                if (reachButton.isChecked()) {
                    Input.myBundle.putString("reach", "Yes");
                }
                else {
                    Input.myBundle.putString("reach", "No");
                }
                Input.myBundle.putString("highV", high);
                Input.myBundle.putString("lowV", low);
                if (zero.isChecked()) {
                    Input.myBundle.putString("balls", "0");
                }
                else if (one.isChecked()) {
                    Input.myBundle.putString("balls", "1");
                }
                else if (two.isChecked()) {
                    Input.myBundle.putString("balls", "2");
                }
                else if (three.isChecked()) {
                    Input.myBundle.putString("balls", "3");
                }
                else {
                    Input.myBundle.putString("balls", "none");
                }
                Input.myBundle.putString("cross", crossSpinner.getSelectedItem().toString());
            }
        });


        /*View fromPost = inflater.inflate(R.layout.activity_post_match, null);
        submit = (Button) fromPost.findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toConfirmation = new Intent(getActivity(), Confirmation.class);
                Log.d("auto", "9");
                toConfirmation.putExtra("matchT", matchText.getText().toString());
                Log.d("auto", "10");
                startActivity(toConfirmation);
            }
        });*/



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

   /* @Override
    public RoboInfo getData() {
        Log.d("auto", "1");
        this.autoInfo.matchT = this.matchT; // Assuming subcon has been updated.. else use txt1.getText();
        Log.d("auto", "2");
        return this.autoInfo;
    }

    @Override
    public void setData(RoboInfo workData) {
        Log.d("auto", "3");
        this.autoInfo = workData;
        // Update this page's views with the workData...
        // This assumes the fragment has already been created and txt1 is set to a view
        Log.d("auto", "4");
        this.matchT = workData.matchT; // Actually could just use subCon in workData, but be aware that workData actually points to the Activity's copy (kinda makes getdata redundant.. but I like symmetry and couldn't be bothered making lots of copies of the object).
    }*/

  /*  public static Autonomous newInstance(String a)
    {
        Autonomous fragment=new Autonomous();
        Log.d("auto", "5");
        Bundle bundle=new Bundle();
        bundle.putString("a", "matchText");
        Log.d("auto", "6");
        fragment.setArguments(bundle);
        Log.d("auto", "7");
        return fragment;
    }*/
}


