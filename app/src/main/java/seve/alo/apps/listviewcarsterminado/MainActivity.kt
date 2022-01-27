package seve.alo.apps.listviewcarsterminado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity(var adapter: CocheAdapter? = null, miListaDeCoches : MutableList<Coche>) : AppCompatActivity() {

    // Creamos nuestro array de Coches
    var listaDeCoches : MutableList<Coche>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Llamamos al elemento ListView que tenemos en el xml
        val gridView = findViewById<GridView>(R.id.gridView)

        // Añadimos todos nuestros Coches con cada una de sus propiedades
        this.listaDeCoches = miListaDeCoches

        // Creamos una instancia de nuestra clase CochesAdapter
        adapter = CocheAdapter(this, listaDeCoches!!)
        // Le pasamos a nuestro listView el adaptador que acabamos de instanciar
        gridView.adapter = adapter
    }

    // CRUD actions

    var miListaDeCoches : MutableList<Coche> = miListaDeCoches
    get() {
        val lista = object : ArrayList<Coche>() {
            init {
                add(Coche(R.drawable.hw_bowser_sm, "Bowser", "Coche del malvado Bowser", "Precio: $350", false))
                add(Coche(R.drawable.hw_buddy_car,"Buddy", "Coche del vaquero buddy", "Precio: $350", true))
                add(Coche(R.drawable.hw_camaro_ee_2015,"Camaro", "Coche Camaro Edición Especial", "Precio: $350", false))
                add(Coche(R.drawable.hw_charger_2014,"Charger", "Coche Charger 2014", "Precio: $350", true))
                add(Coche(R.drawable.hw_fury_shark,"Shark", "Coche del temible tiburón", "Precio: $350", false))
                add(Coche(R.drawable.hw_mario_sm,"Mario", "Coche de Super Mario", "Precio: $350", false))
                add(Coche(R.drawable.hw_toad_sm,"Toad", "Coche de Toad", "Precio: $350", true))
                add(Coche(R.drawable.hw_yoshi_sm,"Yoshi", "Coche de Yoshi", "Precio: $350", true))
            }
        }
        return lista
    }

    fun borrar(indice: Int) {
        listaDeCoches!!.removeAt(indice)
        adapter!!.notifyDataSetChanged()
    }

    fun agregar(indice: Int) {
        listaDeCoches!!.add(listaDeCoches!![indice])
        adapter!!.notifyDataSetChanged()
    }
}