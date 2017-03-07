package fr.app.blablawild;

import java.util.Date;

/**
 * Created by M.C on 07/03/2017.
 */

public class TripResultModel {
    public String mPrenom;
    public Date mDate;
    public int mPrix;


    public TripResultModel(String mPrenom, Date mDate,int mPrix){
        this.mPrenom = mPrenom;
        this.mDate = mDate;
        this.mPrix = mPrix;
    }

    public String getmPrenom() {
        return mPrenom;
    }

    public void setmPrenom(String mPrenom) {
        this.mPrenom = mPrenom;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public int getmPrix() {
        return mPrix;
    }

    public void setmPrix(int mPrix) {
        this.mPrix = mPrix;
    }
}
