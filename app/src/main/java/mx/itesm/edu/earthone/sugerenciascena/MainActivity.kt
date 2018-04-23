package mx.itesm.edu.earthone.sugerenciascena

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    val cenas = arrayListOf("HotDog", "Comida China", "Tamales")
    val caloriasCenas = arrayListOf("1000", "2000", "460")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        comidaText.text = cenas[0]
        caloriasText.text = caloriasCenas[0]

        agrega.setOnClickListener {
            val input = nuevaText.text.toString().trim()
            val input2 = caloriasIngreso.text.toString().trim()
            if (input.isNullOrBlank()) {
                Toast.makeText(this@MainActivity, "Añade la comida!", Toast.LENGTH_SHORT).show()
            }
            if (input2.isNullOrBlank()) {
                Toast.makeText(this@MainActivity, "Añade las calorías!", Toast.LENGTH_SHORT).show()
            }
            if (input.isNotEmpty() && input2.isNotEmpty()) {
                val nuevaCena = nuevaText.text.toString()
                val nuevasCal = caloriasIngreso.text.toString()
                cenas.add(nuevaCena)
                caloriasCenas.add(nuevasCal)
                nuevaText.text.clear()
                caloriasIngreso.text.clear()
            }
        }
        selecciona.setOnClickListener {
            val aleatorio = Random()
            val cenaAleatoria = aleatorio.nextInt(cenas.count())
            comidaText.text = cenas[cenaAleatoria]
            caloriasText.text = caloriasCenas[cenaAleatoria]
        }
    }
}
