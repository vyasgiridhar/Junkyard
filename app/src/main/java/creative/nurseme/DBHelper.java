package creative.nurseme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vyas.g on 6/1/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Parcels.db";
    public static final String TABLE_NAME = "Parcels";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "Desc";
    public static final String COLUMN_TO = "To";
    public static final String COLUMN_WEIGHT = "Weight";
    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }
    Parcel p;
    @Override
    public void onCreate(SQLiteDatabase db) {

        // TODO Auto-generated method stub
        db.execSQL(
                "create table parcels " +
                        "(id integer primary key, desc text,to text,from text,weight integer,)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public void insertParcel(Parcel P){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        //v.put("desc",A);
        //v.put("to",B);
        //v.put("weight",C);
        db.insert("parcels", null, v);
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from contacts where id ="+id+"",null);
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
    }



}
