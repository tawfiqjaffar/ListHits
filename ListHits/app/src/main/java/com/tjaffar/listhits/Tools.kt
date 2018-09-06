package com.tjaffar.listhits

import android.util.Log

class Tools {
    fun printf(string: String) {
        Log.d("Log", string)
    }
    companion object {
        fun create():Tools = Tools()
    }
}