package com.androidexercise.admin.homecredittest.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidexercise.admin.homecredittest.R
import kotlinx.android.synthetic.main.activity_web_view.*


class WebViewActivity : AppCompatActivity() {

    companion object {
        const val WEB_VIEW = "detail"
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        web_view.settings.javaScriptEnabled = true

        val linkUrl = intent.getStringExtra(WEB_VIEW)
        if (linkUrl != null) {
            loadURL(linkUrl)
        }

        web_view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('Page Web Success Loaded')")
            }
        }

        web_view.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Toast.makeText(this@WebViewActivity, message, Toast.LENGTH_LONG).show()
                result?.confirm()
                return super.onJsAlert(view, url, message, result)
            }
        }
    }

    private fun loadURL(linkURL: String) {
        web_view.loadUrl(linkURL)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
