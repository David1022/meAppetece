package com.appdesigndm.meappetece;

import android.os.Parcel;
import android.os.Parcelable;

public class ResponseModel implements Parcelable {

    private Integer numFailedLogin = 0;
    private Integer numAttemptsFirstKissDate = 0;
    private Integer numFailedFirstDinner = 0;
    private String barcaMadrid = "";
    private String bestTravel = "";
    private String nextScape = "";
    private String nextTravel = "";
    private Integer numFailedLoveMe = 0;
    private Integer numFailedMarryMe = 0;

    public ResponseModel() {
    }

    public ResponseModel(Parcel in) {
        readFromParcel(in);
    }

    public ResponseModel(Integer numFailedLogin, Integer numAttemptsFirstKissDate, Integer numFailedFirstDinner,
            String barcaMadrid, String bestTravel, String nextScape, String nextTravel, Integer numFailedLoveMe,
            Integer numFailedMarryMe) {
        this.numFailedLogin = numFailedLogin;
        this.numAttemptsFirstKissDate = numAttemptsFirstKissDate;
        this.numFailedFirstDinner = numFailedFirstDinner;
        this.barcaMadrid = barcaMadrid;
        this.bestTravel = bestTravel;
        this.nextScape = nextScape;
        this.nextTravel = nextTravel;
        this.numFailedLoveMe = numFailedLoveMe;
        this.numFailedMarryMe = numFailedMarryMe;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(numFailedLogin);
        parcel.writeInt(numAttemptsFirstKissDate);
        parcel.writeInt(numFailedFirstDinner);
        parcel.writeString(barcaMadrid);
        parcel.writeString(bestTravel);
        parcel.writeString(nextScape);
        parcel.writeString(nextTravel);
        parcel.writeInt(numFailedLoveMe);
        parcel.writeInt(numFailedMarryMe);
    }

    public void readFromParcel(Parcel in) {
        numFailedLogin = in.readInt();
        numAttemptsFirstKissDate = in.readInt();
        numFailedFirstDinner = in.readInt();
        barcaMadrid = in.readString();
        bestTravel = in.readString();
        nextScape = in.readString();
        nextTravel = in.readString();
        numFailedLoveMe = in.readInt();
        numFailedMarryMe = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Integer getNumFailedLogin() {
        return numFailedLogin;
    }

    public void setNumFailedLogin(Integer numFailedLogin) {
        this.numFailedLogin = numFailedLogin;
    }

    public Integer getNumAttemptsFirstKissDate() {
        return numAttemptsFirstKissDate;
    }

    public void setNumAttemptsFirstKissDate(Integer numAttemptsFirstKissDate) {
        this.numAttemptsFirstKissDate = numAttemptsFirstKissDate;
    }

    public Integer getNumFailedFirstDinner() {
        return numFailedFirstDinner;
    }

    public void setNumFailedFirstDinner(Integer numFailedFirstDinner) {
        this.numFailedFirstDinner = numFailedFirstDinner;
    }

    public String getBarcaMadrid() {
        return barcaMadrid;
    }

    public void setBarcaMadrid(String barcaMadrid) {
        this.barcaMadrid = barcaMadrid;
    }

    public String getBestTravel() {
        return bestTravel;
    }

    public void setBestTravel(String bestTravel) {
        this.bestTravel = bestTravel;
    }

    public String getNextScape() {
        return nextScape;
    }

    public void setNextScape(String nextScape) {
        this.nextScape = nextScape;
    }

    public String getNextTravel() {
        return nextTravel;
    }

    public void setNextTravel(String nextTravel) {
        this.nextTravel = nextTravel;
    }

    public Integer getNumFailedLoveMe() {
        return numFailedLoveMe;
    }

    public void setNumFailedLoveMe(Integer numFailedLoveMe) {
        this.numFailedLoveMe = numFailedLoveMe;
    }

    public Integer getNumFailedMarryMe() {
        return numFailedMarryMe;
    }

    public void setNumFailedMarryMe(Integer numFailedMarryMe) {
        this.numFailedMarryMe = numFailedMarryMe;
    }

    public static Creator<ResponseModel> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "numFailedLogin=" + numFailedLogin +
                ", numAttemptsFirstKissDate=" + numAttemptsFirstKissDate +
                ", numFailedFirstDinner=" + numFailedFirstDinner +
                ", barcaMadrid='" + barcaMadrid + '\'' +
                ", bestTravel='" + bestTravel + '\'' +
                ", nextScape='" + nextScape + '\'' +
                ", nextTravel='" + nextTravel + '\'' +
                ", numFailedLoveMe=" + numFailedLoveMe +
                ", numFailedMarryMe=" + numFailedMarryMe +
                '}';
    }

    public static final Creator<ResponseModel> CREATOR = new Creator<ResponseModel>() {
        @Override
        public ResponseModel createFromParcel(Parcel in) {
            return new ResponseModel(in);
        }

        @Override
        public ResponseModel[] newArray(int size) {
            return new ResponseModel[size];
        }
    };
}
