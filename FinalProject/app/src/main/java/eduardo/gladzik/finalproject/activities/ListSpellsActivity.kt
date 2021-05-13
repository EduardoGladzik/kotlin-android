package eduardo.gladzik.finalproject.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.remove
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import eduardo.gladzik.finalproject.R
import eduardo.gladzik.finalproject.adapter.SpellAdapter
import eduardo.gladzik.finalproject.extensions.toast
import eduardo.gladzik.finalproject.model.Spell
import eduardo.gladzik.finalproject.service.RetrofitInitializer
import kotlinx.android.synthetic.main.list_spells_activity.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListSpellsActivity : AppCompatActivity() {

    private lateinit var adapter: SpellAdapter
    private var spells = arrayListOf<Spell>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_spells_activity)

        val actionBar = supportActionBar
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = getText(R.string.list_activity_name)
        }

        initializer()
        loadData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initializer() {
        
        adapter = SpellAdapter(spells, this@ListSpellsActivity, { spell: Spell ->  resultItemClicked(spell)})

        recyclerViewSpells.adapter = adapter

        recyclerViewSpells.layoutManager = LinearLayoutManager(this@ListSpellsActivity)

        listSpellsProgressBar.visibility = View.INVISIBLE
    }

    private fun resultItemClicked(spell: Spell) {

        val dialogBuilder = AlertDialog.Builder(this@ListSpellsActivity)

        val alert = dialogBuilder
            .setTitle(getText(R.string.attention))
            .setMessage(getText(R.string.you_want_to_delete_or_update))
            .setPositiveButton(getText(R.string.delete), DialogInterface.OnClickListener {
                    dialog, id ->

                remove(spell)
            })
            .setNegativeButton(getText(R.string.update), DialogInterface.OnClickListener {
                dialog, id ->

                val intent = Intent(this@ListSpellsActivity, AddSpellsActivity::class.java)
                intent.putExtra("spell", spell)
                startActivity(intent)
                finish()
            }).create()
        alert.show()
    }

    private fun remove(spell: Spell) {
        listSpellsProgressBar.visibility = View.VISIBLE

        val call = RetrofitInitializer().spellsService().delete(spell.id)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                listSpellsProgressBar.visibility = View.INVISIBLE
                toast(R.string.error_try_again)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                listSpellsProgressBar.visibility = View.INVISIBLE
                if(response.isSuccessful) {
                    toast(R.string.spell_successfully_deleted)
                    spells.remove(spell)
                    adapter.notifyNewData()
                }
            }

        })
    }

    private fun loadData() {
        listSpellsProgressBar.visibility = View.INVISIBLE

        val call = RetrofitInitializer().spellsService().findAll()

        call.enqueue(object: Callback<List<Spell>> {
            override fun onFailure(call: Call<List<Spell>>, t: Throwable) {
                listSpellsProgressBar.visibility = View.INVISIBLE
                toast(R.string.error_try_again)
            }

            override fun onResponse(call: Call<List<Spell>>, response: Response<List<Spell>>) {
                listSpellsProgressBar.visibility = View.INVISIBLE

                val newSpell: List<Spell>? = response.body()
                newSpell?.let {
                    for(spell in it) {
                        spells.add(spell)
                    }
                    adapter.notifyNewData()
                }
            }
        })
    }
}