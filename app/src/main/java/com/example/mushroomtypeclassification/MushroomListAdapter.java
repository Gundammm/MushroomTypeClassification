package com.example.mushroomtypeclassification;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MushroomListAdapter extends ArrayAdapter<MushroomItem> {
    private Context mContext;
    private int mResource;
    private List<MushroomItem> mMushroomList;
    private static final String TAG = MushroomListAdapter.class.getName();
    ArrayList<MushroomItem> arrayList;

    public MushroomListAdapter(@NonNull Context context,
                              int resource,
                              @NonNull List<MushroomItem> mushroomItemList) {
        super(context, resource, mushroomItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mMushroomList = mushroomItemList;
        this.arrayList = new ArrayList<MushroomItem>();
        this.arrayList.addAll(mMushroomList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView thaiTextView = view.findViewById(R.id.thai_name_textView);
        TextView sciTextView = view.findViewById(R.id.sci_name_textView);
        ImageView imageView = view.findViewById(R.id.bg_imageView);
        ImageView TypeimageView = view.findViewById(R.id.type_imageView);

        MushroomItem mushroomItem = mMushroomList.get(position);
        String thai = mushroomItem.thai;
        String science = mushroomItem.science;
        String filename = mushroomItem.image;
        String typefile = mushroomItem.type;

        thaiTextView.setText(thai);
        sciTextView.setText(science);

        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open(filename);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            File privateDir = mContext.getFilesDir();
            File logoFile = new File(privateDir, filename);

            Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
            imageView.setImageBitmap(bitmap);

            e.printStackTrace();
        }

        AssetManager am2 = mContext.getAssets();
        if(typefile.equals("eat")) {
            try {
                InputStream is = am2.open("eat.png");
                Drawable drawable = Drawable.createFromStream(is, "");
                TypeimageView.setImageDrawable(drawable);
            } catch (IOException e) {
                File privateDir = mContext.getFilesDir();
                File logoFile = new File(privateDir, "eat.png");

                Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
                TypeimageView.setImageBitmap(bitmap);

                e.printStackTrace();
            }
        }
        else if(typefile.equals("poisonous")){
            try {
                InputStream is = am2.open("poisonous.png");
                Drawable drawable = Drawable.createFromStream(is, "");
                TypeimageView.setImageDrawable(drawable);
            } catch (IOException e) {
                File privateDir = mContext.getFilesDir();
                File logoFile = new File(privateDir, "poisonous.png");

                Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
                TypeimageView.setImageBitmap(bitmap);

                e.printStackTrace();
            }
        }

        return view;
    }



}
