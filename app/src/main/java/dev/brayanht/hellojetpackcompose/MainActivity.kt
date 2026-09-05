package dev.brayanht.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormularioIMC()
        }
    }
}


@Composable
fun FormularioIMC() {

    var peso by remember { mutableStateOf("") }
    var talla by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text("Calculadora IMC")

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso") }
        )

        OutlinedTextField(
            value = talla,
            onValueChange = { talla = it },
            label = { Text("Talla") }
        )

        Button(onClick = {
            val imc = peso.toDouble() / (talla.toDouble() * talla.toDouble())
            resultado = imc.toString()
        }) {
            Text("Calcular")
        }

        Text("Resultado: $resultado")
    }
}
