# 🪧 HelloFormXML - AdanRomero

## 📱 Descripción del proyecto

HelloFormXML es una aplicación Android sencilla desarrollada en Kotlin, cuyo objetivo es practicar el uso de layouts XML y los componentes básicos de interfaz (EditText, Button, TextView) dentro de una Activity.

La app permite al usuario escribir su nombre, pulsar un botón y recibir un saludo personalizado. Además, incorpora varias mejoras opcionales relacionadas con la gestión de eventos y el ciclo de vida de la app.

## 🧩 Estructura y funcionamiento

### 1. Interfaz XML (activity_main.xml)

- **LinearLayout** vertical para organizar los elementos
- **EditText** (etNombre) para introducir el nombre
- **Button** (btnSaludar) con el texto "Saludar"
- **TextView** (tvMensaje) para mostrar el saludo
- **TextView** adicional (caracteresContador) para mostrar el número de caracteres introducidos

### 2. Lógica en Kotlin (MainActivity.kt)

- Se usan referencias a las vistas mediante `findViewById`
- Evento `setOnClickListener` en el botón para mostrar el saludo
- Si el campo está vacío → muestra "Escribe tu nombre."
- Si tiene texto → muestra "👋 Hola, <nombre>"
- El teclado se oculta automáticamente tras pulsar el botón

## 🧠 Funcionalidades extra (+3 pts)

| Funcionalidad extra | Descripción | Implementación |
|---------------------|-------------|----------------|
| Desactivar botón si no hay texto | Usa TextWatcher para detectar texto en el campo y habilitar o deshabilitar el botón | `btnSaludar.isEnabled = !s.isNullOrEmpty()` |
| Ocultar teclado tras saludar | Utiliza InputMethodManager para cerrar el teclado virtual después del clic | `hideSoftInputFromWindow()` |
| Contador de caracteres | Muestra el número de caracteres introducidos en tiempo real debajo del EditText | Actualiza `tvContador` con `afterTextChanged()` |
| Reinicio al cerrar la app | Se limpia la interfaz al pasar la app a segundo plano | Implementado con `onStop()` + `resetUi()` |

## ⚙️ Configuración y ejecución

1. Abre el proyecto en Android Studio
2. Verifica que el `minSdkVersion` sea al menos 25
3. Ejecuta el proyecto en un emulador o dispositivo físico
4. Escribe tu nombre, pulsa "Saludar" y observa la respuesta

## 📸 Evidencia visual
<img width="3664" height="1930" alt="image" src="https://github.com/user-attachments/assets/79658eae-7591-4d09-b3e7-6bd00f31edd0" />

<img width="3630" height="1295" alt="image" src="https://github.com/user-attachments/assets/fd6dbdf6-141c-4b6e-aea6-186bc89a3c5f" />


## 🧑‍💻 Autor

**Adán Romero Marrero**  
Proyecto desarrollado para la actividad "Saludador - HelloFormXML"  
Materia: PGL  
Año: 2025
