package fr.app.blablawild;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;
import android.os.Parcel;

/**
 * Created by M.C on 06/03/2017.
 */


public class SearchRequestModel implements Parcelable {

    String mVilleDepart;
    String mVilleDestination;
    String mDate;


    public SearchRequestModel(){

    }
    
    public SearchRequestModel(String mVilleDepart, String mVilleDestination, String mDAte) {
        this.mVilleDepart = mVilleDepart;
        this.mVilleDestination = mVilleDestination;
        this.mDate = mDAte;
    }

    public String getmVilleDepart() {
         return this.mVilleDepart;
    }

    public String getmVilleDestination() {
         return this.mVilleDestination;
     }

    public String getmDate() {
         return this.mDate;
     }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mVilleDepart);
        dest.writeString(mVilleDestination);
        dest.writeString(mDate);

    }

    public static final Parcelable.Creator<SearchRequestModel> CREATOR
            = new Parcelable.Creator<SearchRequestModel>() {
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

            public SearchRequestModel[] newArray(int size) {
                return new SearchRequestModel[size];
            }
        };

        private SearchRequestModel(Parcel in) {
            mVilleDepart = in.readString();
            mVilleDestination = in.readString();
            mDate = in.readString();
        }
}