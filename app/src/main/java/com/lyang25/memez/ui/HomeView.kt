package com.lyang25.memez.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lyang25.memez.R
import com.lyang25.memez.ui.model.MemezVM
import com.lyang25.memez.ui.theme.MemezTheme

@Composable
fun HomeView(viewModel: MemezVM, modifier: Modifier) {

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier.weight(1f))

        Box(modifier.weight(6f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(viewModel.currImg),
                    contentDescription = "Meme Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize())
            }

            Text(text = stringResource(id = viewModel.currStr),
                color = Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.background(Color.Black)
            )
        }

        Box(modifier.weight(1f))

        Row(
            modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {

            }) {
                Text(stringResource(id = R.string.clear))
            }
            Button(onClick = {

            }) {
                Text(stringResource(id = R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    MemezTheme {
        HomeView(viewModel = viewModel(), modifier = Modifier.fillMaxSize())
    }
}

