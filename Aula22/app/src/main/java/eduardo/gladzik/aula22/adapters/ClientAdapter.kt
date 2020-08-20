package eduardo.gladzik.aula22.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eduardo.gladzik.aula22.R
import eduardo.gladzik.aula22.model.Client
import kotlinx.android.synthetic.main.row_clients.view.*

class ClientAdapter(val clients: List<Client>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

//    2.1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_clients, parent, false))
    }


//    1
    override fun getItemCount(): Int {
        return this.clients.size
    }

//    3
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val client = this.clients[position]

        if(holder is ViewHolder) {
            holder.bind(client, position)
        }
    }
}

//2.0
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(client: Client?, position: Int?) {
        val rowClientTextViewName = itemView.rowClientsTextViewName
        val rowClientTextViewGender = itemView.rowClientsTextViewGender
        val rowClientTextViewIncome = itemView.rowClientsTextViewIncome

        client?.let {
            rowClientTextViewName.text = it.name
            rowClientTextViewGender.text = it.gender
            rowClientTextViewIncome.text = "R$ ${it.income}"
        }
    }
}