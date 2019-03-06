package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.mushroomtypeclassification.DatabaseHelper.COL_DETAIL;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_ID;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_IMAGE;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_SCIENCE;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_THAI;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_TYPE;
import static com.example.mushroomtypeclassification.DatabaseHelper.MUSHROOM_TABLE;

public class Main2Activity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getName();

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<MushroomItem> mMushroomItemList;

    public static ArrayList<String> thainame = new ArrayList<String>();
    public static ArrayList<String> sciencename = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mHelper = new DatabaseHelper(Main2Activity.this);
        mDb = mHelper.getWritableDatabase();

        Button searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,SearchActivity.class);
                intent.putExtra("science", sciencename);
                intent.putExtra("thai", thainame);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        clear();
        loadMushroomData();
        setupListView();
    }

    private void loadMushroomData(){
        Cursor c = mDb.query(MUSHROOM_TABLE, null, null, null, null, null, null);
        mMushroomItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String thai = c.getString(c.getColumnIndex(COL_THAI));
            String science = c.getString(c.getColumnIndex(COL_SCIENCE));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));
            String type = c.getString(c.getColumnIndex(COL_TYPE));
            String detail = c.getString(c.getColumnIndex(COL_DETAIL));

            MushroomItem item = new MushroomItem(id, thai, science,  image, type, detail);
            mMushroomItemList.add(item);
            thainame.add(thai);
            sciencename.add(science);
        }
        c.close();
    }

    private void setupListView(){
        final MushroomListAdapter adapter = new MushroomListAdapter(
                Main2Activity.this,
                R.layout.item_mushroom,
                mMushroomItemList
        );
        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final MushroomItem mushItem = mMushroomItemList.get(position);
                Intent intent = new Intent(Main2Activity.this,ShowDetailActivity.class);
                intent.putExtra("science", mushItem.science);
                intent.putExtra("thai", mushItem.thai);
                intent.putExtra("id",mushItem._id);
                intent.putExtra("image",mushItem.image);
                intent.putExtra("detail",mushItem.detail);
                startActivity(intent);
            }
        });
    }

    private void clear(){
        sciencename.clear();
        thainame.clear();
    }

}