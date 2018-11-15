package com.saifi369.androidrestfulapi.database;

public class CityTable {

    public static final String TABLE_CITY = "cities";

    public static final String COLUMN_ID = "cityId";
    public static final String COLUMN_NAME = "cityName";
    public static final String COLUMN_RANK = "rank";
    public static final String COLUMN_PROVINC = "province";
    public static final String COLUMN_POPULATION = "population";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_IMAGE = "image";

    public static final String[] ALL_COLUMNS=
            new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_RANK,COLUMN_PROVINC,COLUMN_POPULATION,COLUMN_DESC,COLUMN_IMAGE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_CITY + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT ," +
                    COLUMN_RANK + " INTEGER ," +
                    COLUMN_PROVINC + " TEXT ," +
                    COLUMN_POPULATION + " INTEGER ," +
                    COLUMN_DESC + " TEXT ," +
                    COLUMN_IMAGE + " TEXT);";

    public static final String SQL_DELETE=
            "DROP TABLE IF EXISTS "+TABLE_CITY;

}
