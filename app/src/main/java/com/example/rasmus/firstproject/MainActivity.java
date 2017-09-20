package com.example.rasmus.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final EditText urlInput = (EditText) findViewById(R.id.urlBar);
        final Button confirmBtn = (Button) findViewById(R.id.confirmButton);
        final WebView webView = (WebView) findViewById(R.id.webView);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String urlRequest = urlInput.getText().toString();
                webView.setWebViewClient(new WebViewClient());

                String urlFormated = urlFormater(urlRequest);

                webView.loadUrl(urlFormated);

            }
        });
    }

    // Creates the full url from a string like "reddit" or "google"
    public String urlFormater(String urlRequest) {

        if(!urlRequest.toLowerCase().contains("www.".toLowerCase())) {

            urlRequest = "www." + urlRequest;
        }

        if(!urlRequest.toLowerCase().contains(".com".toLowerCase())) {

            urlRequest = urlRequest + ".com";
        }

        if(!urlRequest.toLowerCase().contains("https://".toLowerCase()) && !urlRequest.toLowerCase().contains("http://".toLowerCase())){

            urlRequest = "http://" + urlRequest;
        }

        return urlRequest;
    }
}
