package com.example.ningning.msetscoutapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

//teleop is part 2 of input activity
public class Teleop extends Fragment {
    ToggleButton hang;
    ToggleButton challenge;
    ToggleButton none;

    Button spinnerEasy1;
    Button spinnerMed1;
    Button spinnerHard1;
    Button spinnerDelete1;

    Button spinnerEasy2;
    Button spinnerMed2;
    Button spinnerHard2;
    Button spinnerDelete2;

    Button spinnerEasy3;
    Button spinnerMed3;
    Button spinnerHard3;
    Button spinnerDelete3;

    Button spinnerEasy4;
    Button spinnerMed4;
    Button spinnerHard4;
    Button spinnerDelete4;

    Button spinnerEasy5;
    Button spinnerMed5;
    Button spinnerHard5;
    Button spinnerDelete5;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;

    String r1 = "";
    String r2 = "";
    String r3 = "";
    String r4 = "";
    String r5 = "";

    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    Spinner sp4;
    Spinner sp5;

    Button highHit;
    Button highMiss;
    Button highDelete;
    Button lowHit;
    Button lowMiss;
    Button lowDelete;
    TextView highView;
    TextView lowView;
    public String high = "";
    public String low = "";

    ToggleButton defense;

    Button save;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_teleop, container,false); // adds Teleop tab to input activity

        hang = (ToggleButton) in.findViewById(R.id.hangToggle);
        challenge = (ToggleButton) in.findViewById(R.id.challengeToggle);
        none = (ToggleButton) in.findViewById(R.id.noneToggle);

        hang.setOnCheckedChangeListener(changeChecker);
        challenge.setOnCheckedChangeListener(changeChecker);
        none.setOnCheckedChangeListener(changeChecker);


        textView1 = (TextView) in.findViewById(R.id.ratingText1);
        textView2 = (TextView) in.findViewById(R.id.ratingText2);
        textView3 = (TextView) in.findViewById(R.id.ratingText3);
        textView4 = (TextView) in.findViewById(R.id.ratingText4);
        textView5 = (TextView) in.findViewById(R.id.ratingText5);


        spinnerEasy1 = (Button) in.findViewById(R.id.eBut1);
        spinnerMed1 = (Button) in.findViewById(R.id.mBut1);
        spinnerHard1 = (Button) in.findViewById(R.id.hBut1);
        spinnerDelete1 = (Button) in.findViewById(R.id.xBut1);

        spinnerEasy2 = (Button) in.findViewById(R.id.eBut2);
        spinnerMed2 = (Button) in.findViewById(R.id.mBut2);
        spinnerHard2 = (Button) in.findViewById(R.id.hBut2);
        spinnerDelete2 = (Button) in.findViewById(R.id.xBut2);

        spinnerEasy3 = (Button) in.findViewById(R.id.eBut3);
        spinnerMed3 = (Button) in.findViewById(R.id.mBut3);
        spinnerHard3 = (Button) in.findViewById(R.id.hBut3);
        spinnerDelete3 = (Button) in.findViewById(R.id.xBut3);

        spinnerEasy4 = (Button) in.findViewById(R.id.eBut4);
        spinnerMed4 = (Button) in.findViewById(R.id.mBut4);
        spinnerHard4 = (Button) in.findViewById(R.id.hBut4);
        spinnerDelete4 = (Button) in.findViewById(R.id.xBut4);

        spinnerEasy5 = (Button) in.findViewById(R.id.eBut5);
        spinnerMed5 = (Button) in.findViewById(R.id.mBut5);
        spinnerHard5 = (Button) in.findViewById(R.id.hBut5);
        spinnerDelete5 = (Button) in.findViewById(R.id.xBut5);



        spinnerEasy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1 += "E";
                textView1.setText(r1);
            }
        });

        spinnerMed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1 += "M";
                textView1.setText(r1);
            }
        });

        spinnerHard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1 += "H";
                textView1.setText(r1);
            }
        });

        spinnerDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().length() > 0) {
                    r1 = r1.substring(0, r1.length() -1);
                    textView1.setText(r1);                }
            }
        });

        spinnerEasy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2 += "E";
                textView2.setText(r2);
            }
        });

        spinnerMed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2 += "M";
                textView2.setText(r2);
            }
        });

        spinnerHard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2 += "H";
                textView2.setText(r2);
            }
        });

        spinnerDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView2.getText().length() > 0) {
                    r2 = r2.substring(0, r2.length() -1);
                    textView2.setText(r2);                  }
            }
        });

        spinnerEasy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r3 += "E";
                textView3.setText(r3);
            }
        });

        spinnerMed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r3 += "M";
                textView3.setText(r3);
            }
        });

        spinnerHard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r3 += "H";
                textView3.setText(r3);
            }
        });

        spinnerDelete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView3.getText().length() > 0) {
                    r3 = r3.substring(0, r3.length() -1);
                    textView3.setText(r3);                  }
            }
        });

        spinnerEasy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r4 += "E";
                textView4.setText(r4);
            }
        });

        spinnerMed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r4 += "M";
                textView4.setText(r4);
            }
        });

        spinnerHard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r4 += "H";
                textView4.setText(r4);
            }
        });

        spinnerDelete4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView4.getText().length() > 0) {
                    r4 = r4.substring(0, r4.length() -1);
                    textView4.setText(r4);                  }
            }
        });

        spinnerEasy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r5 += "E";
                textView5.setText(r5);
            }
        });

        spinnerMed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r5 += "M";
                textView5.setText(r5);            }
        });

        spinnerHard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r5 += "H";
                textView5.setText(r5);            }
        });

        spinnerDelete5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView5.getText().length() > 0) {
                    r5 = r5.substring(0, r5.length() -1);
                    textView5.setText(r5);                  }
            }
        });

        highHit = (Button) in.findViewById(R.id.highGoalHitButton2);
        highMiss = (Button) in.findViewById(R.id.highGoalMissButton2);
        highDelete = (Button) in.findViewById(R.id.highGoalDeleteButton2);
        lowHit = (Button) in.findViewById(R.id.lowGoalHitButton2);
        lowMiss = (Button) in.findViewById(R.id.lowGoalMissButton2);
        lowDelete = (Button) in.findViewById(R.id.lowGoalDeleteButton2);

        highView = (TextView) in.findViewById(R.id.highGoalView2);
        lowView = (TextView) in.findViewById(R.id.lowGoalView2);

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


        lowDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lowView.getText().length() > 0) {
                    low = low.substring(0, low.length() -1);
                    lowView.setText(low);
                }
            }
        });

        sp1 = (Spinner)in.findViewById(R.id.spinner1);
        sp2 = (Spinner)in.findViewById(R.id.spinner2);
        sp3 = (Spinner)in.findViewById(R.id.spinner3);
        sp4 = (Spinner)in.findViewById(R.id.spinner4);
        sp5 = (Spinner)in.findViewById(R.id.spinner5);

        defense = (ToggleButton) in.findViewById(R.id.defenseToggle);
        save = (Button)in.findViewById(R.id.saveButton2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Input.myBundle.putString("sp1", sp1.getSelectedItem().toString());
                Input.myBundle.putString("sp2", sp2.getSelectedItem().toString());
                Input.myBundle.putString("sp3", sp3.getSelectedItem().toString());
                Input.myBundle.putString("sp4", sp4.getSelectedItem().toString());
                Input.myBundle.putString("sp5", sp5.getSelectedItem().toString());
                Input.myBundle.putString("r1", r1);
                Input.myBundle.putString("r2", r2);
                Input.myBundle.putString("r3", r3);
                Input.myBundle.putString("r4", r4);
                Input.myBundle.putString("r5", r5);
                Input.myBundle.putString("high2", high);
                Input.myBundle.putString("low2", low);
                if (defense.isChecked()) {
                    Input.myBundle.putString("tdefense", "Yes");
                }
                else {
                    Input.myBundle.putString("tdefense", "No");
                }
                if (hang.isChecked()) {
                    Input.myBundle.putString("endgame", "hang");
                }
                else if (challenge.isChecked()) {
                    Input.myBundle.putString("endgame", "challenge");
                }
                else {
                    Input.myBundle.putString("endgame", "none");
                }
            }
        });
        return in;
    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != hang) {
                    hang.setChecked(false);
                }
                if (buttonView != challenge) {
                    challenge.setChecked(false);
                }
                if (buttonView != none) {
                    none.setChecked(false);
                }
            }
        }
    };
}
