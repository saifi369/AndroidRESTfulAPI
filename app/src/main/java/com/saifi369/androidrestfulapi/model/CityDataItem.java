package com.saifi369.androidrestfulapi.model;

import android.content.ContentValues;
import com.saifi369.androidrestfulapi.database.CityTable;
import java.util.UUID;

public class CityDataItem {

    private String cityId;
    private String cityName;
    private int rank;
    private String province;
    private long population;
    private String description;
    private String image;


    public CityDataItem() {
    }

    public CityDataItem(String cityId, String cityName,
                        int rank, String province,
                        long population, String description, String image) {

        if (cityId == null) {
            cityId=UUID.randomUUID().toString();
        }

        this.cityId = cityId;
        this.cityName = cityName;
        this.rank = rank;
        this.province = province;
        this.population = population;
        this.description = description;
        this.image = image;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ContentValues getValues(){
        ContentValues values=new ContentValues(7);

        values.put(CityTable.COLUMN_ID,this.cityId);
        values.put(CityTable.COLUMN_NAME,this.cityName);
        values.put(CityTable.COLUMN_RANK,this.rank);
        values.put(CityTable.COLUMN_PROVINC,this.province);
        values.put(CityTable.COLUMN_POPULATION,this.population);
        values.put(CityTable.COLUMN_DESC,this.description);
        values.put(CityTable.COLUMN_IMAGE,this.image);

        return values;
    }


    @Override
    public String toString() {
        return "CityDataItem{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", rank=" + rank +
                ", province='" + province + '\'' +
                ", population=" + population +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}



