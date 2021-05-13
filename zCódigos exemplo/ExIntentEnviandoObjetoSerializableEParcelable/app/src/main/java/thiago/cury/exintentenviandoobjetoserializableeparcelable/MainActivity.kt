package thiago.cury.exintentenviandoobjetoserializableeparcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import thiago.cury.exintentenviandoobjetoserializableeparcelable.model.Client

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var buttonSendObject: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonSendObject.setOnClickListener {
            val client = Client(editTextName.text.toString())

            val intent = Intent(this@MainActivity, Screen1::class.java)
            intent.putExtra("client", client)
            startActivity(intent)
        }

    }

    private fun initializer() {
        editTextName = findViewById(R.id.editTextName)
        buttonSendObject = findViewById(R.id.buttonSendObject)
    }
}