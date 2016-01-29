package com.example.ningning.frcscoutapp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
        import java.io.Writer;

public class Confirmation extends Activity {
    TextView displayMatch;
    TextView displayNumber;
    TextView displayDef1;
    TextView displayDef2;
    TextView displayDef3;
    TextView displayDef4;
    TextView displayDef5;
    public String sMatchNum;
    public String sTeamNumber;
    public String sDef1;
    public String sDef2;
    public String sDef3;
    public String sDef4;
    public String sDef5;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        displayMatch = (TextView)findViewById(R.id.fMatchNum);
        displayNumber = (TextView)findViewById(R.id.fTeamNumber);
       /* displayDef1 = (TextView)findViewById(R.id.fDef1);
        displayDef2 = (TextView)findViewById(R.id.fDef2);
        displayDef3 = (TextView)findViewById(R.id.fDef3);
        displayDef4 = (TextView)findViewById(R.id.fDef4);
        displayDef5 = (TextView)findViewById(R.id.fDef5); */
        submit = (Button)findViewById(R.id.finalSubmit);

        Intent fromMain = getIntent();
        Bundle specInfo = fromMain.getExtras();

        if (specInfo!=null) {
            sMatchNum = (String) specInfo.get("matchNum");
            displayMatch.setText(sMatchNum);
            sTeamNumber = (String) specInfo.get("teamNum");
            displayNumber.setText(sTeamNumber);
            sDef1 = (String) specInfo.get("defense1");
            displayDef1.setText(sDef1);
            sDef2 = (String) specInfo.get("defense2");
            displayDef2.setText(sDef2);
            sDef3 = (String) specInfo.get("defense3");
            displayDef3.setText(sDef3);
            sDef4 = (String) specInfo.get("defense4");
            displayDef4.setText(sDef4);
            sDef5 = (String) specInfo.get("defense5");
            displayDef5.setText(sDef5);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                    System.out.print(root);
                    // if external memory exists and folder with name Notes
                    if (!root.exists()) {
                        root.mkdirs(); // this will create folder.
                    }
                    File filepath = new File(root, "robo.txt");  // file path to save
                    Writer writer = new FileWriter(filepath);
                    writer.append(sMatchNum + ", " + sTeamNumber + ", " + sDef1 + ", " + sDef1 + ", " + sDef2 + ", " + sDef3 + ", " + sDef4 + ", " + sDef5 + " ");
                    writer.flush();
                    writer.close();
                    Toast.makeText(getBaseContext(), "File updated!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("file error", "" + e.getMessage());
                }

                Intent backToHome = new Intent(Confirmation.this, HomeMenu.class);
                startActivity(backToHome);
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