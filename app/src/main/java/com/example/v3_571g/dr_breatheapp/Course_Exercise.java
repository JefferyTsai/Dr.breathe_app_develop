package com.example.v3_571g.dr_breatheapp;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Course_Exercise extends Activity {
    private DrawerLayout layDrawer;
    private ListView lstDrawer;

    private ActionBarDrawerToggle drawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    WebView fish = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // initActionBar();
        initDrawer();
        initDrawerList();

        fish = (WebView)findViewById(R.id.webView3);
        //fish.addJavascriptInterface(new WebAppInterface(this), "Android");
        fish.getSettings().setJavaScriptEnabled(true);
        fish.getSettings().setSaveFormData(true);
        fish.getSettings().setBuiltInZoomControls(true);
        fish.setVerticalScrollBarEnabled(true);
        fish.setWebViewClient(mWebViewClient);
        fish.setWebChromeClient(mWebChromeClient);
        fish.loadUrl("file:///android_asset/fish.html");


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

    private void initActionBar(){
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }
    private void initDrawer(){
        setContentView(R.layout.activity_exercise);

        layDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        lstDrawer = (ListView) findViewById(R.id.left_drawer);

        layDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mTitle = mDrawerTitle = getTitle();
        drawerToggle = new ActionBarDrawerToggle(
                this,
                layDrawer,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
            }
        };
        drawerToggle.syncState();

        layDrawer.setDrawerListener(drawerToggle);
    }

    private void initDrawerList(){
        String[] drawer_menu = this.getResources().getStringArray(R.array.drawer_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawer_menu);
        lstDrawer.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coarse, menu);
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
