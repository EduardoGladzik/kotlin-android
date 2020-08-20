package eduardo.gladzik.exaula13

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var buttonPhoneNumber: Button
    private lateinit var buttonUrl: Button
    private lateinit var textPhoneNumber: EditText
    private lateinit var textUrl: EditText
    private lateinit var textSomething: EditText
    private lateinit var buttonSomething: Button

    private val TAG_LOG_MAIN_ACTIVITY: String = "Log MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

        Log.d(TAG_LOG_MAIN_ACTIVITY, "Entrou no onCreate")
        initializer()

        buttonUrl.setOnClickListener {
            val URL = textUrl.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://${URL}"))
            startActivity(intent)
        }

        buttonPhoneNumber.setOnClickListener {
            val phone = textUrl.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:${phone}"))
            startActivity(intent)
        }

        buttonSomething.setOnClickListener {

            val something = textSomething.text.toString()

            val intent = Intent(this@MainActivity, Screen1::class.java)
            intent.putExtra("something", something)
            startActivity(intent)
        }
    }

    private fun initializer() {
        Log.d(TAG_LOG_MAIN_ACTIVITY, "Entrou no initializer")
        textUrl = findViewById(R.id.textBrowser)
        textPhoneNumber = findViewById(R.id.textDial)
        buttonUrl = findViewById(R.id.buttonBrowser)
        buttonPhoneNumber = findViewById(R.id.buttonDial)
        textSomething = findViewById(R.id.textSomething)
        buttonSomething = findViewById(R.id.buttonSomething)
        Log.d(TAG_LOG_MAIN_ACTIVITY, "saiu do initializer")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onDestroy")
    }
}