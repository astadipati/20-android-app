package net.ramastudio.sitara20.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Session {
    public String nama;
    public String email;
    @SerializedName("IDPerkara")
    public int idperkara;
}
