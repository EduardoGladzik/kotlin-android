package eduardo.gladzik.exaula14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eduardo.gladzik.exaula14.model.User

class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

//        Primeira forma - Serializeble
//        val user = intent.getSerializableExtra("user") as User

//        Segunda forma - Parcelable
        val user = intent.getParcelableExtra<User>("user")

        Toast.makeText(baseContext, "Objeto: ${user}", Toast.LENGTH_LONG).show()
    }
}