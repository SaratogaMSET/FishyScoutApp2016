package com.example.ningning.frcscoutingtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText fileName;
    EditText inputInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = (EditText)findViewById(R.id.filename);
        inputInfo = (EditText)findViewById(R.id.input);

}
    // write text to file
    public void Export(View v) {
        try {
        File root = new File(Environment.getExternalStorageDirectory(), "Notes");
        // if external memory exists and folder with name Notes
        if (!root.exists()) {
            root.mkdirs(); // this will create folder.
        }
        File filepath = new File(root, fileName.getText().toString() + ".txt");  // file path to save
        FileWriter writer = new FileWriter(filepath);
        writer.append(inputInfo.getText().toString());
        writer.flush();
        writer.close();
        Toast.makeText(getBaseContext(), "File created!",Toast.LENGTH_SHORT).show();
    } catch (IOException e) {
        e.printStackTrace();
        Log.d("file error", "" + e.getMessage());
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
