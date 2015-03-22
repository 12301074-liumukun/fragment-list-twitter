package com.deitel.twittersearches;

import android.content.ActivityNotFoundException;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */

public class Fragment2 extends Fragment {

    private String urlString = null;
    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        WebView webview = (WebView) view.findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        try {
            webview.loadUrl(urlString);
        }catch(ActivityNotFoundException ex){
            Toast.makeText(getActivity(), "Wrong website link!", Toast.LENGTH_LONG).show();
        }
        return view;
    }

    public void setUrlString(String urlString){ this.urlString = urlString;}

}
