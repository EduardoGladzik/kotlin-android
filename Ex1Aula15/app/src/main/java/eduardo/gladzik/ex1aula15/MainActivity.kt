package eduardo.gladzik.ex1aula15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

//    primeira meneira - buscar xml
    private lateinit var button1: Button

//    segunda maneira - buscar xml
    private var button2: Button? = null

//    terceira maneira - buscar xml
    private val button3 by lazy { findViewById<Button>(R.id.button3)}

//     poderia ser qualquer maneira
    private lateinit var button4: Button

//    quarta maneira - chamar button5 xml via synthetic


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

//        maneiras de chamar os clicks

//        1 - Java
//        button1.setOnClickListener (object: View.OnClickListener {
//            override fun onClick(p0: View?) {
//                toast("clicou no button 1")
//            }
//        })

//        2
//        button1.setOnClickListener ( View.OnClickListener {
//            it.setBackgroundColor(resources.getColor(R.color.colorPrimary, null))
//            toast("clicou no button 1")
//        })

//        3
        button1.setOnClickListener {
            it.setBackgroundColor(resources.getColor(R.color.colorAccent, null))
        }

//        4
//        button1.setOnClickListener { toast("clicou no button 1") }
//        4
        button2?.setOnClickListener { toast("clicou no button 2") }
//        4
        button3?.setOnClickListener { toast("clicou no button3") }

//       5
        button4.setOnClickListener(this@MainActivity)
//       5
        button4.setOnLongClickListener(this@MainActivity)

//        via synthetic
        button5.setOnClickListener(this@MainActivity)
        button5.setOnLongClickListener(this@MainActivity)


    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.button4 -> {
                toast("clicou no button4 por onClick via implements")
            }
            R.id.button5 -> {
                toast("clicou no button5 por onClick via implements")
            }
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        when(p0?.id) {
            R.id.button4 -> {
                toast("clicou segurou no button4 por onLongClick via implements")
            }
            R.id.button5 -> {
                toast("clicou segurou no button5 por onLongClick via implements")
            }
        }
        return true
    }

    private fun initializer() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
//      button 3 -> by lazy
        button4 = findViewById(R.id.button4)
//      button 5 -> via synthetic
    }

    private fun toast(message: Int) {
        Toast.makeText(baseContext, getString(message), Toast.LENGTH_LONG).show()
    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }
}