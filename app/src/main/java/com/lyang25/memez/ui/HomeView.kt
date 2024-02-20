package com.lyang25.memez.ui

import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lyang25.memez.R
import com.lyang25.memez.ui.model.MemezVM
import com.lyang25.memez.ui.theme.MemezTheme

@Composable
fun HomeView(viewModel: MemezVM, modifier: Modifier) {

    val context = LocalContext.current

    val mMediaPlayer = MediaPlayer.create(context, R.raw.ssb_instr)

    val toastMsg1 = stringResource(id = R.string.cclick)

    val toastMsg2 = pluralStringResource(
        id = R.plurals.memesgen,
        viewModel.counter,
        viewModel.counter
    )

    var angle by remember { mutableStateOf(0f) }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier.weight(2f),
            contentAlignment = Alignment.Center) {

            Row {
                IconButton(onClick = { mMediaPlayer.start() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_auto_awesome_24),
                        contentDescription = "",
                        Modifier.size(100.dp))
                }
            }
        }

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
                    modifier = Modifier.fillMaxSize().rotate(angle).clickable {
                        angle = (angle + 180f) % 360f
                    })
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
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                viewModel.clearCounter()
                Toast.makeText(context, toastMsg1, Toast.LENGTH_SHORT).show()
            }) {
                Text(stringResource(id = R.string.clear))
            }
            Button(onClick = {
                viewModel.newMeme()
                Toast.makeText(context, toastMsg2, Toast.LENGTH_SHORT).show()
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

