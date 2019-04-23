package com.example.mushroomtypeclassification;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.mushroomtypeclassification.DatabaseHelper.COL_ID;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_PATH;
import static com.example.mushroomtypeclassification.DatabaseHelper.NGROK_TABLE;


public class EditNgrokPathActivity extends AppCompatActivity {

    private EditText mPathEditText;
    private Button SaveButton;

    private EditText pathText;
    private String path;
    private long mId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ngrok_path);

        NgrokPath();
    }

    private void NgrokPath(){
        SaveButton = findViewById(R.id.savePath_button);
        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper helper = new DatabaseHelper(EditNgrokPathActivity.this);
                //SQLiteDatabase db = helper.getWritableDatabase();

                mPathEditText = findViewById(R.id.path_editText);
                String Path = mPathEditText.getText().toString().trim();

                if(Path.length()==0){
                    Toast.makeText(EditNgrokPathActivity.this,"กรุณาใส่ URL",Toast.LENGTH_LONG).show();
                }
                else if(Path.length() == 8){
                    Toast.makeText(EditNgrokPathActivity.this,"บันทึก URL เรียบร้อยแล้ว",Toast.LENGTH_SHORT).show();
                    helper.AddNgrokPath(Path);
                    Intent intent = new Intent(EditNgrokPathActivity.this,MainPageActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(EditNgrokPathActivity.this,"กรุณาใส่ URL ให้ถูกต้อง",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
