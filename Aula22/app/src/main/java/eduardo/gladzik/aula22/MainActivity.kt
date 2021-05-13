package eduardo.gladzik.aula22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import eduardo.gladzik.aula22.adapters.ClientAdapter
import eduardo.gladzik.aula22.extensions.toast
import eduardo.gladzik.aula22.model.Client
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ClientAdapter
    private var clients = arrayListOf<Client>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonOK.setOnClickListener {
            var client = Client(editTextName.text.toString(), editTextGender.text.toString(), editTextIncome.text.toString().toDouble())
//            Sdicionando o obj a lista
            this.clients.add(client)

            adapter.notifyInseertedItemList()

            toast("Cliente adicionado com sucesso!")
        }

    }

    private fun resultItemClicked(client: Client) {
        toast("Você clicou em ${client.toString()}")
    }

    private fun initializer() {
//        Setando o adapter
        adapter = ClientAdapter(clients, this@MainActivity, {client: Client ->  resultItemClicked(client)})
        recyclerViewClients.adapter = adapter

//        Setando o layout da RacuyclerView - linear, staggered
//        recyclerViewClients.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewClients.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}