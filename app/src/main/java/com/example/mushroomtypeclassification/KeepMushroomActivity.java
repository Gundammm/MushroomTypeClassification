package com.example.mushroomtypeclassification;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Keep;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.mushroomtypeclassification.DatabaseHelper.COL_SCIENCE;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_TYPE;

public class KeepMushroomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_mushroom);


    }
}
