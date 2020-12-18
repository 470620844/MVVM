package com.byl.mvvm.ui.main


import com.byl.mvvm.App
import com.byl.mvvm.databinding.ActivityTestEventBinding
import com.byl.mvvm.ui.base.BaseActivity
import com.byl.mvvm.ui.base.BaseViewModel
import com.byl.mvvm.utils.LogUtil
import com.byl.mvvm.widget.clicks
import com.jeremyliao.liveeventbus.LiveEventBus


class TestEventActivity : BaseActivity<BaseViewModel, ActivityTestEventBinding>() {


    override fun initView() {

    }

    override fun initClick() {
        v.btn.clicks {
            LogUtil.e("initClick()")
            LiveEventBus
                .get("some_key")
                .post("some_value");
        }
    }

    override fun initData() {

    }

    override fun initVM() {

    }

}