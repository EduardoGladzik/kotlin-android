package eduardo.gladzik.exaula14.model

// primeira forma - Serializeble
//import java.io.Serializable
//
//class User : Serializable {
//
//    var name: String? = ""
//    var password: String? = ""
//
//    override fun toString(): String {
//        return "User(name='$name', password='$password')"
//    }
//}

// segunda forma - Parcelable

import android.os.Parcel
import android.os.Parcelable

class User(var name: String?, var password: String?) : Parcelable {

    override fun toString(): String {
        return "Objeto(name=$name, password=$password)"
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(password)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}