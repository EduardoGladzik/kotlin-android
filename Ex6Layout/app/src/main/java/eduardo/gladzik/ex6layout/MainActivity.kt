package eduardo.gladzik.ex6layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAkechi: Button
    private lateinit var buttonFutaba: Button
    private lateinit var buttonYoshizawa: Button
    private lateinit var buttonHaru: Button
    private lateinit var buttonAnn: Button
    private lateinit var buttonJoka: Button
    private lateinit var buttonMakoto: Button
    private lateinit var buttonMorgana: Button
    private lateinit var buttonYusuke: Button
    private lateinit var buttonRyuji: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAkechi = findViewById(R.id.button_akechi)

        buttonAkechi.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var alert = AlertDialog.Builder(this@MainActivity)
                alert.setMessage(getText(R.string.akechi))
                alert.setTitle(getText(R.string.title))
                alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.mipmap.ic_launcher))
                alert.setNeutralButton(getText(R.string.title), null)
                alert.show()
            }
        })
    }
}