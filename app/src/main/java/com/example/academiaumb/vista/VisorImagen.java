package com.example.academiaumb.vista;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.academiaumb.R;

import java.io.IOException;

public class VisorImagen extends AppCompatActivity {

    ImageView imgImagen;
    String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);
        getSupportActionBar().hide();
        imgImagen = findViewById(R.id.imgImagen);
        uri = getIntent().getStringExtra("uri");
        try {
            recuperarFoto();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recuperarFoto() throws IOException {
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(uri));
        imgImagen.setImageBitmap(bitmap);
    }
}
