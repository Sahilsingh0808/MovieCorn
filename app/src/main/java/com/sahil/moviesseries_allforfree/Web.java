package com.sahil.moviesseries_allforfree;//package com.sahil.moviesseries_allforfree;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

//import com.monstertechno.adblocker.AdBlockerWebView;
//import com.monstertechno.adblocker.util.AdBlocker;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Web extends AppCompatActivity {
//
//    WebView webView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_web);
//        if( ! CheckNetwork. isInternetAvailable(this)) //returns true if internet available
//        {
//            //if there is no internet do this
//            setContentView(R.layout. activity_main);
//            //Toast.makeText(this,"No Internet Connection, Chris",Toast.LENGTH_LONG).show();
//
//            new AlertDialog.Builder(this) //alert the person knowing they are about to close
//                    .setTitle("No internet connection available")
//                    .setMessage("Please Check you're Mobile data or Wifi network.")
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            finish();
//                        }
//                    })
//                    //.setNegativeButton("No", null)
//                    .show();
//
//        }
//        else {
//            AdBlocker.init(this);
//            webView = (WebView) findViewById(R.id.webview);
//
//            webView.setWebChromeClient(new WebChromeClient());
//            webView.setWebViewClient(new ChromeClient());
////        new AdBlockerWebView.init(this).initializeWebView(webView);
////            webView.setWebViewClient(new Callback());
////        webView.setWebViewClient(new Browser_home());
////            webView.setWebViewClient(new MyBrowser());
//            WebSettings webSettings = webView.getSettings();
//            webSettings.setJavaScriptEnabled(true);
//            webSettings.setAllowFileAccess(true);
//            webSettings.setAppCacheEnabled(true);
//
//
//            webView.loadUrl("https://www.youtube.com/");
//        }
//    }
//
//    private class Callback extends WebViewClient {
//        @Override
//        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
//            return false;
//        }
//    }
//
//    private class Browser_home extends WebViewClient {
//
//        Browser_home() {}
//
//        @SuppressWarnings("deprecation")
//        @Override
//        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
//
//            return AdBlockerWebView.blockAds(view,url) ? AdBlocker.createEmptyResource() :
//                    super.shouldInterceptRequest(view, url);
//
//        }
//
//    }
//
//    private class MyBrowser extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view,  String url) {
//            view.loadUrl(url);
//            return true;
//        }
//        private Map<String,Boolean> loadedUrls=new HashMap<>();
//        @Nullable
//        @Override
//        public WebResourceResponse shouldInterceptRequest(WebView view,String url)
//        {
//            boolean ad;
//            if(!loadedUrls.containsKey(url))
//            {
//                ad=AdBlocker.isAd(url);
//                loadedUrls.put(url,ad);
//            }
//            else
//            {
//                ad=loadedUrls.get(url);
//            }
//            return ad?AdBlocker.createEmptyResource():super.shouldInterceptRequest(view,url);
//        }
//
//    }
//

//    private class ChromeClient extends WebViewClient {
//        private View mCustomView;
//        private WebChromeClient.CustomViewCallback mCustomViewCallback;
//        protected FrameLayout mFullscreenContainer;
//        private int mOriginalOrientation;
//        private int mOriginalSystemUiVisibility;
//
//        ChromeClient() {}
//
//        public Bitmap getDefaultVideoPoster()
//        {
//            if (mCustomView == null) {
//                return null;
//            }
//            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
//        }
//
//        public void onHideCustomView()
//        {
//            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
//            this.mCustomView = null;
//            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
//            setRequestedOrientation(this.mOriginalOrientation);
//            this.mCustomViewCallback.onCustomViewHidden();
//            this.mCustomViewCallback = null;
//        }
//
//        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
//        {
//            if (this.mCustomView != null)
//            {
//                onHideCustomView();
//                return;
//            }
//            this.mCustomView = paramView;
//            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
//            this.mOriginalOrientation = getRequestedOrientation();
//            this.mCustomViewCallback = paramCustomViewCallback;
//            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
//            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        }
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        webView.saveState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        webView.restoreState(savedInstanceState);
//    }
//}
//
//
//

import android.annotation.SuppressLint;
import android.widget.ProgressBar;


public class Web extends AppCompatActivity {

    WebView mWebView;
    ProgressBar progressBar;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_web);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        if( ! CheckNetwork. isInternetAvailable(this)) //returns true if internet available
        {
            //if there is no internet do this
            setContentView(R.layout. activity_main);
            //Toast.makeText(this,"No Internet Connection, Chris",Toast.LENGTH_LONG).show();

            new AlertDialog.Builder(this) //alert the person knowing they are about to close
                    .setTitle("No internet connection available")
                    .setMessage("Please Check you're Mobile data or Wifi network.")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    //.setNegativeButton("No", null)
                    .show();

        }
        else {

            mWebView = (WebView) findViewById(R.id.mWebView);

            mWebView.setWebViewClient(new WebViewClient());
            mWebView.setWebChromeClient(new MyChrome());
//            mWebView.setWebViewClient(new Callback());
//            AdBlocker.init(this);
//            new AdBlockerWebView.init(this).initializeWebView(mWebView);
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAllowFileAccess(true);
            webSettings.setAppCacheEnabled(true);

            if (savedInstanceState == null) {
                mWebView.loadUrl("https://ev01.to/");
            }
        }

    }

        private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction()==KeyEvent.ACTION_DOWN)
        {
            switch (keyCode)
            {
                case KeyEvent.KEYCODE_BACK:
                    if(mWebView.canGoBack()&&mWebView.isFocused())
                    {
                        mWebView.goBack();
                    }
                    else
                    {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }




    private class MyChrome extends WebChromeClient {

        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        MyChrome() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mWebView.restoreState(savedInstanceState);
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

}

class CheckNetwork {

    private static final String TAG = CheckNetwork.class.getSimpleName();

    public static boolean isInternetAvailable(Context context) {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null) {
            Log.d(TAG, "no internet connection");
            return false;
        } else {
            if (info.isConnected()) {
                Log.d(TAG, " internet connection available...");
                return true;
            } else {
                Log.d(TAG, " internet connection");
                return true;
            }

        }
    }
}
