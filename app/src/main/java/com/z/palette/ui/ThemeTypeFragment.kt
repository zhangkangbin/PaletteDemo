package com.z.palette.ui

import android.view.View
import com.z.palette.R
import com.z.palette.base.BaseFragment
import kotlinx.coroutines.*


/**
 * @author by zhangkangbin
 * on 2020/5/13
 * 界面说明
 */
class ThemeTypeFragment : BaseFragment() {
    override fun initView(view: View) {

    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_history_theme_list
    }


    fun getText(){

        GlobalScope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                // network request
                delay(3000)
                "Get it"
            }

        }

    }

}