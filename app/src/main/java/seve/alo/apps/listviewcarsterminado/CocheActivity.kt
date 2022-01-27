package seve.alo.apps.listviewcarsterminado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

// Creamos esta clase para que cuando el usuario haga click en la imagen pueda ver el producto en detalle, aqui entrara si esta en venta
class CocheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coche)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textViewTitulo = findViewById<TextView>(R.id.textViewTitulo)
        val textViewDescripcion = findViewById<TextView>(R.id.textViewDescripcion)
        val textViewPrecio = findViewById<TextView>(R.id.textViewPrecio)

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