package com.example.ezetapapplicaton.data.model

import android.os.Parcel
import android.os.Parcelable

class Uidata():Parcelable{
     var uitype: String? = null
     var value: String? = null
     var key: String? = null
     var hint: String? = null

    constructor(parcel: Parcel) : this() {
        uitype = parcel.readString()
        value = parcel.readString()
        key = parcel.readString()
        hint = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uitype)
        parcel.writeString(value)
        parcel.writeString(key)
        parcel.writeString(hint)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Uidata> {
        override fun createFromParcel(parcel: Parcel): Uidata {
            return Uidata(parcel)
        }

        override fun newArray(size: Int): Array<Uidata?> {
            return arrayOfNulls(size)
        }
    }
}

 