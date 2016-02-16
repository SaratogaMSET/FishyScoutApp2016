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
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

//teleop is part 2 of input activity
public class Teleop extends Fragment {
    ToggleButton hang;
    ToggleButton challenge;
    ToggleButton none;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_teleop, container,false); // adds Teleop tab to input activity

        

        hang = (ToggleButton) in.findViewById(R.id.hangToggle);
        challenge = (ToggleButton) in.findViewById(R.id.challengeToggle);
        none = (ToggleButton) in.findViewById(R.id.noneToggle);

        hang.setOnCheckedChangeListener(changeChecker);
        challenge.setOnCheckedChangeListener(changeChecker);
        none.setOnCheckedChangeListener(changeChecker);

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
