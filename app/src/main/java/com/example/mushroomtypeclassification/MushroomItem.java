package com.example.mushroomtypeclassification;

import java.util.Locale;

public class MushroomItem {
    public final long _id;
    public final String thai;
    public final String science;
    public final String image;
    public final String type;
    public final String detail;


    public MushroomItem(long _id, String thai, String science, String image, String type, String detail){
        this._id = _id;
        this.thai = thai;
        this.science = science;
        this.image = image;
        this.type = type;
        this.detail = detail;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s)",
                this.thai,
                this.science
        );
        return msg;
    }

}
