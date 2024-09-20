package com.example.lab04_act4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04_act4.ui.theme.BookCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BookCounter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BookCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    var bookTitle by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_pastel),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
                .wrapContentSize()
        ) {

            //Maciel Ancco Escobar
            Text(
                text = "Has registrado $count libros hasta ahora.",
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,

            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = bookTitle,
                onValueChange = { bookTitle = it },
                label = { Text("Título de libro") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (bookTitle.isNotBlank()) {
                        count++
                        bookTitle = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA))
            ) {
                Text("Agregar libro")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookCounter() {
    BookCounter()
}
