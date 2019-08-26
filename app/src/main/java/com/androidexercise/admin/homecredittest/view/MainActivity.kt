package com.androidexercise.admin.homecredittest.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidexercise.admin.homecredittest.R
import com.androidexercise.admin.homecredittest.adapter.ArticlesAdapter
import com.androidexercise.admin.homecredittest.adapter.ProductAdapter
import com.androidexercise.admin.homecredittest.model.Product
import com.androidexercise.admin.homecredittest.util.RecyclerItemClickListener
import com.androidexercise.admin.homecredittest.util.invisible
import com.androidexercise.admin.homecredittest.util.visible
import com.androidexercise.admin.homecredittest.view.WebViewActivity.Companion.WEB_VIEW
import com.androidexercise.admin.homecredittest.view_model.HomeVM
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mHomeVM: HomeVM = ViewModelProviders.of(this).get(HomeVM::class.java)
        mHomeVM.getItems()?.observe(this, getProduct)
        mHomeVM.status.observe(this, setInfo)

        showProgress()
    }

    private val setInfo = Observer<Boolean?> { t ->
        if (t == true) {
            Toast.makeText(this, "Success Load Data", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Cannot Load Data", Toast.LENGTH_SHORT).show()
        }
    }

    private val getProduct: Observer<List<Product>> =
        Observer { t ->
            if (t != null) {
                for (i in 0..t.size) {
                    if (i == 0) {
                        initAdapterGrid(t[i].items)
                    } else if (i > 0 && i == 1) {
                        initAdapterArticle(t[i].items)
                    }
                }
                hideProgress()
            }
        }

    private fun initAdapterArticle(t: List<Product.Items>) {
        rv_article_section.layoutManager = LinearLayoutManager(applicationContext)
        rv_article_section.adapter = ArticlesAdapter(t)
        rv_article_section.addOnItemTouchListener(
            RecyclerItemClickListener(
                this,
                rv_article_section,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val articleUrl = t[position].link
                        startActivity<WebViewActivity>(WEB_VIEW to articleUrl)
                    }

                    override fun onItemLongClick(view: View?, position: Int) {
                        val articleUrl = t[position].link
                        startActivity<WebViewActivity>(WEB_VIEW to articleUrl)
                    }
                })
        )

    }

    private fun initAdapterGrid(t: List<Product.Items>) {
        rv_product_grid.layoutManager = GridLayoutManager(applicationContext, 3)
        rv_product_grid.adapter = ProductAdapter(t)
        rv_product_grid.addOnItemTouchListener(
            RecyclerItemClickListener(
                this,
                rv_product_grid,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val productUrl = t[position].link
                        startActivity<WebViewActivity>(WEB_VIEW to productUrl)
                    }

                    override fun onItemLongClick(view: View?, position: Int) {
                        val productUrl = t[position].link
                        startActivity<WebViewActivity>(WEB_VIEW to productUrl)
                    }
                })
        )
    }

    override fun showProgress() {
        progressBar.visible()
    }

    override fun hideProgress() {
        progressBar.invisible()
    }
}
