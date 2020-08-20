package eduardo.gladzik.exaula19menunativo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import eduardo.gladzik.exaula19menunativo.extensions.toast
import eduardo.gladzik.exaula19menunativo.utility.Utility

class MainActivity : AppCompatActivity() {

    private val MENU_MAINACTIVITY_3: Int = 300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        menu!!.add(MENU_MAINACTIVITY_3, MENU_MAINACTIVITY_3, MENU_MAINACTIVITY_3, getText(R.string.menu_mainactivity_3))
            .setIcon(R.mipmap.ic_launcher)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menuMainItem1 -> {
//                primeira maneira
//                Toast.makeText(baseContext, "Clicou no menu 1", Toast.LENGTH_LONG).show()

//                segunda menira
//                toast("Clicou no menu 1")
//                toast(R.string.mainactivity_menu_1)

//                Terceira maneira
//                Utility.toast(R.string.mainactivity_menu_1, this@MainActivity)
//                Utility.toast("Clicou no menu 1", this@MainActivity)

//                -> Extensions
//                    val name : String = "eduardo"
//                    name.capitalize()
//                    name.subSequence(0, 3).toString().toUpperCase()
//                    name.toUpperCase()

//                Quarta maneira - via Extensions
//                toast("Clicou no menu 1")
            toast(R.string.mainactivity_menu_1)
        }
            R.id.menuMainItem2 -> {
                toast(R.string.mainactivity_menu_2)
            }
            MENU_MAINACTIVITY_3 -> {
                toast(R.string.mainactivity_menu_3)
            }
            else -> {
                toast("Invalid")
            }
        }
        return super.onOptionsItemSelected(item)
    }

//    segunda maneira
//    fun toast(message: String) {
//        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
//    }
//
//    fun toast(message: Int) {
//        Toast.makeText(baseContext, getText(message), Toast.LENGTH_LONG).show()
//    }
}