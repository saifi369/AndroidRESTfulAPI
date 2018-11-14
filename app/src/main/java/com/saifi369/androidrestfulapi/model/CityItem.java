package com.saifi369.androidrestfulapi.model;


import android.os.Parcel;
import android.os.Parcelable;

public class CityItem implements Parcelable {

    private int id;
    private String cityname;
    private int rank;
    private double population;
    private String province;
    private String description;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.cityname);
        dest.writeInt(this.rank);
        dest.writeDouble(this.population);
        dest.writeString(this.province);
        dest.writeString(this.description);
        dest.writeString(this.image);
    }

    public CityItem() {
    }

    protected CityItem(Parcel in) {
        this.id = in.readInt();
        this.cityname = in.readString();
        this.rank = in.readInt();
        this.population = in.readDouble();
        this.province = in.readString();
        this.description = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<CityItem> CREATOR = new Parcelable.Creator<CityItem>() {
        @Override
        public CityItem createFromParcel(Parcel source) {
            return new CityItem(source);
        }

        @Override
        public CityItem[] newArray(int size) {
            return new CityItem[size];
        }
    };
}