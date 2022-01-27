package seve.alo.apps.listviewcarsterminado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.molde_coche.*

// Creamos esta clase para que cuando el usuario haga click en la imagen pueda ver el producto en detalle, aqui entrara si no esta en venta
class VentaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)

        // Cremaos un Bundle para recoger la informacion que nos han mandado por el intent
        val bundle: Bundle = intent.extras!!
        val imagen = bundle.getInt("imagen")
        val titulo = bundle.getString("titulo")
        val descripcion = bundle.getString("descripcion")
        val precio = bundle.getString("precio")
        imageView.setImageResource(imagen)
        textViewTitulo.text = titulo
        textViewDescripcion.text = descripcion
        textViewPrecio.text = precio
    }
}