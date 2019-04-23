package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button library_button = findViewById(R.id.library_button);
        library_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, LibraryMushroomActivity.class);
                startActivity(intent);
            }
        });

        ImageView classify_button = findViewById(R.id.classify_button);
        classify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this,CameraAPIActivity.class);
                startActivity(intent);
            }
        });

        Button keep_button = findViewById(R.id.keep_button);
        keep_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainPageActivity.this,KeepMushroomActivity.class);
                startActivity(intent);
            }
        });

        Button firstAid_button = findViewById(R.id.firstaid_button);
        firstAid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainPageActivity.this,FirstAidActivity.class);
                startActivity(intent);
            }
        });

        Button path = findViewById(R.id.ngrokButton);
        path.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this,EditNgrokPathActivity.class);
                startActivity(intent);
            }
        });
//
//        Button show = findViewById(R.id.showButton);
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainPageActivity.this,NgrokActivity.class);
//                startActivity(intent);
//            }
//        });


    }
}
