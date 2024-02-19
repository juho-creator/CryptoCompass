// BaseActivity.java
package com.example.crypto_analysis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crypto_analysis.MainActivity;
import com.example.crypto_analysis.R;

public class BaseActivity extends AppCompatActivity {
    protected void setTitleAndUrl(String title, String url) {
        // Set title
        TextView tv = findViewById(R.id.tv);
        tv.setText(title);

        // Set WebView URL
        WebView myWebView = findViewById(R.id.display);
        myWebView.loadUrl(url);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextprev);

        // Change title
        TextView tv = findViewById(R.id.tv);

        // Display webpage
        WebView myWebView = findViewById(R.id.display);
        myWebView.setVisibility(View.VISIBLE); // Use View.VISIBLE to set visibility
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setEnableSmoothTransition(true);

        // Previous Button
        Button prevBtn = findViewById(R.id.prevBtn);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });


        Button homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
