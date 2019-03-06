package com.example.mushroomtypeclassification;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mushroomclassify.db";
    private static final int DATABASE_VERSION = 1;

    public static final String MUSHROOM_TABLE = "mushroom_table";

    public static final String COL_ID = "_id";
    public static final String COL_THAI = "thai";
    public static final String COL_SCIENCE = "science";
    public static final String COL_IMAGE = "image";
    public static final String COL_TYPE = "type";
    public static final String COL_DETAIL = "detail";

    private static final String SQL_CREATE_TABLE_MUSHROOM
            = "CREATE TABLE " + MUSHROOM_TABLE + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_THAI + " TEXT,"
            + COL_SCIENCE + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + COL_TYPE + " TEXT,"
            + COL_DETAIL + " TEXT"
            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_MUSHROOM);
        ContentValues mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดกรวยเกล็ดทอง");
        mr.put(COL_SCIENCE, "Gomphus floccosus");
        mr.put(COL_IMAGE, "GomphusFloccosus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดรูปกรวยลึก คล้ายแก้วแชมเปญ ยาวประมาณ 7-20 เซนติเมตร ขอบเป็นรอนและคลื่น ด้านในกรวยมีสีเหลือง และมีเกล็ดคล้ายปลาสีส้มเหลืองอมส้ม หรือแดงอมส้มกระจายทั่วไป  ผิวด้านนอกกรวยสีเหลืองอ่อนหรือขาวนวล เป็นรอยย่นและมีสันนูนเตี้ยๆ ยาวลงไปติดก้าน ก้านยาว 5-20 เซนติเมตร รูปทรงกระบอกและเรียวลงที่โคน เนื้อเรียบ ด้านในกลวง เนื้อก้านสีขาว");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดกระดุม");
        mr.put(COL_SCIENCE, "Agaricus bisporus");
        mr.put(COL_IMAGE, "AgaricusBisporus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"เห็ดกระดุมมีหมวกเห็ดสีขาว ผิวมีเกล็ดและขนบางๆ สีน้ำตาลอ่อนกระจายออกไปจากกลางหมวก หมวกเห็ดเมื่อบานเต็มที่ผิวด้านบนจะโค้งแบบระฆังคว่ำ ด้านล่างมีครีบหมวกซึ่งมีสีชมพูอ่อนปนม่วงตั้งแต่เป็นดอกอ่อนยังไม่บาน สีครีบหมวกจะเข้มข้นจนกลายเป็นสีม่วงปนน้ำตาลเมื่อเห็ดโตเต็มที่ ก้านดอกเห็ดมีรูปร่างอ้วนสั้นเป็นรูปทรงกระบอก ผิวนอกเรียบและมีสีขาวเหมือนหมวกเห็ด ตอนบนของก้านดอกมีเยื่อบางๆ เป็นวงแหวนรอบก้านดอก");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดเกล็ดดาว");
        mr.put(COL_SCIENCE, "Amanita pantherina");
        mr.put(COL_IMAGE, "AmanitaPantherina.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"ดอกเห็ดอ่อนมีเยื่อหุ้มรูปกลมหรือรูปไข่ สีขาว ด้านบนปริแตกมีเกล็ดเล็กๆ ติดอยู่บนดอก หมวกเห็ดสีน้ำตาลอ่อนหรือน้ำตาล นูนแล้วแบนลง มีเกล็ดนูนเล็กสีขาว ขอบมีริ้ว ครีบสีขาวไม่ติดก้าน กว้าง เรียงถี่ ก้านยาวประมาณ 5-7 เซนติเมตร รูปทรงกระบอก มีวงแหวนบางขาว");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดขอนสีทองเกล็ดแดง");
        mr.put(COL_SCIENCE, "Gymnopilus Aeruginosus");
        mr.put(COL_IMAGE, "GymnopilusAeruginosus.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"หมวกเห็ดสีเหลือง นูนแล้วแบน ผิวมีเกล็ดน้ำตาลแดงอมม่วงเล็กๆ หนาแน่น บางแห่งอาจมีสีเขียว ครีปสีเหลืองยาวลงไปติดกับก้าน ก้านสีเดียวกับหมวก ยาวเท่ากันตลอดก้าน มีวงแหวนสีน้ำตาลอมเหลืองอยู่เกือบปลายบยของก้าน เนื้อเห็ดมีขาวปะปนด้วยสีน้ำเงินหรือเขียว");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดข้าวตอก");
        mr.put(COL_SCIENCE, "Termitomyces microcarpus");
        mr.put(COL_IMAGE, "TermitomycesMicrocarpus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"เห็ดข้าวตอกมีหมวกเห็ดลักษณะนูนแล้วแบนและมีสีขาวนวล มีปมนูนเล็กๆ กลางหมวกคล้ายร่ม ยอดหมวกมีสีน้ำตาลอ่อนซึ่งจะจางหายไปเมื่อดอกบานเต็มที่ ผิวเรียบ เนื้อบาง ครีบมีสีขาวนวล ไม่ยึดติดกับก้าน ก้านตรงสีขาวนวล");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดขี้ควาย");
        mr.put(COL_SCIENCE, "Psilocybe cubensis");
        mr.put(COL_IMAGE, "PsilocybeCubensis.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"หมวกเห็ดเมื่อบานใหม่ๆ มีลักษณะคล้ายร่ม เมื่อบานเต็มที่จะโค้งขึ้น ตรงกลางเว้าตื้น ขอบบางและมักจะฉีกขาด ผิวหมวกมีสีขาวอมเหลือง กลางหมวกสีน้ำตาลอ่อน ครีบสีน้ำตาลดำ ไม่ยึดติดกับก้าน ก้านสีขาวยาวประมาณ 5.5 - 8 เซนติเมตร รูปทรงกระบอก มีเส้นเป็นทางยาวตลอดก้าน เมื่อช้ำเป็นสีน้ำเงิน");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดเข็มทอง");
        mr.put(COL_SCIENCE, "Flammulina velutipes");
        mr.put(COL_IMAGE, "FlammulinaVelutipes.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขข");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดไข่หงส์");
        mr.put(COL_SCIENCE, "Scleroderma citrinum");
        mr.put(COL_IMAGE, "SclerodermaCitrinum.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"ดอกเห็ดรูปกลมสีน้ำตาลอมเหลือง เส้นผ่านศูนย์กลาง 2-6 เซนติเมตร ด้านบนแบนลงเล็กน้อย ผิวแตกเป็นเกล็ดใหญ่ โคนมีเส้นใยหยาบ ๆ เป็นกระจุกยึดติดกับดิน สีขาวนวล เมื่อดอกเห็ดแก่ด้านบนมีรูเปิด ภายในมีสปอร์สีม่วงดำบรรจุอยู่เต็ม");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดโคนญี่ปุ่น");
        mr.put(COL_SCIENCE, "Agrocybe aegerita");
        mr.put(COL_IMAGE, "AgrocybeAegerita.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หแดหฟกดอฟหกดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดด");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดจมูกหมู");
        mr.put(COL_SCIENCE, "Galiella rufa");
        mr.put(COL_IMAGE, "GaliellaRufa.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"รูปถ้วยก้นตื้น ภายในมีสีส้มคล้ายเยลลี่ ยืดหยุ่นได้ผิวหน้าเรียบ ผนังด้านนอกมีสีน้ำตาลดำค่อนข้างเหนียว มีขนเล็กละเอียดปกคลุมที่ปากถ้วยด้านนอก เมื่อมองจากด้านข้างมีลักษณะคล้ายกับจมูกหมู เมื่อดอกเริ่มแก่จะบานออก");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดจาวมะพร้าว");
        mr.put(COL_SCIENCE, "Calvatia craniformis");
        mr.put(COL_IMAGE, "CalvatiaCraniformis.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดอ่อนเป็นก้อนกลมสีขาว โคนสอบเล็กน้อย ผิวด้านบนของเห็ดอ่อนเรียบ เมื่อเจริญขึ้นผิวด้านบนเป็นสีน้ำตาลอ่อนอมชมพูหรือน้ำตาลอมแดง ขรุขระ คล้ายผิวของสมองคน ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดชงโค");
        mr.put(COL_SCIENCE, "Clitocybe nuda");
        mr.put(COL_IMAGE, "ClitocybeNuda.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดสีม่วง เมื่อบานเต็มที่หมวกโค้งขึ้นเล็กน้อย ขอบม้วนเข้า ผิวเรียบ สีจางลงจนเป็นสีม่วงอมชมพูอ่อน เนื้อสด เปราะ ฉ่ำน้ำเล็กน้อย ครีบสีม่วงอ่อนแล้วเปลี่ยนเป็นม่วงอมน้ำตาล ยาวขนานกับก้านเล็กน้อย มีความยาวต่างกัน 5 ขนาด ด้านที่ยึดติดกับก้านเว้าเป็นแอ่งเล็ก ๆ ก้านสีม่วงอ่อน ยาวประมาณ 5-10 เซนติเมตร ผิวมีลักษณะเป็นเส้นหยาบ ๆ สานกันแน่น โคนมีเส้นใยหยาบ ๆ เกิดเป็นกระจุก เนื้อสีขาวอมม่วงอ่อน");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดชิเมะจิ");
        mr.put(COL_SCIENCE, "Hypsizygus marmoreus");
        mr.put(COL_IMAGE, "HypsizygusMarmoreus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยย");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดซังขนุน");
        mr.put(COL_SCIENCE, "Clavulinopsis fusiformis");
        mr.put(COL_IMAGE, "ClavulinopsisFusiformis.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดไม่มีหมวก แต่มีลักษณะเป็นเส้นยาว รูปใบหอกแบนหรือรูปทรงกระบอก สีเหลืองสดหรือเหลืองอมส้ม ยาวประมาณ 5-15 เซนติเมตร  มีร่องยาวคล้ายซังขนุน ภายในเป็นรูกลวง ผิวเรียบ บางดอกโคนติดกันหรือแตกแขนง ปลายแหลมหรือแยกเป็น 2 แฉก เนื้อในเห็ดสีเหลือง");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดแดงน้ำหมาก ");
        mr.put(COL_SCIENCE, "Russula emetica");
        mr.put(COL_IMAGE, "RussulaEmetica.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปกระทะคว่ำ มีสีแดงสด กลางหมวกเป็นแอ่งเล็กน้อยสีแดงเรื่อๆ ผิวหมวกเรียบ หนืดมือ ขอบหมวกงอลง ครีบสีขาวหรือขาวนวลเรียงห่างกันเล็กน้อย ไม่ยึดติดกับก้าน ก้านสีขาว ยาวประมาณ 5-10 เซนติเมตร มักมีรอยย่นยาว เนื้อแน่นขาว");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดตีนตุ๊กแก");
        mr.put(COL_SCIENCE, "Schizophyllum commune");
        mr.put(COL_IMAGE, "SchizophyllumCommune.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดเจริญออกข้างเดียวคล้ายพัดกว้าง ด้านบนสีขาวหม่นมีขนละเอียดสีเดียวกัน ด้านล่างสีน้ำตาลหรือน้ำตาลอมแดง ลักษณะคลบ้ายครีบแต่แคบเรียวเล็กแยกเป็นแฉก รัศมีจากโคนดอกไปจดขอบหมวก เมื่อแห้งขอบจะม้วนงอลง มีรอยฉีกเป็นทางยาวเข้าไปเกือบถึงโคนดอกเป็นบางแห่ง ทำให้มองดูคล้ายตีนตุ๊กแกหรือแครงรดน้ำ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดถั่งเช่า");
        mr.put(COL_SCIENCE, "Ophiocordyceps sinensis");
        mr.put(COL_IMAGE, "OphiocordycepsSinensis.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"มีลักษณะเหมือนตัวหนอนตัวเล็กๆ และมีต้นเห็ดหรือหญ้าขึ้นอยู่บนหัว");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดถ่านเล็ก");
        mr.put(COL_SCIENCE, "Russula densifolia");
        mr.put(COL_IMAGE, "RussulaDensifolia.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดสีขาวนวล กลางหมวกเว้าตื้น ผิวเรียบและหนืดมือเมื่อจับ แต่จะค่อย ๆ แห้งไป เนื้อบางสีขาว ครีบสีขาวนวล บาง และแคบ ยึดติดกับก้านและเรียงชิดกัน ก้านสีขาวนวล ยาวประมาณ 1-2 เซนติเมตร ภายในสีขาว สีดอกเห็ดจะค่อย ๆ เปลี่ยนเป็นสีน้ำตาลดำและสีดำ ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดถ่านใหญ่");
        mr.put(COL_SCIENCE, "Russula nigricans");
        mr.put(COL_IMAGE, "RussulaNigricans.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปกระทะคว่ำ สีขาวหม่น ผิวเรียบ กลางหมวกเว้าตื้น เนื้อหนา ครีบใหญ่สีขาวนวล ยึดติดกับก้าน เรียงห่างกันและมีครีบสั้นสลับ เมื่อดอกแก่โค้งงอขึ้น ก้านสีขาว เมื่อดอกแก่ทั้งดอกเปลี่ยนเป็นสีน้ำตาลและดำ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดนางฟ้า");
        mr.put(COL_SCIENCE, "Pleurotus pulmonarius");
        mr.put(COL_IMAGE, "PleurotusPulmonarius.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขข");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดนางรมทอง");
        mr.put(COL_SCIENCE, "Pleurotus citrinopileatus");
        mr.put(COL_IMAGE, "PleurotusCitrinopileatus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดเป็นสีเหลืองทอง มีลักษระผิวเรียบ ตรงกลางจัเว้าเป็นแอ่ง ขอบหมวกจะเอียงเล็กน้อย ใต้หมวกเมื่อเจริญเติโตเต็มที่จะเป็นครีบ ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดน้ำหมึก");
        mr.put(COL_SCIENCE, "Coprinus cinerea");
        mr.put(COL_IMAGE, "CoprinopsisCinerea.JPG");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดรูประฆังหรือรูปกรวยคว่ำ สีเทา กลางหมวกสีน้ำตาลอ่อน มีขนและเกล็ดสีเทาหรือสีน้ำตาลอ่อนหลุดง่าย ขอบเป็นริ้วและม้วนงอขึ้นเมื่อดอกแก่ ครีบสีน้ำตาลดำ แคบเรียงชิดติดกัน ไม่ยึดติดกับก้าน ต่อมาเปลี่ยนเป็นสีดำแล้วสลายเป็นหยดน้ำสีดำ ก้านยาวประมาณ 3-12 เซนติเมตร รูปทรงกระบอก สีขาว โคนก้านโปร่งเล็กน้อยและมีรากยาว ตรงกลางก้านกลวง ผิวมีขนบางๆ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดเนยแม่มด");
        mr.put(COL_SCIENCE, "Tremella mesenterica");
        mr.put(COL_IMAGE, "TremellaMesenterica.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขข");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดปอดดำ");
        mr.put(COL_SCIENCE, "Strobilomyces floccopus");
        mr.put(COL_IMAGE, "StrobilomycesFloccopus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปกระทะคว่ำ ดอกที่บานไม่เต็มที่ผิวหมวกคล้ายผลน้อยหน่า หมวกมีสีเทาแล้วเปลี่ยนเป็นสีดำ มีขนรวมกันเป็นกลุ่มสี่เหลี่ยมคล้ายเกล็ดสีเทาดำแนบติดกับหมวก เกล็ดที่อยู่กลางหมวกงอขึ้นเล็กน้อย ขอบหมวกมีเศษของวงแหวนที่ขาดจากก้านห้อยติดอยู่โดยรอบ ก้านมีสีเดียวกับหมวก ยาว 6-8 เซนติเมตร มีวงแหวนเป็นชิ้นเล็ก ๆ ตัดแล้วเปลี่ยนเป็นสีแดงแล้วเปลี่ยนเป็นน้ำตาลดำ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดปะการังพวงแสด");
        mr.put(COL_SCIENCE, "Clavulinopsis miyabeana");
        mr.put(COL_IMAGE, "ClavulinopsisMiyabeana.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกกว้าง 0.3-1 เซนติเมตร สูง5-10 เซนติเมตร แท่งเรียวยาว และบิดงอเล็กน้อย ปลายแหลมสีแดงอมส้ม ไม่มีก้าน ลักษณะโดยรวมคล้ายกับปะการัง");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดปะการังส้มอมชมพู");
        mr.put(COL_SCIENCE, "Ramaria formosa");
        mr.put(COL_IMAGE, "RamariaFormosa.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"ดอกเห็ดรูปปะการัง ตอนบนแตกแขนงมากมายเป็นพุ่มใหญ่ สีเหลืองหม่นอมชมพู ปลายแขนงสีเหลืองอ่อน เมื่อช้ำจะเปลี่ยนเป็นสีน้ำตาลแดง ก้านใหญ่ สีขาว โคนสอบมีขนละเอียดสีขาว");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดปุยฝ้าย");
        mr.put(COL_SCIENCE, "Hericium erinaceus");
        mr.put(COL_IMAGE, "HericiumErinaceus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"เป็นเห็ดที่มีขนาดใหญ่ ดอกเห็ดมีรูหลายรู เป็นทรงกลมมีเส้นสีขาวฟู โดยดอกเห็ดอ่อนจะมีสีขาวแต่ไม่มีขน เมื่อแก่ขึ้นจะเปลี่ยนเป็นสีน้ำตาลอ่อนและแตกเป็นขนฝอยๆ ห้อยลงมาคล้ายกับหัวลิง");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดเป๋าฮื้อ");
        mr.put(COL_SCIENCE, "Pleurotus ostreatus");
        mr.put(COL_IMAGE, "PleurotusOstreatus.JPG");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปพัด สีน้ำตาลดำหรือสีเทา เนื้อหนา กลางหมวกเว้าตื้น มีขนกำมะหยี่สีน้ำตาลดำบาง ๆ ซึ่งจะหลุดหายไปเมื่อดอกแก่ คงเหลืออยู่บ้างบริเวณกลางหมวกโดยรวมกันเหมือนเกล็ดเล็ก ๆ ขอบเรียบ สีน้ำตาลดำ เนื้อเห็ดสดสีขาว แต่จะเหนียวเมื่อดอกแก่ ครีบสีขาวนวล ขนานกันตามยาว มีหลายชนาดและบางอันเชื่อมติดกันเป็นตอน ก้านสีเทาดำ ยาวประมาณ 4-6 เซนติเมตร ก้านจะไม่อยู่กึ่งกลางดอก ด้านหนึ่งอยู่ติดขอบหมวกทำให้ดูเหมือนเป็นด้ามพัด โคนก้านสอบเล็ก");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดเผาะ");
        mr.put(COL_SCIENCE, "Astraeus hygrometricus");
        mr.put(COL_IMAGE, "AstraeusHygrometricus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"มีลักษระกลม มีเส้นผ่านศูนย์กลางขนาด1-3เซนติเมตร ไม่มีก้านดอก ดอกเห็ดอ่อนสีน้ำตาลอ่อน เมื่อแก่จะมีสีน้ำตาลเข้มถึงดำ ผนังดอกแบ่งเป็นชั้น 2 ชั้น");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดพายทอง");
        mr.put(COL_SCIENCE, "Dacryopinax spathularia");
        mr.put(COL_IMAGE, "DacryopinaxSpathularia.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดรูปร่างคล้ายใบพาย ปลายมนหรือหยักเป็นคลื่นเล็กน้อย สีเหลืองเข้มหรือเหลืองทอง เนื้อแข็งและใสเหมือนวุ้น ก้านสีน้ำตาลอ่อนอมเหลืองหรือสีส้ม รูปทรงกระบอก ยาวประมาณ 0.5 - 1 เซนติเมตร");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดพุงหมู");
        mr.put(COL_SCIENCE, "Russula foetens");
        mr.put(COL_IMAGE, "RussulaFoetens.JPG");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปกลม สีน้ำตาลอมเหลือง เมื่อบานหมวกจะค่อย ๆ กางออกทำให้กลางหมวกเว้าตื้น เนื้อหมวกหนา ผิวเป็นเมือกเมื่อเปียกน้ำ ขอบเป็นริ้วโดยรอบ ครีบสีขาวนวล ยึดติดกับก้านและเรียงห่างกัน ก้านรูปทรงกระบอก สีขาวนวลหรือน้ำตาลอ่อนอมเหลือง ยาวประมาณ 4-8 เซนติเมตร เนื้อในเห็ดสีขาว บางส่วนเป็นโพรงเล็ก ๆ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดฟานน้ำตาลแดง");
        mr.put(COL_SCIENCE, "Lactarius volemus");
        mr.put(COL_IMAGE, "LactariusVolemus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกนูน กลางหมวกมีแอ่งเล็กน้อย สีน้ำตาลส้ม ขนาดเส้นผ่าศูนย์กลาง 5-10 เซนติเมตร ลักษณะแห้งและมีขนคล้ายกำมะหยี่ขอบม้วนเล็กน้อย ครีบมีสีขาวนวล บางแคบ เรียงชิดกันยิดติดกับก้านรูปทรงกระบอก สีน้ำตาลอมเหลือง ยาว 3-10 เซนติเมตร เส้นผ่านศูนย์กลางอยู่ที่ 1-2 เซนติเมตร มีขนคล้ายกำมะหยี่เช่นเดียวกับดอก เมื่อฉีกจะมียางสีขาวออกมา ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดเฟืองล้อสีส้ม");
        mr.put(COL_SCIENCE, "Marasmius siccus");
        mr.put(COL_IMAGE, "MarasmiusSiccus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวก รูประฆังคว่ำ เมื่อเจริญขึ้นหมวกจะบานออก กลางหมวกเป็นแอ่งเล็กน้อย ผิวแห้งมีลอยหยักลึก มีขนอ่อนบางๆสีน้ำตาลแดง ครีบเรียงห่าง สีขาว ก้านมีความยาว 2-6 เซนติเมตร ทรวงกระบอกกรวง ลักษณะแห้ง เรียบ ยาว โคนสีน้ำตาล เมื่อดอกแก่จะเปลี่ยนสีเป็นสีน้ำตาลเข้มและมันเงา  ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดมิลค์กี้");
        mr.put(COL_SCIENCE, "Calocybe Indica");
        mr.put(COL_IMAGE, "CalocybeIndica.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"กดพดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดดด");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดไมตาเกะ");
        mr.put(COL_SCIENCE, "Grifola frondosa");
        mr.put(COL_IMAGE, "GrifolaFrondosa.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดจะมีลักษณะโค้ง สีน้ำตาลแกมเทา มีเส้นผ่านศูนย์กลาง 60 เซนติเมตร ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดเยื่อไผ่ (เห็ดร่างแห)");
        mr.put(COL_SCIENCE, "Phallus indusiatus");
        mr.put(COL_IMAGE, "PhallusIndusiatus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดเมื่อยังอ่อนมีเปลือกหุ้มรูปไข่สีขาว ขาวอมชมพู หรือม่วงอ่อน เมื่อเจริญขึ้นจะปริแตกเห็นก้านและฐานดอกรูประฆัง สีขาวคงเหลือเปลือกหุ้มอยู่ที่โคน ปลายเป็นแป้นกลม ผิวฐานดอกแบ่งเป็นห้อง ๆ คล้ายรวงผึ้ง ใต้ฐานดอกมีเยื่อบาง ๆ คล้ายร่างแหแขวนกางห้อยลงมาคล้ายสุ่มรอบก้านดอก เห็ดร่างแหชนิดนี้มีร่างแหสีขาว ยาวประมาณ 3 ใน 4 ของก้านดอก  ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดระโงกแดงอมส้ม");
        mr.put(COL_SCIENCE, "Amanita caesarea");
        mr.put(COL_IMAGE, "AmanitaCaesarea.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดอ่อนมีเยื่อหุ้มหนา รูปไข่ สีขาว เมื่อเจริญขึ้นผิวด้านบนปริแตกออกเป็นรูปถ้วยติดอยู่ที๋โคนก้าน หมวกเห็ดเป็นรูปไข่ สีแดงหรือแดงอมส้ม เมื่อบานกางออกเป็นรูปกระทะคว่ำแล้วแบนราบ ผิวเป็นมันขอบเป็นริ้วโดยรอบ ครีบสีเหลืองอ่อน ไม่ยึดติดกับก้าน ก้านสีเหลืองอ่อน ยาง 7-20 เซนติเมตร ผิวเรียบหรือมีเกล็ดเล็ก ๆ สีเหลืองอ่อน ภายในสีขาว มีรูกลวงวงแหวนเป็นแผ่นบางสีเหลืองห้อยลงมารอบก้านตอนบน ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดระโงกหิน");
        mr.put(COL_SCIENCE, "Amanita phalloides");
        mr.put(COL_IMAGE, "AmanitaPhalloides.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"ขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขขข");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดระโงกหิน เห็ดไข่ตายซาก");
        mr.put(COL_SCIENCE, "Amanita virosa");
        mr.put(COL_IMAGE, "AmanitaVirosa.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"ดอกเห็ดอ่อนมีเหยื่อหุ้มหนา รูปไข่ สีขาว เมื่อเจริญขึ้นผิวด้านบนปริแตกออกเป็นรูปถ้วยติดอยู่ที่โคนก้าน หมวกเห็ดรูปกระทะคว่ำ สีขาว ครีบสีขาว ไม่ยึดติดกับก้าน ก้านสีขาว โคนโป่งเป็นกระเปาะ ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดร่างแหกระโปรงยาวสีเหลือง");
        mr.put(COL_SCIENCE, "Dictyophora indusiata");
        mr.put(COL_IMAGE, "DictyophoraIndusiata.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดเมื่อยังอ่อนมีเปลือกหุ้มรูปไข่สีขาว ขาวอมชมพู หรือม่วงอ่อน เมื่อเจริญขึ้นจะปริแตกเห็นก้านและฐานดอกรูประฆัง สีขาวคงเหลือเปลือกหุ้มอยู่ที่โคน ปลายเป็นแป้นกลม ผิวฐานดอกแบ่งเป็นห้อง ๆ คล้ายรวงผึ้ง ใต้ฐานดอกมีเยื่อบาง ๆ คล้ายร่างแหแขวนกางห้อยลงมาคล้ายสุ่มรอบก้านดอก เห็ดร่างแหชนิดนี้มีร่างแหสีส้ม ยาวประมาณ 3 ใน 4 ของก้านดอก ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดร่างแหสั้นขาว");
        mr.put(COL_SCIENCE, "Dictyophora duplicata");
        mr.put(COL_IMAGE, "DictyophoraDuplicata.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดเมื่อยังอ่อนมีเปลือกหุ้มรูปไข่สีขาว ขาวอมชมพู หรือม่วงอ่อน เมื่อเจริญขึ้นจะปริแตกเห็นก้านและฐานดอกรูประฆัง สีขาวคงเหลือเปลือกหุ้มอยู่ที่โคน ปลายเป็นแป้นกลม ผิวฐานดอกแบ่งเป็นห้อง ๆ คล้ายรวงผึ้ง ใต้ฐานดอกมีเยื่อบาง ๆ คล้ายร่างแหแขวนกางห้อยลงมาคล้ายสุ่มรอบก้านดอก เห็ดร่างแหชนิดนี้มีร่างแหสีขาว ยาวประมาณ 1 ใน 3 ของก้านดอก");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดรูประฆัง");
        mr.put(COL_SCIENCE, "Coprinus atramentarius");
        mr.put(COL_IMAGE, "CoprinusAtramentarius.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"นนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนนน");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดลม");
        mr.put(COL_SCIENCE, "Lentinus polychrous");
        mr.put(COL_IMAGE, "LentinusPolychrous.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปกรวยลึก สีขาวนวลหรือน้ำตาลอ่อนอมเทา ผิวเหนียวคล้ายหนัง ขอบงอลงเล็กน้อย ผิวมีขนสั้น ๆ สีน้ำตาลซึ่งรวมกันคล้ายเกล็ดเล็ก ๆ และปลายงอนขึ้นเล็กน้อย เกล็ดเรียงกระจายออกไปยังขอบหมวก ดอกอ่อนมีขอบบางและม้วนงอลง ครีบสีน้ำตาลอ่อนอมเทา บางและแคบ เมื่อแห้งจะเหนียวแข็งและเปลี่ยนเป็นสีน้ำตาลแดง หรือน้ำตาลอมม่วง ครีบมีความยาวต่างกัน ด้านในยาวขนานเล็กลงไปติดก้าน ด้านนอกเรียวแคบไปติดขอบหมวก ขอบครีบจักฟันเลื่อยเล็ก ๆ มองไม่เห็นด้วยตาเปล่า เวลาลูบจะสากมือ ก้านแข็งเหนียว สีขาวนวลแล้วเปลี่ยนเข้มขึ้นจนเป็นสีน้ำตาลดำ ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดสมองวัว");
        mr.put(COL_SCIENCE, "Gyromitra esculenta");
        mr.put(COL_IMAGE, "GyromitraEsculenta.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปอานม้า สีน้ำตาลอมเหลืองแล้วเปลี่ยนเป็นน้ำตาลเข้ม เป็นลอนและคลื่นคล้ายสมอง ด้านล่างเป็นแอ่งเล็ก ๆ ตื้น ๆ สีน้ำตาลอ่อน ก้านสีขาว ยาวประมาณ 2-5 เซนติเมตร ไม่แตกแขนง บางดอกมีร่องยาว ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหนอนขาว");
        mr.put(COL_SCIENCE, "Clavaria fragilis");
        mr.put(COL_IMAGE, "ClavariaFragilis.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดรูปใบหอกหรือทรงกระบอก สีขาว ยาวประมาณ 5-10 เซนติเมตร มักโค้งงอคล้ายตัวหนอน บางดอกปลายเป็นแขนงคล้ายรูปส้อม ภายในกลวง เนื้อในเห็ดสีขาว ก้านสีขาว รูปร่างเหมือนดอกจึงแยกไม่ออกว่าส่วนไหนเป็นก้าน");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหล่มกระเขียว");
        mr.put(COL_SCIENCE, "Russula virescens");
        mr.put(COL_IMAGE, "RussulaVirescens.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดมีสีเขียวหม่นอมน้ำตาลอ่อน รูปทรงกลมเมื่อดอกอ่อน หากบานแล้วขอบจะโค้งงอลง ตรงกลางเว้าตื้น ผิวปริแตกเป็นเกล็ดสี่เหลี่ยมเผยให้เห็นเนื้อในสีขาว ครีบสีขาวหรือขาวนวล ยึดติดกับก้าน ก้านสีขาวหรือขาวนวล ยาวประมาณ 3-5 เซนติเมตร โคนเรียวเล็กกว่าตอนบนเล็กน้อย ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหล่มขาว");
        mr.put(COL_SCIENCE, "Russula delica");
        mr.put(COL_IMAGE, "RussulaDelica.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปกระทะคว่ำ สีขาวนวลหรือน้ำตาลอ่อน กลางหมวกเป็นแอ่ง เมื่อเป็นดอกอ่อนขอบม้วนงอลง ผิวเรียบ ครีบสีขาวหรือขาวนวล ก้านสีขาวยาว 2.5-6 เซนติเมตร ดอกเห็ดบางแห่งมีสีน้ำตาลปน  ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหล่มเหลือง");
        mr.put(COL_SCIENCE, "Russula flavida");
        mr.put(COL_IMAGE, "RussulaFlavida.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกลักษณะนูน เรียบ สีเหลืองสด กลางหมวกมีแอ่งเล็กน้อย สีเหลืองทอง  มีเส้นผ่าศูนย์กลางขนาด 3-8 เซนติเมตร ครีบ ก้านกว้าง เรียงถี่ ติดกับก้านทรงกระบอก เรียบสีส้มในส่วนบนและส่วนล่างมีสีเหลือง โดยยาวประมาณ3-8 เซนติเมตร   ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหลินจือ");
        mr.put(COL_SCIENCE, "Ganoderma lucidum");
        mr.put(COL_IMAGE, "GanodermaIucidum.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดรูปไตหรือรูปครึ่งวงกลม ดอกอ่อนมีขอบสีขาว ถัดเข้าไปมีสีเหลืองอ่อน กลางดอกสีน้ำตาลหรือน้ำตาลแดง ดอกแก่เป็นสีน้ำตาลหรือน้ำตาลแดง ผิวเป็นมันเงา มีรอยจีบย่นหรือหยักเป็นคลื่น ขอบหมวกงุ้มลงเล็กน้อย ด้านล่างของหมวกเป็นรูกลมเล็ก ๆ เชื่อมติดกัน ปากรูสีขาวนวล เหลืองอ่อน หรือเหลืองอมเขียว ก้านสั้นหรือไม่มีก้าน แบบมีก้าน ก้านจะมีสีน้ำตาลเข้มหรือน้ำตาลดำ ยาวประมาณ 2-10 เซนติเมตร อยู่เยื้องไปข้างใดข้างหนึ่งหรือติดขอบหมวก ทำให้ดอกมีรูปคล้ายไตผิวก้านเป็นมันเงา ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหอม");
        mr.put(COL_SCIENCE, "Lentinula edodes");
        mr.put(COL_IMAGE, "LentinulaEdodes.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"หมวกเห็ดรูปกระทะคว่ำ สีน้ำตาลไหม้ น้ำตาลแดง น้ำตาลอ่อนหรือน้ำตาลอ่อนอมเหลือง ผิวมีขนรวมกันเป็นเกล็ดหยาบ ๆ สีขาวนวลหรือน้ำตาลอ่อนกระจายทั่วไป ซึ่งจะแห้งหรือหลุดหายไปคงเหลือให้เห็นบางส่วนโดยเฉพาะตามขอบ สีขาว เรียงกันถี่และยึดติดกับก้าน ก้านสีน้ำตาลอ่อน มีขนหยาบ ก้านมักโค้งงอเพราะเจริญออกมาจากขอนไม้");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหัวกรวดครีบเขียว");
        mr.put(COL_SCIENCE, "Chlorophyllum molybdites");
        mr.put(COL_IMAGE, "ChlorophyllumMolybdites.jpg");
        mr.put(COL_TYPE, "poisonous");
        mr.put(COL_DETAIL,"ดอกเห็ดอ่อนเป็นก้อนกลมแล้วบานออกเป็นรูปร่ม หมวกเห็ดสีขาว กลางหมวกมีสีน้ำตาล ซึ่งแตกออกเป็นเกล็ดใหญ่รูปสี่เหลี่ยม กระจายออกไปถึงกึ่งกลางหมวก ครียสีขาวค่อย ๆ เปลี่ยนเป็นสีขาวอมเขียวอ่อนก่อนจะเปลี่ยนเป็นสีน้ำตาลอมเขียวหม่น ยามดอกโรยจะเป็นสีเทาอมเขียวหม่น ครีปไม่ยึดติดกับก้าน ก้านยาว 6-20 เซนติเมตร รูปทรงกระบอก สีขาวหรือสีน้ำตาลอ่อน โคนก้านใหญ่เป็นกระเปาะเล็กน้อย ใต้หมวกมีวงแหวนใหญ้และหนา");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดตับเต่า");
        mr.put(COL_SCIENCE, "Phlebopus marginatus");
        mr.put(COL_IMAGE, "PhlebopusMarginatus.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหูช้าง");
        mr.put(COL_SCIENCE, "Ganoderma applanatum");
        mr.put(COL_IMAGE, "GanodermaApplanatum.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดเป็นแผ่นรูปครึ่งวงกลม กว้าง 3-12 เซนติเมตร ด้านบนมีสีน้ำตาลหม่น ขรุขระ ย่นและเป็นร่องวงกลมช้อนกันห่างๆ เนื้อในเห็ดสีน้ำตาลเข้มหรือน้ำตาลอมชมพู เมื่อแห้งจะเหนียวและแข็งคล้ายไม้ ด้านล่างเป็นรูกลมเล็กๆ เชื่อมติดกัน รูสีน้ำตาล ปากรูสีขาวนวล เมื่อช้ำเปลี่ยนเป็นสีน้ำตาล ไม่มีก้าน ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหูหนูขาว");
        mr.put(COL_SCIENCE, "Tremella fuciformis");
        mr.put(COL_IMAGE, "TremellaFuciformis.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดคล้ายแผ่นวุ้นบางสีขาว รูปกลีบดอกไม้ ขอบเว้าและหยักเป็นคลื่น เมื่อดอกแห้งเปลี่ยนเป็นสีขาวอมเหลืองก่อน ก้านสั้นมาก ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหูหนูดำ");
        mr.put(COL_SCIENCE, "Auricularia auricula");
        mr.put(COL_IMAGE, "AuriculariaAuricula.JPG");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดคล้ายแผ่นวุ้น สีน้ำตาลแดง รูปพัดไม่มีด้าม ผิวด้านล่างเรียบและหยักเป็นคลื่นเล็กน้อย ผิวด้านบนบนสีอ่อนกว่า มีขนสั้นละเอียด และมีรอยจีบย่นหยักเป็นแผ่นรัศมีออกไปจากโคนที่ยึดติดกับขอนไม้ ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหูหนูรวงผึ้ง");
        mr.put(COL_SCIENCE, "Auricularia delicata");
        mr.put(COL_IMAGE, "AuriculariaDelicata.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกเห็ดรูปพัด สีน้ำตาลอ่อนอมเหลือง เมื่อเนื้อเยื่อบางใสโปร่งแสง เมื่อสดเป็นวุ้น ขอบงอลงเล็กน้อย เนื้อบาง นิ่ม ยืดหยุ่น ผิวด้านบนเรียบหรือย่นเล็กน้อย มีเมือกลื่น ผิวด้านล่างสีขาวนวล มีขนละเอียด และมีรอยจีบย่นหยักเป็นตาข่ายเหมือนรังผึ้ง ไม่มีก้านหรือถ้ามี ก้านก็สั้นมาก");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดหูหนูลายเสือ");
        mr.put(COL_SCIENCE, "Auricularia mesenterica");
        mr.put(COL_IMAGE, "AuriculariaMesenterica.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"เป็นแผ่นกลม ผิวด้านบนมีขนปกคลุมเล็กน้อย มีแถบวงกลมน้ำตาลอ่อนสลับน้ำตาลอมเทาถึงครีม คล้ายเยลลี่แต่เหนียว ขอบสีอ่อนกว่าและเป็นลอน ด้านเจริญพันธุ์หยาบ หยักย่น ม่วงอมแดง เนื้อเป็นวุ้น เมื่อแห้งสีจะเข้มขึ้ยนเปลี่ยนไปเป็นสีม่วงสด แต่เมื่อได้รับความชื้นจะคนสภาพเดิม ");
        db.insert(MUSHROOM_TABLE, null, mr);

        mr = new ContentValues();
        mr.put(COL_THAI, "เห็ดออรินจิ");
        mr.put(COL_SCIENCE, "Pleurotus eryngii");
        mr.put(COL_IMAGE, "PleurotusEryngii.jpg");
        mr.put(COL_TYPE, "eat");
        mr.put(COL_DETAIL,"ดอกมีขนาดใหญ่สีนน้ำตาล หมวกตรงกลางจะค่อยข้างหนาแต่ขอบหมวกบาง มีก้านดอกขขนาดใหญ่สีขาว ");
        db.insert(MUSHROOM_TABLE, null, mr);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
