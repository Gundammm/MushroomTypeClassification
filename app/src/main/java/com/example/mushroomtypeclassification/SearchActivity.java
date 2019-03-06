package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.mushroomtypeclassification.DatabaseHelper.COL_DETAIL;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_ID;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_IMAGE;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_SCIENCE;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_THAI;
import static com.example.mushroomtypeclassification.DatabaseHelper.COL_TYPE;
import static com.example.mushroomtypeclassification.DatabaseHelper.MUSHROOM_TABLE;

public class SearchActivity extends AppCompatActivity{

    private EditText QuerySearch;
    private ImageView ClickImage;

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<MushroomItem> mMushroomItemList;


    public static ArrayList<String> thainame = new ArrayList<String>();
    public static ArrayList<String> sciencename = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mHelper = new DatabaseHelper(SearchActivity.this);
        mDb = mHelper.getWritableDatabase();

        clear();

        Intent intent = getIntent();
        thainame = intent.getStringArrayListExtra("thai");
        sciencename = intent.getStringArrayListExtra("science");

        QuerySearch = (EditText) findViewById(R.id.query_editText);
        ClickImage = (ImageView) findViewById(R.id.clickImage);


        ClickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String queryText = QuerySearch.getText().toString();
                SearchQuery(queryText);
            }
        });

    }


    private void SearchQuery(String queryText){
        ArrayList<String> resultSearch = new ArrayList<String>();
        String result="";
        int countFound = -1;
        if(queryText.equals("")){
            result+="โปรดใส่คำค้นหา";
            Toast.makeText(SearchActivity.this,result,Toast.LENGTH_SHORT).show();
        }
        else {
            countFound=0;
            char text = queryText.charAt(0);
            int intText = (int) text;
            //eng
            if (intText <= 122) {
                String newQuery = queryText.toLowerCase();
                for (int i = 0; i < sciencename.size(); i++) {
                    String txtScience = sciencename.get(i);
                    String newtxtScience = txtScience.toLowerCase();
                    Boolean found = newtxtScience.contains(newQuery);
                    if (found == true){
                        result += sciencename.get(i) + "\n";
                        countFound++;
                        resultSearch.add(txtScience);}
                }
            }
            //thai
            else {
                for (int i = 0; i < thainame.size(); i++) {
                    String txtThai = thainame.get(i);
                    String Sci = sciencename.get(i);
                    Boolean found = txtThai.contains(queryText);
                    if (found == true){
                        result += thainame.get(i) + "\n";
                        countFound++;
                        resultSearch.add(Sci);}
                }
            }
        }
        if(countFound==0){ result+="ไม่พบข้อมูล"; Toast.makeText(SearchActivity.this,result,Toast.LENGTH_SHORT).show();}
        else if(countFound>0){
            loadMushroomData(resultSearch);
        }
    }

    private void clear(){
        sciencename.clear();
        thainame.clear();
    }

    private void loadMushroomData(ArrayList<String> result){
        Cursor c = mDb.query(MUSHROOM_TABLE, null, null, null, null, null, null);
        mMushroomItemList = new ArrayList<>();
        String txt="";
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String thai = c.getString(c.getColumnIndex(COL_THAI));
            String science = c.getString(c.getColumnIndex(COL_SCIENCE));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));
            String type = c.getString(c.getColumnIndex(COL_TYPE));
            String detail = c.getString(c.getColumnIndex(COL_DETAIL));

            for(int i=0;i<result.size();i++){
                if(result.get(i).equals(science)){
                    txt+=science+"\n";
                    MushroomItem item = new MushroomItem(id, thai, science,  image, type, detail);
                    mMushroomItemList.add(item);
                }
            }
        }
        c.close();
        setupListView();
    }


    private void setupListView(){
        final MushroomListAdapter adapter = new MushroomListAdapter(
                SearchActivity.this,
                R.layout.item_mushroom,
                mMushroomItemList
        );
        ListView lv = findViewById(R.id.result_search);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final MushroomItem mushItem = mMushroomItemList.get(position);
                Intent intent = new Intent(SearchActivity.this,ShowDetailActivity.class);
                intent.putExtra("science", mushItem.science);
                intent.putExtra("thai", mushItem.thai);
                intent.putExtra("id",mushItem._id);
                intent.putExtra("image",mushItem.image);
                intent.putExtra("detail",mushItem.detail);
                startActivity(intent);
            }
        });
    }

}
