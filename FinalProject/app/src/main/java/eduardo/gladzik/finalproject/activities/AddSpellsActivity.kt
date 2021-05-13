package eduardo.gladzik.finalproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import eduardo.gladzik.finalproject.R
import eduardo.gladzik.finalproject.extensions.toast
import eduardo.gladzik.finalproject.model.Spell
import eduardo.gladzik.finalproject.service.RetrofitInitializer
import kotlinx.android.synthetic.main.add_spells_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddSpellsActivity : AppCompatActivity() {

    private lateinit var spell: Spell

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_spells_activity)

        val actionBar = supportActionBar
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = getText(R.string.add_activity_name)
        }

        addSpellsProgressBar.visibility = View.VISIBLE

        if(intent.hasExtra("spell")) {
            spell = intent.getSerializableExtra("spell") as Spell

            if(spell != null) {
                toast(R.string.update)

                addSpellsButton.setText(getText(R.string.update_spell))

                addSpellsEditTextCharacterName.setText(spell.characterName)
                addSpellsEditTextSpellName.setText(spell.name)
                addSpellsEditTextSpellRange.setText(spell.range.toString())
                addSpellsEditTextSpellDuration.setText(spell.duration)
                addSpellsEditTextSpellLevel.setText(spell.level.toString())
                addSpellsEditTextSpellClasses.setText(spell.classes)
                addSpellsEditTextSpellCasting.setText(spell.casting)
            } else {
                toast(R.string.add)
            }
        }

        addSpellsButton.setOnClickListener {
            addSpellsProgressBar.visibility = View.VISIBLE
            if(intent.hasExtra("spell")) {
                spell.characterName = addSpellsEditTextCharacterName.text.toString()
                spell.name = addSpellsEditTextSpellName.text.toString()
                spell.range = addSpellsEditTextSpellRange.text.toString().toInt()
                spell.duration = addSpellsEditTextSpellDuration.text.toString()
                spell.level = addSpellsEditTextSpellLevel.text.toString().toInt()
                spell.classes = addSpellsEditTextSpellClasses.text.toString()
                spell.casting = addSpellsEditTextSpellCasting.text.toString()
                update()
            } else {
                save()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun save() {

        spell = Spell(-20,
            addSpellsEditTextCharacterName.text.toString(),
            addSpellsEditTextSpellName.text.toString(),
            addSpellsEditTextSpellRange.text.toString().toInt(),
            addSpellsEditTextSpellDuration.text.toString(),
            addSpellsEditTextSpellLevel.text.toString().toInt(),
            addSpellsEditTextSpellClasses.text.toString(),
            addSpellsEditTextSpellCasting.text.toString())

        val call = RetrofitInitializer().spellsService().save(spell)

        call.enqueue(object : Callback<Spell> {
            override fun onFailure(call: Call<Spell>, t: Throwable) {
                addSpellsProgressBar.visibility = View.INVISIBLE
                toast(R.string.error_try_again)
            }

            override fun onResponse(call: Call<Spell>, response: Response<Spell>) {
                addSpellsProgressBar.visibility = View.INVISIBLE
                if(response.isSuccessful) {
                    
                    spell = response.body() as Spell

                    toast(R.string.spell_successfully_registered)

                }
            }

        })
    }

    private fun update() {
        val call = RetrofitInitializer().spellsService().update(this.spell.id, this.spell)

        call.enqueue(object : Callback<Spell> {
            override fun onFailure(call: Call<Spell>, t: Throwable) {
                addSpellsProgressBar.visibility = View.INVISIBLE
                toast(R.string.error_try_again)
            }

            override fun onResponse(call: Call<Spell>, response: Response<Spell>) {
                addSpellsProgressBar.visibility = View.INVISIBLE
                if(response.isSuccessful) {
                    val spell = response.body() as Spell
                    toast(R.string.spell_successfully_updated)
                }
            }

        })
    }
}