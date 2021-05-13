package eduardo.gladzik.revisao

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class DialScreen : AppCompatActivity() {

    private val textDial by lazy { findViewById<EditText>(R.id.textDial) }
    private val buttonOpenDial by lazy { findViewById<Button>(R.id.buttonOpenDial) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dial_screen)

        buttonOpenDial.setOnClickListener { makeCall() }

    }

    private fun makeCall() {
        val phone = textDial.text.toString()
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
        startActivity(intent)
    }
}