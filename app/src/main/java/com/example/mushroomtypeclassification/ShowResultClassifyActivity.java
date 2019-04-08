package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.mushroomtypeclassification.DatabaseHelper.COL_DETAIL;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_ID;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_IMAGE;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_SCIENCE;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_THAI;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_TYPE;
import static com.example.mushroomtypeclassification.DatabaseHelper.MUSHROOM_TABLE;

public class ShowResultClassifyActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result_classify);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        TextView sciText = findViewById(R.id.sciName);
        sciText.setText(result);

        mHelper = new DatabaseHelper(ShowResultClassifyActivity.this);
        mDb = mHelper.getWritableDatabase();

        loadMushroomData(result);

        ImageView back = findViewById(R.id.backtomain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowResultClassifyActivity.this,MainPageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadMushroomData(String Result){
        Cursor c = mDb.query(MUSHROOM_TABLE, null, null, null, null, null, null);
        String result ="";
        TextView thaiText = findViewById(R.id.thaiName);
        TextView sciText = findViewById(R.id.sciName);
        TextView typeText = findViewById(R.id.typeText);

        int checkUnderScore = Result.indexOf("_");
        String nameMushroom = "";
        if(checkUnderScore!=-1){
            nameMushroom = Result.substring(0,checkUnderScore);
        }
        else{ nameMushroom = Result; }

        while (c.moveToNext()) {
            final String science = c.getString(c.getColumnIndex(COL_SCIENCE));
            String newTxtDB="";
            String[] scienceTxt = science.split(" ");
            for(int i=0;i<scienceTxt.length;i++){
                newTxtDB+=scienceTxt[i];
            }

            String newNameMushroom = nameMushroom.substring(0,nameMushroom.length()-1);
            if(newNameMushroom.equalsIgnoreCase(newTxtDB)){
                long id = c.getLong(c.getColumnIndex(COL_ID));
                final String thai = c.getString(c.getColumnIndex(COL_THAI));
                final String image = c.getString(c.getColumnIndex(COL_IMAGE));
                final String type = c.getString(c.getColumnIndex(COL_TYPE));
                final String detail = c.getString(c.getColumnIndex(COL_DETAIL));

                thaiText.setText(thai);
                sciText.setText(science);
                if(type.equalsIgnoreCase("poisonous")){
                    typeText.setText("เห็ดพิษ");
                }
                else if(type.equalsIgnoreCase("eat")){
                    typeText.setText("เห็ดรับประทานได้");
                }
                loadDataFromAsset(image);
                Button detailButton = findViewById(R.id.detail_button);
                detailButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ShowResultClassifyActivity.this,ShowDetailActivity.class);
                        intent.putExtra("science",science);
                        intent.putExtra("thai",thai);
                        intent.putExtra("type",type);
                        intent.putExtra("detail",detail);
                        intent.putExtra("image",image);
                        startActivity(intent);
                    }
                });
            }
        }
        c.close();
    }

    public void loadDataFromAsset(String Filename) {
        // load image
        ImageView mushroomImage = findViewById(R.id.circle_image);
        try {
            InputStream ims = getAssets().open(Filename);
            Drawable d = Drawable.createFromStream(ims, null);
            mushroomImage.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }
}
