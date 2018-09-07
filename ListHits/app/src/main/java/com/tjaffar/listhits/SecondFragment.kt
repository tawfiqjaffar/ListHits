package com.tjaffar.listhits

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.io.Serializable

class SecondFragment : Fragment() {

    private lateinit var article : SearchInfoList

    companion object {
        open fun newInstance(article : Serializable) : SecondFragment {
            val args = Bundle()

            args.putSerializable("article", article)
            val frag = SecondFragment()

            frag.arguments = args
            return frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_second, container, false)
    }
}