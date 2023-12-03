package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    PantallaLemon()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaLemon() {
InteraccionInterfaz()
}

@Composable
fun Interfaz(titulo: Int, texto: Int,imagen:Int,clicks:()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.2f)
                .background(Color(255, 255, 153)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = titulo),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color(195, 236, 210))
            ) {
                Image(
                    painter = painterResource(imagen),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .clickable { clicks() }
                )
            }

            Row {
                Text(
                    text = stringResource(texto),
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
 private fun InteraccionInterfaz() {
    var posicion by remember { mutableStateOf(1) }
    var numeroDeClicks by remember { mutableStateOf(0) }

    when (posicion) {

        1 -> {
            Interfaz(
                titulo=R.string.app_name,
                texto = R.string.lemonTree,
                imagen = R.drawable.lemon_tree,
                clicks = {
                    numeroDeClicks = (2..4).random()
                    posicion++
                }
            )
        }

        2 -> {
            Interfaz(
                titulo=R.string.app_name,
                imagen = R.drawable.lemon_squeeze,
                texto = R.string.lemon,
                clicks = {
                    numeroDeClicks--
                    if (numeroDeClicks == 0) {
                        posicion++
                    }
                }
            )
        }

        3 -> {
            Interfaz(
                titulo=R.string.app_name,
                imagen = R.drawable.lemon_drink,
                texto = R.string.lemonadeDrink,
                clicks = {
                    posicion++
                }
            )
        }

        4 -> {
            Interfaz(
                titulo=R.string.app_name,
                imagen = R.drawable.lemon_restart,
                texto = R.string.emptyGlass,
                clicks = {
                    posicion = 1
                }
            )
        }
    }
}


