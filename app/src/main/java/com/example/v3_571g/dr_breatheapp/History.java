package com.example.v3_571g.dr_breatheapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class History extends ActionBarActivity {

    WebView daysWebView = null;
    WebView detailWebView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        daysWebView = (WebView)findViewById(R.id.webView);
        daysWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        daysWebView.getSettings().setJavaScriptEnabled(true);
        daysWebView.getSettings().setSaveFormData(true);
        daysWebView.getSettings().setBuiltInZoomControls(true);
        daysWebView.setVerticalScrollBarEnabled(true);
        daysWebView.setWebViewClient(mWebViewClient);
        daysWebView.setWebChromeClient(mWebChromeClient);
        daysWebView.loadUrl("file:///android_asset/days.html");



}

    WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    };

    WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            if ((title != null) && (title.trim().length() != 0)) {
                setTitle(title);
            }
        }
    };

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
