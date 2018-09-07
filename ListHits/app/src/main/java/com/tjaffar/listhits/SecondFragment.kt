package com.tjaffar.listhits

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import java.io.Serializable

class SecondFragment : Fragment() {

    private lateinit var article : SearchInfoList

    companion object {
        open fun newInstance(article : Serializable) : SecondFragment {
            val args = Bundle()
            val frag = SecondFragment()

            args.putSerializable("article", article)
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        article = this.arguments!!.getSerializable("article") as SearchInfoList
        setupViews(view, article)
        return view
    }

    private fun setupViews(view: View, article: SearchInfoList) {
        val webView = view.findViewById<WebView>(R.id.webview)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                view!!.loadUrl(url)
                return true
            }
        }
        webView.loadUrl(buildUrl(article.pageid))
    }

    private fun buildUrl(pageId : Int) : String {
        val res = if (lang_global == "FR") "http://fr.wikipedia.org/?curid=" else "http://en.wikipedia.org/?curid="

        return res + pageId.toString()
    }
}