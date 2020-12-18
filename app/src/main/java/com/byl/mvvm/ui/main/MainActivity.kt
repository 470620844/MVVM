package com.byl.mvvm.ui.main

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.byl.mvvm.databinding.ActivityMainBinding
import com.byl.mvvm.ui.base.BaseActivity
import com.byl.mvvm.ui.main.adapter.ArticleListAdapter
import com.byl.mvvm.ui.main.model.ArticleBean
import com.byl.mvvm.utils.LogUtil
import com.byl.mvvm.utils.ToastUtil
import com.jeremyliao.liveeventbus.LiveEventBus


class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    var adapter: ArticleListAdapter? = null
    var list: ArrayList<ArticleBean>? = null
    var page: Int = 0


    override fun initView() {
        list = ArrayList()
        adapter = ArticleListAdapter(mContext, list!!)
        adapter!!.itemClick {
            startActivity(Intent(mContext, TestEventActivity::class.java))
        }
        v.mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        v.mRecyclerView.adapter = adapter

        vm.getArticleList(page, true)

        v.refreshLayout.setOnRefreshListener {//下拉刷新
            page = 0
            vm.getArticleList(page, false)
        }
        v.refreshLayout.setOnLoadMoreListener {//上拉加载
            vm.getArticleList(++page, false)
        }
    }

    override fun initClick() {

    }

    override fun initData() {
        LogUtil.e("initData 注册监听")
        LiveEventBus
            .get("some_key", String::class.java)
            .observe(this, Observer {
                LogUtil.e("it", it)
                ToastUtil.showToast(mContext, "主页：刷新")
                page = 0
                vm.getArticleList(page, false)

            })

    }

    override fun initVM() {
        vm.articlesData.observe(this, Observer {
            v.refreshLayout.finishRefresh()
            v.refreshLayout.finishLoadMore()
            if (page == 0) list!!.clear()
            it.datas?.let { it1 -> list!!.addAll(it1) }
            adapter!!.notifyDataSetChanged()
        })
    }


}