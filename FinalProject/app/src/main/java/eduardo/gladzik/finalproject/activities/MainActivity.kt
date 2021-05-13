package eduardo.gladzik.finalproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eduardo.gladzik.finalproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityButtonAddSpells.setOnClickListener { startActivity(Intent(this@MainActivity, AddSpellsActivity::class.java)) }
        mainActivityButtonListSpells.setOnClickListener { startActivity(Intent(this@MainActivity, ListSpellsActivity::class.java)) }
    }
}