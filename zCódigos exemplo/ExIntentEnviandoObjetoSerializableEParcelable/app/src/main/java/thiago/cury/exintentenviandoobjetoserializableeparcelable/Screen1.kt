package thiago.cury.exintentenviandoobjetoserializableeparcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import thiago.cury.exintentenviandoobjetoserializableeparcelable.model.Client

class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

//        Primeira maneira - via Serializable
//        val client = intent.getSerializableExtra("client") as Client

//        Segunda maneira - via Parcelable
        val client = intent.getParcelableExtra<Client>("client")

        Toast.makeText(baseContext, "Objeto: ${client}", Toast.LENGTH_LONG).show()

    }
}