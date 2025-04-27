package com.example.stressapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var urlInput: EditText
    private lateinit var loadButton: Button
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlInput = findViewById(R.id.urlInput)
        loadButton = findViewById(R.id.loadButton)
        webView = findViewById(R.id.webView)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        loadButton.setOnClickListener {
            var url = urlInput.text.toString().trim()
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://$url"
            }
            webView.loadUrl(url)
        }
    }
}
