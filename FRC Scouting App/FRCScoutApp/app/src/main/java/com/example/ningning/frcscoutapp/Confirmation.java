package com.example.ningning.frcscoutapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Confirmation extends Activity {
    TextView displayName;
    TextView displayNumber;
    EditText teamName;
    EditText teamNumber;
    public String sTeamName;
    public String sTeamNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        displayName = (TextView)findViewById(R.id.fTeamName);
        displayNumber = (TextView)findViewById(R.id.fTeamNumber);

        Intent fromMain = getIntent();
        Bundle specInfo = fromMain.getExtras();

        if (specInfo!=null) {
            String sTeamName = (String) specInfo.get("sTeamName");
            displayName.setText(sTeamName);
            String sTeamNumber = (String) specInfo.get("sTeamNumber");
            displayNumber.setText(sTeamNumber);
        }



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
