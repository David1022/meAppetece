package com.appdesigndm.meappetece;

import android.os.Parcel;
import android.os.Parcelable;

public class ResponseModel implements Parcelable {

    public static Integer numFailedLogin = 0;
    public static Integer numAttemptsFirstKissDate = 0;
    public static Integer numFailedFirstDinner = 0;
    public static String barcaMadrid = "";
    public static String bestTravel = "";
    public static String nextScape = "";
    public static String nextTravel = "";
    public static Integer numFailedLoveMe = 0;
    public static Integer numFailedMarryMe = 0;

    public ResponseModel() {
    }

    public ResponseModel(Parcel in) {
        readFromParcel(in);
    }

    public ResponseModel(
            Integer numFailedLogin,
            Integer numAttemptsFirstKissDate,
            Integer numFailedFirstDinner,
            String barcaMadrid,
            String bestTravel,
            String nextScape,
            String nextTravel,
            Integer numFailedLoveMe,
            Integer numFailedMarryMe
    ) {
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

    public static Integer getNumFailedLogin() {
        return numFailedLogin;
    }

    public static void setNumFailedLogin(Integer numFailedLogin) {
        ResponseModel.numFailedLogin = numFailedLogin;
    }

    public static Integer getNumAttemptsFirstKissDate() {
        return numAttemptsFirstKissDate;
    }

    public static void setNumAttemptsFirstKissDate(Integer numAttemptsFirstKissDate) {
        ResponseModel.numAttemptsFirstKissDate = numAttemptsFirstKissDate;
    }

    public static Integer getNumFailedFirstDinner() {
        return numFailedFirstDinner;
    }

    public static void setNumFailedFirstDinner(Integer numFailedFirstDinner) {
        ResponseModel.numFailedFirstDinner = numFailedFirstDinner;
    }

    public static String getBarcaMadrid() {
        return barcaMadrid;
    }

    public static void setBarcaMadrid(String barcaMadrid) {
        ResponseModel.barcaMadrid = barcaMadrid;
    }

    public static String getBestTravel() {
        return bestTravel;
    }

    public static void setBestTravel(String bestTravel) {
        ResponseModel.bestTravel = bestTravel;
    }

    public static String getNextScape() {
        return nextScape;
    }

    public static void setNextScape(String nextScape) {
        ResponseModel.nextScape = nextScape;
    }

    public static String getNextTravel() {
        return nextTravel;
    }

    public static void setNextTravel(String nextTravel) {
        ResponseModel.nextTravel = nextTravel;
    }

    public static Integer getNumFailedLoveMe() {
        return numFailedLoveMe;
    }

    public static void setNumFailedLoveMe(Integer numFailedLoveMe) {
        ResponseModel.numFailedLoveMe = numFailedLoveMe;
    }

    public static Integer getNumFailedMarryMe() {
        return numFailedMarryMe;
    }

    public static void setNumFailedMarryMe(Integer numFailedMarryMe) {
        ResponseModel.numFailedMarryMe = numFailedMarryMe;
    }

    @Override
    public int describeContents() {
        return 0;
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
