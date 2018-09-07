package com.tjaffar.listhits

import android.text.Html
import android.util.Log

class Tools {
    fun printf(string: String) {
        Log.d("Log", string)
    }
    fun htmlToText(string : String) : String{
        return Html.fromHtml(string).toString()
    }
    companion object {
        fun create():Tools = Tools()
    }
}