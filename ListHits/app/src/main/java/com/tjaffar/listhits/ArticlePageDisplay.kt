package com.tjaffar.listhits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.Serializable

class ArticlePageDisplay : AppCompatActivity() {

    private val title = findViewById<TextView>(R.id.textViewArticleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_page_display)
//        val article:SearchInfoList = intent.getSerializableExtra(EXTRA_ITEM) as SearchInfoList
//
//        title.text = article.title
    }
}
