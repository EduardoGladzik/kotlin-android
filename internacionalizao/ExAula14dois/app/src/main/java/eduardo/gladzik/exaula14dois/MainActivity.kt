package eduardo.gladzik.exaula14dois

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import eduardo.gladzik.exaula14dois.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var textName: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        button.setOnClickListener {
                val user = User(textName.text.toString())

                val intent = Intent(this@MainActivity, Screen1::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }

        private fun initializer() {
            textName = findViewById(R.id.textName)
            button = findViewById(R.id.button)
        }
    }




