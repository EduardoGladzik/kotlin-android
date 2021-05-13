package thiago.cury.exrecyclerviewcardview.model

import java.io.Serializable

class Client(var id: Long,
             var name: String,
             var gender: String,
             var income: Double): Serializable {

    override fun toString(): String {
        return "Client(id=$id, name='$name', gender='$gender', income=$income)"
    }
}