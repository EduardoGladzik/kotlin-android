package eduardo.gladzik.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eduardo.gladzik.finalproject.R
import eduardo.gladzik.finalproject.model.Spell
import kotlinx.android.synthetic.main.row_spells.view.*

class SpellAdapter(val spells: List<Spell>, val context: Context, val listener: (Spell) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_spells, parent, false))
    }

    override fun getItemCount(): Int {
        return this.spells.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val spell = this.spells[position]

        if (holder is ViewHolder) {
            holder.bind(spell, position, context, listener)
        }
    }

    fun notifyNewData() {
        this.notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(spell: Spell?, position: Int?, context: Context, listener: (Spell) -> Unit) = with(itemView) {
        val rowSpellsTextViewId = itemView.rowSpellsTextViewId
        val rowSpellsTextViewCharacterName = itemView.rowSpellsTextViewCharacterName
        val rowSpellsTextViewSpellName = itemView.rowSpellsTextViewSpellName
        val rowSpellsTextViewSpellRange = itemView.rowSpellsTextViewSpellRange
        val rowSpellsTextViewSpellDuration = itemView.rowSpellsTextViewSpellDuration
        val rowSpellsTextViewSpellLevel = itemView.rowSpellsTextViewSpellLevel
        val rowSpellsTextViewSpellClasses = itemView.rowSpellsTextViewSpellClasses
        val rowSpellsTextViewSpellCasting = itemView.rowSpellsTextViewSpellCasting

        spell?.let  {
            rowSpellsTextViewId.text = it.id.toString()
            rowSpellsTextViewCharacterName.text = it.characterName.toString()
            rowSpellsTextViewSpellName.text = it.name.toString()
            rowSpellsTextViewSpellRange.text = it.range.toString()
            rowSpellsTextViewSpellDuration.text = it.duration.toString()
            rowSpellsTextViewSpellLevel.text = it.level.toString()
            rowSpellsTextViewSpellClasses.text = it.classes.toString()
            rowSpellsTextViewSpellCasting.text = it.casting.toString()

            itemView.setOnClickListener { listener(spell) }
        }
    }
}