package com.example.ezetapapplicaton.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Dao
import com.google.gson.annotations.SerializedName

class FetchCustomeDataResponse(): Parcelable {
   @SerializedName("logo-url")
   var logourl:String?=null
  @SerializedName("heading-text")
  var headingText:String?=null

   var uidata:List<Uidata>?=null

    constructor(parcel: Parcel) : this() {
        logourl = parcel.readString()
        headingText = parcel.readString()
        uidata = parcel.createTypedArrayList(Uidata)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(logourl)
        parcel.writeString(headingText)
        parcel.writeTypedList(uidata)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FetchCustomeDataResponse> {
        override fun createFromParcel(parcel: Parcel): FetchCustomeDataResponse {
            return FetchCustomeDataResponse(parcel)
        }

        override fun newArray(size: Int): Array<FetchCustomeDataResponse?> {
            return arrayOfNulls(size)
        }
    }


}



