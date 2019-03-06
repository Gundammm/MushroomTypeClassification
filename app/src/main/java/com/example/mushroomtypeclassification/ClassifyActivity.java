package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class ClassifyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);

        Inputpicture();

        Button cancle_button = findViewById(R.id.cancel_Button);
        cancle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassifyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button accept_button = findViewById(R.id.accept_Button);
        accept_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClassifyActivity.this,"ยอมรับรูปภาพ",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Inputpicture(){
        EasyImage.openChooserWithGallery(ClassifyActivity.this, "เลือกรูปภาพ", 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagesPicked(@NonNull List<File> list, EasyImage.ImageSource imageSource, int i) {
                File logoFile = list.get(0);

                File privateDir = getFilesDir();
                File dstFile = new File(privateDir, logoFile.getName());
                try {
                    copy(logoFile, dstFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                OutputStream out = null;
                ImageView MushroomImageView = findViewById(R.id.picTest);
                Matrix matrix = new Matrix();
                matrix.postRotate(90    );
                Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath());
                Bitmap rotated = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
                try {
                    out = new FileOutputStream(dstFile);
                    rotated.compress(Bitmap.CompressFormat.JPEG, 100, out);
                    MushroomImageView.setImageBitmap(rotated);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }


}
