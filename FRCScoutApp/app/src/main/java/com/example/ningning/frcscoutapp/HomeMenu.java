package com.example.ningning.frcscoutapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeMenu extends Activity {
    TextView title;
    Button input;
    Button viewer;
    Button match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

       // Typeface titleFont = Typeface.createFromAsset(getAssets(), "fonts/Anton.ttf");
       // title = (TextView)findViewById(R.id.menuTitle);
       // input = (Button)findViewById(R.id.inputButton);
       // viewer = (Button)findViewById(R.id.viewerButton);
       // match = (Button)findViewById(R.id.matchButton);

       // title.setTypeface(titleFont);
       // input.setTypeface(titleFont);
       // viewer.setTypeface(titleFont);
       // match.setTypeface(titleFont);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSpecs = new Intent(HomeMenu.this, MainActivity.class);
                startActivity(toSpecs);

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
