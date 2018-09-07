package com.tjaffar.listhits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import java.io.Serializable

class ArticlePageDisplay : AppCompatActivity() {

    private lateinit var article : Serializable
    private lateinit var viewpagerMain : ViewPager
    private lateinit var tabsMain : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_page_display)
        article = intent.getSerializableExtra(EXTRA_ITEM)

        setupView()
        setupPager()
    }

    private fun setupPager() {
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager, article)

        viewpagerMain.adapter = fragmentAdapter
        tabsMain.setupWithViewPager(viewpagerMain)
    }

    private fun setupView() {
        viewpagerMain = findViewById(R.id.viewpager_main)
        tabsMain = findViewById(R.id.tabs_main)
    }
}
