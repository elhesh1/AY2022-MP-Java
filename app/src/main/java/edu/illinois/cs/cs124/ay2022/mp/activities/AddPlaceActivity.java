package edu.illinois.cs.cs124.ay2022.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.illinois.cs.cs124.ay2022.mp.R;
import edu.illinois.cs.cs124.ay2022.mp.models.Place;
import edu.illinois.cs.cs124.ay2022.mp.models.ResultMightThrow;
import edu.illinois.cs.cs124.ay2022.mp.network.Client;
import java.util.function.Consumer;

public class AddPlaceActivity extends AppCompatActivity {
  private static final String TAG = AddPlaceActivity.class.getSimpleName();
  private Consumer<ResultMightThrow<Boolean>> callback;

  @Override
  public void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_addplace);

    // Load the layout for this activity and set the title

    Intent returnToMain = new Intent(this, MainActivity.class);
    returnToMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

    Button cancelButton = findViewById(R.id.cancel_button);
    cancelButton.setOnClickListener(
        v -> {
          startActivity(returnToMain);
        });
    // iiiiiiii
    Intent savePlace = new Intent(this, Place.class);
    Button saveButton = findViewById(R.id.save_button);
    saveButton.setOnClickListener(
        v -> {
          Bundle location = getIntent().getExtras();
          ;;;
          Double mylong = null; // gohafoihaoihagoihafoihasihfoaao
          Double mylat = null;
          if (location != null) {
            String thislong = location.getString("longitude");
            String thislat = location.getString("latitude");
            mylong = Double.parseDouble(thislong);
            mylat = Double.parseDouble(thislat);
          }

          EditText desc = findViewById(R.id.description);
          String mydesc = desc.getText().toString();

          Place myplace =
              new Place("2ec94fdc-60c5-4fe1-8c83-7c43fcf43131", "Elliot", mylat, mylong, mydesc);

          Client.start().postFavoritePlace(myplace, callback);
          startActivity(returnToMain);
        });
  }
}
