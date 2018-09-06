package com.tjaffar.listhits

import java.io.Serializable

data class SearchInfoList(val title: String,
                      val timestamp: String,
                      val snippet: String,
                      val pageid: Int,
                      val wordcount: Int) : Serializable