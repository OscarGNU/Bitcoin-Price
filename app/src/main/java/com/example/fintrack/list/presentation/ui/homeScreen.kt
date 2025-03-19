package com.example.fintrack.list.presentation.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun SplashScreen(navController: NavController) {
    // Inicia el temporizador y navega después de 6 segundos
    LaunchedEffect(Unit) {
        delay(6000) // Espera 6 segundos
    }

    // Contenido de la SplashScreen
    SplashScreenContent(navController)
}

@Composable
fun SplashScreenContent(navController: NavController? = null) {
    var textColor by remember { mutableStateOf(Color.White) } // Estado del color del texto

    // Contenedor de la pantalla con fondo oscuro
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF050715)) // Color de fondo oscuro
    ) {
        // Imagen en el fondo
        Image(
            painter = painterResource(id = R.drawable.screensplas), // Reemplaza con tu logo
            contentDescription = "Logo de la empresa",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize() // La imagen cubre toda la pantalla
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp), // Ajusta la altura de los elementos
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            // Texto interactivo "Bitcoin Price"
            Text(
                text = "Bitcoin Price",
                color = textColor,
                fontSize = 32.sp, // Tamaño del texto
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 20.dp) // Espaciado con el botón
            )

            // Botón ovalado con color fijo amarillo y texto negro
            Button(
                onClick = {
                    navController?.navigate("bitcoin_price_screen") // Navega a la pantalla de precio de BTC
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                shape = RoundedCornerShape(50.dp), // Bordes ovalados
                modifier = Modifier
                    .width(220.dp)
                    .height(55.dp)
            ) {
                Text(text = "Ver Precio BTC", fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// Versión para vista previa sin NavController
@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreenContent()
}

