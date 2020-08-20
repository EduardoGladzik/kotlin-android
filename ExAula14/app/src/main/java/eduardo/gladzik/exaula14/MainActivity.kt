package eduardo.gladzik.exaula14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import eduardo.gladzik.exaula14.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var textName: EditText
    private lateinit var textPassword: EditText
    private lateinit var buttonConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonConfirm.setOnClickListener {
            val user = User(textName.text.toString(),textPassword.text.toString())

            val intent = Intent(this@MainActivity, Screen1::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    private fun initializer() {
        textName = findViewById(R.id.textName)
        textPassword = findViewById(R.id.textPassword)
        buttonConfirm = findViewById(R.id.buttonConfirm)
    }
}