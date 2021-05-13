package thiago.cury.exrecyclerviewcardview

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import thiago.cury.exrecyclerviewcardview.adapters.ClientAdapter
import thiago.cury.exrecyclerviewcardview.dao.ClientDAO
import thiago.cury.exrecyclerviewcardview.extensions.toast
import thiago.cury.exrecyclerviewcardview.model.Client

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ClientAdapter
    private var clients = arrayListOf<Client>()

    private lateinit var clientDAO: ClientDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonOK.setOnClickListener {
            var client = Client(1,
                                editTextName.text.toString(),
                                editTextGender.text.toString(),
                                editTextIncome.text.toString().toDouble())
            this.clients.add(client) //salvando no array
            this.clientDAO.store(client) //salvando no banco de dados!

            adapter.notifyInsertedItemList()

            toast("Cliente cadastrado com sucesso!")
        }

        //alterar!
//        val client1 = Client(4, "a", "a", 123213.12)
//        this.clientDAO.update(client1)

    }

    override fun onPause() {
        super.onPause()
        this.clientDAO.closeDatabase()
    }

    override fun onRestart() {
        super.onRestart()
        this.clientDAO.openDatabaseWritable()
    }

    private fun resultItemClicked(client: Client) {
        toast("Você clicou em: ${client.toString()}")
        Log.d("tag clicou", "tag clicou result ma")

        val dialogBuilder = AlertDialog.Builder(this@MainActivity)

        val alert = dialogBuilder
            .setTitle("Atenção")
            .setMessage("Você deseja excluir ou ver detalhes?!")
            .setCancelable(false)
            .setPositiveButton("Excluir", DialogInterface.OnClickListener {
                dialog, id ->
                //todo delete

                if(this.clientDAO.delete(client.id)) {
                    Toast.makeText(baseContext, "Cliente excluído com sucesso!", Toast.LENGTH_LONG)
                        .show()
                    this.clients.remove(client)

                    if(this.clients.isEmpty()) {
                        Toast.makeText(baseContext, "Não há mais clientes cadastrados!", Toast.LENGTH_LONG).show()
                    }

                    this.adapter.notifyData()
                } else {
                    Toast.makeText(baseContext, "Erro ao excluir!", Toast.LENGTH_LONG).show()
                }
            })
            .setNegativeButton("Ir para a próxima tela", DialogInterface.OnClickListener{
                    dialog, id ->
                //todo next screen

                val intent = Intent(this@MainActivity, ClientDetail::class.java)
                intent.putExtra("client", client)
                startActivity(intent)

            }).create()

        alert.show()
    }

    private fun initializer() {

        this.clientDAO = ClientDAO(this@MainActivity)
        this.clientDAO.openDatabaseWritable()

        this.clients = this.clientDAO.fetch() as ArrayList<Client> //cast

        //Setando o adapter
        adapter = ClientAdapter(clients, this@MainActivity, {client: Client -> resultItemClicked(client)})
        recyclerViewClients.adapter = adapter

        //Setando o gerenciador de layout do recyclerview
//        recyclerViewClients.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewClients.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}