package com.example.prueba.ui.theme.componentes


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.prueba.ui.theme.azul
import com.example.prueba.ui.theme.azulClaro
import com.example.prueba.ui.theme.negro

@Composable
fun Titulo() {

    Text(
        text = "PRODUCTOS",
        style = TextStyle(
            fontSize = 24.sp,
            color = azul,
            fontWeight = FontWeight.SemiBold
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun tx_nombreProducto() {
    Text(
        text = "Nombre: ",
        style = TextStyle(
            fontSize = 16.sp,
            color = negro
        )
    )
}

@Composable
fun nombreProducto(nombreProducto: String) {

    Text(
        text = nombreProducto,
        style = TextStyle(
            fontSize = 16.sp,
            color = negro
        )
    )
}

@Composable
fun descripcion(descripcion: String) {
    Text(
        text = descripcion,
        style = TextStyle(
            fontSize = 16.sp,
            color = negro
        )
    )
}

@Composable
fun tx_precio() {
    Text(
        text = "Precio: ",
        style = TextStyle(
            fontSize = 16.sp,
            color = negro
        )
    )
}

@Composable
fun precio(precio: String) {
    Text(
        text = precio,
        style = TextStyle(
            fontSize = 16.sp,
            color = negro,
            textAlign = TextAlign.Center
        )
    )
}

//-----------Detalle

@Composable
fun tituloProducto(tituloProducto: String) {

    Text(
        text = tituloProducto,
        style = TextStyle(
            fontSize = 24.sp,
            color = negro,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Imagen(urlImagen: String) {
    val painter = rememberImagePainter(urlImagen)

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .aspectRatio(1f)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun Descripcion(descripcion: String) {
    Text(
        text = descripcion,
        style = TextStyle(
            fontSize = 20.sp,
            color = negro,
            fontWeight = FontWeight.Black
        ),
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Precio(Precio: String) {
    Text(
        text = Precio,
        style = TextStyle(
            fontSize = 16.sp,
            color = negro
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun btnRegresar(navController: NavController) {
    Button(
        modifier = Modifier
            .width(350.dp)
            .height(50.dp)
            .border(BorderStroke(1.dp, azul)),
        onClick = {
            //cerramos la pantala
            navController.popBackStack()
        },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = azulClaro,
        )
    ) {
        Text(
            text = "Regresar",
            style = TextStyle(
                fontSize = 16.sp,
                color = azul
            )
        )
    }
}

@Preview
@Composable
fun fgh() {

    tituloProducto(tituloProducto = "TREGF")

}