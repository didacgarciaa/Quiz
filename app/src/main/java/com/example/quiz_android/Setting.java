package com.example.quiz_android;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class Setting extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ImageView backArrow = findViewById(R.id.backArrow);
        WebView settingPage = (WebView) findViewById(R.id.settingPage);
        settingPage.loadUrl("file:///android_asset/index.html");

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, Benvinguda.class);
                startActivity(intent);
            }
        });
    }

}
