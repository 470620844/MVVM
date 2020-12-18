package com.byl.mvvm.ui

import android.content.Intent
import android.os.Handler
import com.byl.mvvm.databinding.ActivitySplashBinding
import com.byl.mvvm.ui.base.BaseActivity
import com.byl.mvvm.ui.base.BaseViewModel
import com.byl.mvvm.ui.main.MainActivity
import com.byl.mvvm.utils.StatusBarUtil
import com.byl.mvvm.utils.SysUtils


class SplashActivity : BaseActivity<BaseViewModel, ActivitySplashBinding>() {


    override fun initView() {
        StatusBarUtil.immersive(this)
        StatusBarUtil.darkMode(this)
        if (!this.isTaskRoot) {
            val mainIntent = intent
            val action = mainIntent.action
            if (mainIntent.hasCategory(Intent.CATEGORY_LAUNCHER) && action == Intent.ACTION_MAIN) {
                finish()
                return
            }
        }

        init()
    }

    private fun init() {
        SysUtils.initFiles()
        Handler().postDelayed({
            startActivity(Intent(mContext, MainActivity::class.java))
            finish()
        }, 2000)
    }

    override fun initClick() {

    }

    override fun initData() {

    }

    override fun initVM() {

    }


}