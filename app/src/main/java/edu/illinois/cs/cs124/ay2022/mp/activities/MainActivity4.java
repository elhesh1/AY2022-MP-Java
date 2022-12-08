package edu.illinois.cs.cs124.ay2022.mp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;
import edu.illinois.cs.cs124.ay2022.mp.R;
import edu.illinois.cs.cs124.ay2022.mp.models.Place;
import edu.illinois.cs.cs124.ay2022.mp.models.ResultMightThrow;
import edu.illinois.cs.cs124.ay2022.mp.network.Client;
//import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;
import android.os.Bundle;
import org.osmdroid.util.GeoPoint;
import edu.illinois.cs.cs124.ay2022.mp.R;

public class MainActivity4 extends AppCompatActivity {
  private Button button2;
  String rec = "TEST STRING";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


      button2 = (Button) findViewById(R.id.button2);
      button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          SimpleDateFormat sdf2 = new SimpleDateFormat("EEE");
          String stringDate2 = sdf2.format(new Date());
          System.out.println("Today is: "+stringDate2);
         // openActivity4();

        }
      });


    }




}
