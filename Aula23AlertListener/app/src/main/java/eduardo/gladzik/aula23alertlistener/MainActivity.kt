package eduardo.gladzik.aula23alertlistener

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val buttonAlert by lazy { findViewById<Button>(R.id.mainActivityButtonAlert) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAlert.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this@MainActivity)

            val alert = dialogBuilder
                    .setTitle("Atenção")
                    .setMessage("Escolha sim ou não")
                    .setCancelable(false)
                    .setPositiveButton("Sim", DialogInterface.OnClickListener{
                        dialog, id ->
                        Toast.makeText(baseContext, "Clicou no sim", Toast.LENGTH_LONG).show()

                    })
                    .setNegativeButton("Não", DialogInterface.OnClickListener {
                        dialog, id ->

                        Toast.makeText(baseContext, "Clicou no não", Toast.LENGTH_LONG).show()
                    }).create()
                alert.show()
        }

    }
}