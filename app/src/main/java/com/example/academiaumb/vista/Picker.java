package com.example.academiaumb.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class Picker  extends AppCompatActivity {
    Button btPicker;
    TextView textView;
    String latitude;
    String lotitud;
    int PLACE_PICKER_REQUEST =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_picker);
        btPicker = findViewById(R.id.bt_picker);
        textView = findViewById(R.id.text_view);


        btPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder;
                builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(Picker.this),PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST){
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data,this);
                StringBuilder stringBuilder = new StringBuilder();
                latitude = String.valueOf(place.getLatLng().latitude);
                lotitud = String.valueOf(place.getLatLng().longitude);
                stringBuilder.append("Latitud:");
                stringBuilder.append(latitude);
                stringBuilder.append("longitud:");
                stringBuilder.append(lotitud);
                textView.setText(stringBuilder.toString());

            }



        }
    }

}
