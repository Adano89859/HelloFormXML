package com.example.helloformxml

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    //Creo el método resetUi para poner a 0 el contenido de las variables
    private fun resetUi(
        etNombre: EditText,
        tvMensaje: TextView,
        btnSaludar: Button,
        caracteresContador: TextView
    ){
        //Para que al iniciar la App esté todo vacío, hago que las variables no tengan contenido al inicio
        etNombre.text.clear()
        tvMensaje.text = ""
        btnSaludar.isEnabled = false
        caracteresContador.text = "0 caracteres."
    }

    //Uso onStop para que se ejecute cuando la app deja de verse, y en ella recurro a resetUi
    override fun onStop() {
        super.onStop()

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val caracteresContador = findViewById<TextView>(R.id.caracteresContador)

        //Llamo a resetUi
        resetUi(etNombre, tvMensaje, btnSaludar, caracteresContador)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Indico que se saque la vista del layout que hice con xml
        setContentView(R.layout.activity_main)

        //Creo variables que estarán relacionadas con los elementos del XML
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val caracteresContador = findViewById<TextView>(R.id.caracteresContador)


        //Lógica para desactivar el botón de saludar si no se ha incertado el nombre
        //Primero hago que el boton de saludar no esté disponible
        btnSaludar.isEnabled = false

        //Ahora hago uso de TextWatcher dentro de la variable "etNombre", para dentro de la lógica, elegir si el botón está disponible o no
        etNombre.addTextChangedListener(object : android.text.TextWatcher{

            //Este método lo implemeto porque sino "object" me da error
            //De todas formas, tiene contenido que se ejecuta antes de cambiar el texto
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {

            }

            //Este método lo implemeto porque sino "object" me da error
            //De todas formas, tiene contenido que se ejecuta mientras de cambiar el texto
            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {

            }


            //Coloco un método que mira si el texto tiene texto o no justo tras ser medificado
            override fun afterTextChanged(esEditable : android.text.Editable?) {
                //Si el contenido del texto no es nulo o está vacío, el botón se activará
                btnSaludar.isEnabled = !esEditable.isNullOrEmpty()

                //Añado lo referido a carcateres, su cantidad, y actualizar el texto
                val cantidadCarcateres = esEditable?.length ?: 0
                caracteresContador.text = "$cantidadCarcateres caracteres."
            }

        })


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


