package com.example.ningning.msetscoutapp;

import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

/**
 * Created by Ningning on 2/15/2016.
 */
public class RoboInfo {

 //   String matchT;
   // public RoboInfo() {
        //matchText = (EditText) in.findViewById(R.id.matchNumberEdit);
       // matchT = getSupportFragmentManager().findFragmentById(R.id.autoFrag)
  //  }

   public String matchText;

   public void setMatch(String str) {
      matchText = str;
   }

   public String getMatch() {
      return matchText;
   }


}
