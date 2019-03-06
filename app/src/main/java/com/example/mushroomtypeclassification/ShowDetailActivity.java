package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView sci1Text;
    private TextView thaiText;
    private ImageView bgImage;
    private ImageView Image;
    private TextView detailText;

    private long mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        Intent intent = getIntent();
        String science_name = intent.getStringExtra("science");
        String thai_name = intent.getStringExtra("thai");
        String detail = intent.getStringExtra("detail");
        mId = intent.getLongExtra("id", 0);

        sci1Text = findViewById(R.id.sci1_textView);
        thaiText = findViewById(R.id.thai_textView);
        bgImage = findViewById(R.id.bg_imageView);
        Image = findViewById(R.id.pic_imageView);
        detailText = findViewById(R.id.detail_textView);


        sci1Text.setText(science_name);
        thaiText.setText(thai_name);
        detailText.setText(detail);
        loadDataFromAsset();

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
            bgImage.setImageDrawable(d);
            Image.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }
}
