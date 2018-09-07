package com.tjaffar.listhits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.io.Serializable

class ArticlePageDisplay : AppCompatActivity() {

    private lateinit var articleTitle : TextView
    private lateinit var articleContent: TextView
    private lateinit var article : SearchInfoList
    private val tool :Tools = Tools.create()
    //private val title = findViewById<TextView>(R.id.textViewArticleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_page_display)
        article = intent.getSerializableExtra(EXTRA_ITEM) as SearchInfoList

        setupView()
    }

    private fun setupView() {
        articleTitle = findViewById(R.id.textViewArticleName)
        articleContent = findViewById(R.id.textViewArticleContent)
        articleTitle.text = article.title
        articleContent.text = tool.htmlToText(article.snippet)
    }
}
