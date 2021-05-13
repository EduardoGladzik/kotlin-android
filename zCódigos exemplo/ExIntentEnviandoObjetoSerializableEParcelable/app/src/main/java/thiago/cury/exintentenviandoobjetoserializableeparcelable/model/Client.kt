package thiago.cury.exintentenviandoobjetoserializableeparcelable.model

//Primeira forma de fazer - Serializable
//import java.io.Serializable
//
//class Client : Serializable {
//
//    var name: String? = ""
//
//    override fun toString(): String {
//        return "Nome $name"
//    }
//}

//Segunda forma de fazer - Parcelable
import android.os.Parcel
import android.os.Parcelable

class Client(var name: String?) : Parcelable {

    override fun toString(): String {
        return "Nome $name"
    }

    constructor(source: Parcel) : this(
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Client> = object : Parcelable.Creator<Client> {
            override fun createFromParcel(source: Parcel): Client = Client(source)
            override fun newArray(size: Int): Array<Client?> = arrayOfNulls(size)
        }
    }
}