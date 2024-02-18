package com.lyang25.memez.ui.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lyang25.memez.R

class MemezVM: ViewModel() {

    private val images = arrayOf(
        R.drawable.memez1,
        R.drawable.memez2,
        R.drawable.memez3,
        R.drawable.memez4,
        R.drawable.memez5,
        R.drawable.memez6,
        R.drawable.memez7,
        R.drawable.memez8
    )

    private val mstrings = arrayOf(
        R.string.memestr1,
        R.string.memestr2,
        R.string.memestr3,
        R.string.memestr4,
        R.string.memestr5,
        R.string.memestr6,
        R.string.memestr7,
        R.string.memestr8
    )

    var currImg by mutableStateOf(images.random())

    var currStr by mutableStateOf(mstrings.random())

    fun newMeme() {
        currImg = images.random()
        currStr = mstrings.random()
    }
}