package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView sci1Text;
    private TextView thaiText;
    private ImageView Image;
    private ImageView typeImage;
    private TextView detailText;
    private TextView detailText_1;
    private TextView detailText_2;
    private TextView detailText_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        ImageView back = findViewById(R.id.backtomain_detail);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowDetailActivity.this,MainPageActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String science_name = intent.getStringExtra("science");
        String thai_name = intent.getStringExtra("thai");
        String detail = intent.getStringExtra("detail");

        sci1Text = findViewById(R.id.sci1_textView);
        thaiText = findViewById(R.id.thai_textView);
        Image = findViewById(R.id.pic_imageView);
        detailText = findViewById(R.id.detail_textView);
        detailText_1 = findViewById(R.id.detail_1);
        detailText_2 = findViewById(R.id.detail_2);
        detailText_3 = findViewById(R.id.detail_3);
        typeImage = findViewById(R.id.typeImage);

        sci1Text.setText(science_name);
        thaiText.setText(thai_name);
        //detailText.setText(detail);


        Boolean found_1;
        Boolean found_2;
        Boolean found_3;
        found_1 = detail.contains("-1-");
        found_2 = detail.contains("-2-");
        found_3 = detail.contains("-3-");


        if(found_1==false){
            detailText.setText("     "+detail);
        }
        else{
            detailText.setText("     "+detail.substring(0,detail.indexOf("-1-")));
            if(found_2==true){
                detailText_1.setText("     "+detail.substring(detail.indexOf("-1-")+4, detail.indexOf("-2-")));
                if(found_3==true){
                    detailText_2.setText("     "+detail.substring(detail.indexOf("-2-")+4, detail.indexOf("-3-")));
                    detailText_3.setText("     "+detail.substring(detail.indexOf("-3-")+4));
                }
                else {
                    detailText_2.setText("     "+detail.substring(detail.indexOf("-2-")+4));
                }
            }
            else {
                detailText_1.setText("     "+detail.substring(detail.indexOf("-1-")+4));
            }
        }


        loadDataFromAsset();
        loadType();

    }

    public void loadDataFromAsset() {
        // load image
        Intent intent = getIntent();
        String fileImage = intent.getStringExtra("image");
        try {
            // get input stream
            InputStream ims = getAssets().open(fileImage);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            Image.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }

    public void loadType() {
        Intent intent = getIntent();
        String fileImage = intent.getStringExtra("type");
        fileImage+=".png";
        try {
            InputStream ims = getAssets().open(fileImage);
            Drawable d = Drawable.createFromStream(ims, null);
            typeImage.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }

}
