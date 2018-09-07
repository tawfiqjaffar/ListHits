package com.tjaffar.listhits

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.io.Serializable

class FirstFragment : Fragment() {

    private lateinit var articleTitle : TextView
    private lateinit var articleContent: TextView
    private lateinit var article : SearchInfoList
    private val tool = Tools.create()

    companion object {
        open fun newInstance(article : Serializable) : FirstFragment {
            val args = Bundle()
            val frag = FirstFragment()

            args.putSerializable("article", article)
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        article = this.arguments!!.getSerializable("article") as SearchInfoList
        setupViews(view, article)
        return view
    }

    private fun setupViews(view: View, article : SearchInfoList) {
        articleTitle = view.findViewById(R.id.textViewArticleName)
        articleContent = view.findViewById(R.id.textViewArticleContent)
        articleTitle.text = article.title
        articleContent.text = tool.htmlToText(article.snippet)
    }
}