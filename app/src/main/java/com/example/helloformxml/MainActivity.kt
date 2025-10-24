package com.example.helloformxml

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Indico que se saque la vista del layout que hice con xml
        setContentView(R.layout.activity_main)

        //Creo variables que estarán relacionadas con los elementos del XML
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)

        //Hago la lógica del botón
        btnSaludar.setOnClickListener {
            //Extraigo la variable nombre del XML, y la convierto a String
            val nombre = etNombre.text.toString().trim()

            //Si no hay nombre pusto, actualizo el texto para que ponga su nombre, sino saludo
            if(nombre.isEmpty()){
                tvMensaje.text = "Escribe tu nombre."
            }else{
                tvMensaje.text = "Hola, $nombre"
            }

            //Este punto sirve para ocultar el teclado una vez se ha escrito
            //Extraigo algo similar a una clase del sistema de imputs que tiene android studio
            val metodosDeInputDeManager = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
            //Ejecuto un método que oculta el teclado una vez usado, pasandole la variable del texto e indicando con el 0 que se oculte
            metodosDeInputDeManager.hideSoftInputFromWindow(etNombre.windowToken,0)

        }

    }
}


