package edu.mum.lesson7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import edu.mum.R;

public class LoginActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        webView = findViewById(R.id.wv);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/login.html");
        webView.addJavascriptInterface(this, "loginActivity");
    }

    @JavascriptInterface
    public void login(String name, String pass){
        Log.d("debug","test111111111");
        if(!name.equals("123")||!pass.equals("123")){
            Toast.makeText(this,"error", Toast.LENGTH_SHORT).show();
            return;
        }
        gotoWebActivity();
    }

    private void gotoWebActivity(){
        Intent intent = new Intent(this,WebBrowseActivity.class);
        startActivity(intent);
        finish();
    }



}
