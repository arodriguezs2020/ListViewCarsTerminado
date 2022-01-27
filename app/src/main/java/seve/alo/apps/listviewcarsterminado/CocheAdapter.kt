package seve.alo.apps.listviewcarsterminado

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Creamos nuestra clase CochesAdapter y le extendemos la clase BaseAdapter e implementamos los metodos que necesita
class CocheAdapter(contexto: Context, var listaDECoches: MutableList<Coche>) : BaseAdapter() {

    // Creamos una variable con el contexto
    var contexto: Context? = contexto

    // En este metodo tendremos toda la logica para pintar cada uno de los elementos en nuestro ListView
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val coche = listaDECoches[p0]
        if (coche.venta == true) {
            val inflater =
                contexto!!.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = inflater.inflate(R.layout.molde_coche_grid, null)
            miVista.findViewById<ImageView>(R.id.imageView).setImageResource(coche.imagen!!)
            miVista.findViewById<TextView>(R.id.textViewTitulo).text = coche.titulo!!
            miVista.findViewById<TextView>(R.id.textViewDescripcion).text = coche.descripcion!!
            miVista.findViewById<TextView>(R.id.textViewPrecio).text = coche.precio!!.toString()

            miVista.findViewById<ImageView>(R.id.imageView).setOnClickListener {
                val intent = Intent(contexto, CocheActivity::class.java)
                intent.putExtra("imagen", coche.imagen!!)
                intent.putExtra("titulo", coche.titulo!!)
                intent.putExtra("descriptcion", coche.descripcion!!)
                intent.putExtra("precio", coche.precio!!)
                contexto!!.startActivity(intent)
            }
            return miVista

        } else {
            val inflater =
                contexto!!.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = inflater.inflate(R.layout.molde_venta_grid, null)
            miVista.findViewById<ImageView>(R.id.imageView).setImageResource(coche.imagen!!)
            miVista.findViewById<TextView>(R.id.textViewTitulo).text = coche.titulo!!
            miVista.findViewById<TextView>(R.id.textViewDescripcion).text = coche.descripcion!!
            miVista.findViewById<TextView>(R.id.textViewPrecio).text = coche.precio!!.toString()

            miVista.findViewById<ImageView>(R.id.imageView).setOnClickListener {
                val intent = Intent(contexto, VentaActivity::class.java)
                intent.putExtra("imagen", coche.imagen!!)
                intent.putExtra("titulo", coche.titulo!!)
                intent.putExtra("descriptcion", coche.descripcion!!)
                intent.putExtra("precio", coche.precio!!)
                contexto!!.startActivity(intent)
            }

            return miVista
        }
    }

    // Estos dos metodos no son muy importantes
    override fun getItem(p0: Int): Any {
        return listaDECoches[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    // Aqui devolvemos el total de elementos que tiene nuestro array de coches
    override fun getCount(): Int {
        return listaDECoches.size
    }
}