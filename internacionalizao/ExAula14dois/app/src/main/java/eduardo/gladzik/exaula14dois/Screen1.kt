package eduardo.gladzik.exaula14dois

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import eduardo.gladzik.exaula14dois.model.User
import kotlinx.android.synthetic.main.activity_screen1.*
import java.util.jar.Manifest

class Screen1 : AppCompatActivity() {

    private lateinit var textPhone: EditText
    private lateinit var buttonMakeCall: Button
    private lateinit var textMessage: EditText
    private lateinit var buttonMessage: Button

    private val CALL_PHONE_REQUEST_CODE: Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        val user = intent.getParcelableExtra<User>("user")
        Toast.makeText(baseContext, "Objeto: ${user}", Toast.LENGTH_LONG).show()

        initializer()

        buttonMakeCall.setOnClickListener {
            makeCall()
        }

        buttonMessage.setOnClickListener {
            sendMessage()
        }
    }

//    Retorno do alert -> allow/deny
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode) {
            CALL_PHONE_REQUEST_CODE -> {
                if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(baseContext, "Não vai ter ligação :(", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(baseContext, "aeeee..vou efetuar a ligação", Toast.LENGTH_LONG).show()
                    makeCall()
                }
            }
        }
    }

    //    Vai solicitar a permissão - alert -> allow/deny
    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@Screen1,
            arrayOf(android.Manifest.permission.CALL_PHONE),
            CALL_PHONE_REQUEST_CODE)
    }

//   Testa se a permissão foi aceita, se sim, vai ligar
    private fun makeCall() {
    val phone = textPhone.text.toString()
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phone"))

    if (ActivityCompat.checkSelfPermission(this@Screen1, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
        startActivity(intent)
    } else {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this@Screen1, android.Manifest.permission.CALL_PHONE)) {
            Toast.makeText(baseContext, "Preciso desta permissão para efetuar a ligação", Toast.LENGTH_LONG).show()
        }
        requestPermission()
    }
}

    private fun sendMessage() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textMessage.text.toString())
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun initializer() {
        textPhone = findViewById(R.id.editTextTextPersonName)
        buttonMakeCall = findViewById(R.id.button2)
        textMessage = findViewById(R.id.textMessage)
        buttonMessage = findViewById(R.id.buttonMessage)
    }
}
