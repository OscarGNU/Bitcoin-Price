package com.example.fintrack.list.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.ui.tooling.preview.Preview
import com.example.fintrack.R

@Composable
fun SplashScreen() {
    // Inicia el temporizador y navega después de 6 segundos
   LaunchedEffect(Unit) {
        delay(6000) // Espera 6 segundos
        //navController.navigate("main") {
          //  popUpTo("splash") { inclusive = true } // Evita volver a la SplashScreen
        }


    // Contenido de la SplashScreen
    SplashScreenContent()
}

@Composable
fun SplashScreenContent() {
    var textColor by remember { mutableStateOf(Color.White) } // Estado del color del texto

    // Contenedor de la pantalla con fondo oscuro
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF050715)) // Color de fondo oscuro
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo de la app
            Image(
                painter = painterResource(id = R.drawable.screensplas), // Reemplaza con tu logo
                contentDescription = "Logo de la empresa",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(300.dp) // Ajusta el tamaño manualmente
            )

            Spacer(modifier = Modifier.weight(1f)) // Espaciado para colocar el texto en la parte inferior

            // Texto interactivo "Bitcoin Price"
            Text(
                text = "Bitcoin Price",
                color = textColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable {
                        textColor = if (textColor == Color.White) Color.Yellow else Color.White
                    }
                    .padding(bottom = 50.dp) // Ajusta el espaciado inferior
            )
        }
    }
}

// Versión para vista previa sin NavController
@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    // Aquí solo mostramos el contenido sin necesidad de NavController
    SplashScreenContent()
}