package com.lyang25.memez.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lyang25.memez.ui.model.MemezVM
import com.lyang25.memez.ui.theme.MemezTheme

@Composable
fun HomeView(viewModel: MemezVM, modifier: Modifier) {
    Text(
        text = "I'm going to kill myself",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    MemezTheme {
        HomeView(viewModel = viewModel(), modifier = Modifier.fillMaxSize())
    }
}

