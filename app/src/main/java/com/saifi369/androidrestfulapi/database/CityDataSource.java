package com.saifi369.androidrestfulapi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.saifi369.androidrestfulapi.model.CityDataItem;
import com.saifi369.androidrestfulapi.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.List;

public class CityDataSource {

    private static final String TAG = "mytag";
    private Context mContext;
    private MyDBOpenHelper myDBOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public CityDataSource(Context mContext) {
        this.mContext = mContext;
        this.myDBOpenHelper=new MyDBOpenHelper(mContext);
        sqLiteDatabase=myDBOpenHelper.getWritableDatabase();

    }

    public void open(){
        sqLiteDatabase=myDBOpenHelper.getWritableDatabase();

    }

    public void close(){
        sqLiteDatabase.close();
    }

    public void insertItem(CityDataItem item){
        ContentValues values=item.getValues();

        long insert = sqLiteDatabase.insert(CityTable.TABLE_CITY, null, values);
        Log.d(TAG, "insertItem: "+insert);

    }

    public long getItemsCount(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,CityTable.TABLE_CITY);
    }

    public List<CityDataItem> getAllItems(String selection){
        List<CityDataItem> cityDataItems=new ArrayList<>();
        //select * from cities where prov=selection;delete database

        Cursor cursor;
        if(selection==null){

            cursor = sqLiteDatabase.query(CityTable.TABLE_CITY, CityTable.ALL_COLUMNS,
                    null, null, null, null, CityTable.COLUMN_NAME);
        }else{

            String[] select={selection};
            cursor = sqLiteDatabase.query(CityTable.TABLE_CITY, CityTable.ALL_COLUMNS,
                    CityTable.COLUMN_PROVINC+"=?", select, null, null, CityTable.COLUMN_NAME);
        }

        while (cursor.moveToNext()){
            CityDataItem item=new CityDataItem();

            item.setCityId(cursor.getString(cursor.getColumnIndex(CityTable.COLUMN_ID)));
            item.setCityName(cursor.getString(cursor.getColumnIndex(CityTable.COLUMN_NAME)));
            item.setRank(cursor.getInt(cursor.getColumnIndex(CityTable.COLUMN_RANK)));
            item.setProvince(cursor.getString(cursor.getColumnIndex(CityTable.COLUMN_PROVINC)));
            item.setPopulation(cursor.getLong(cursor.getColumnIndex(CityTable.COLUMN_POPULATION)));
            item.setDescription(cursor.getString(cursor.getColumnIndex(CityTable.COLUMN_DESC)));
            item.setImage(cursor.getString(cursor.getColumnIndex(CityTable.COLUMN_IMAGE)));

            cityDataItems.add(item);

        }

        cursor.close();

        return cityDataItems;

    }

    public void seedDatabase() {

        List<CityDataItem> dataItems = SampleDataProvider.cityDataItemList;
        if (getItemsCount() == 0) {
            for (CityDataItem item : dataItems) {
                insertItem(item);
            }
        }
        Log.d(TAG, "seedDatabase: Data inserted into database");
    }

    public void updateCityName(String name){

        ContentValues values=new ContentValues(1);
        values.put(CityTable.COLUMN_NAME,name);

        String where=CityTable.COLUMN_NAME + " LIKE ?";

        String whereArgs[] ={"Lahore"};

        int update = sqLiteDatabase.update(CityTable.TABLE_CITY, values, where, whereArgs);

        Log.d(TAG, "updateCityName: "+update);
    }

    public void deleteCityItem(){

        String where=CityTable.COLUMN_PROVINC+" LIKE ? ";

        String[] whereArgs={"Punjab"};

        int delete = sqLiteDatabase.delete(CityTable.TABLE_CITY, where, whereArgs);

        Log.d(TAG, "deleteCityItem: deleted rows "+delete);

    }

}
