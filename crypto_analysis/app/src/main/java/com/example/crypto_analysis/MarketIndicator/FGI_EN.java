// FGI_EN.java
package com.example.crypto_analysis.MarketIndicator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crypto_analysis.MainActivity;
import com.example.crypto_analysis.R;
import com.squareup.picasso.Picasso;

public class FGI_EN extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextprev);

        // Change title
        TextView tv = findViewById(R.id.tv);
        tv.setText("공포탐욕지수 (외국)");

        // Display ImageView
        ImageView imageView = findViewById(R.id.imageview);
        imageView.setVisibility(View.VISIBLE); // Use View.VISIBLE to set visibility
        String imageUrl = "https://alternative.me/crypto/fear-and-greed-index.png";
        Picasso.get().load(imageUrl).into(imageView);

        // Prev Button
        Button prevBtn = findViewById(R.id.prevBtn);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        // Next Button
        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FGI_KR.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });

        //  Home button to go to MainActivity
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
