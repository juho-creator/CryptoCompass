// FGI_KR.java
package com.example.crypto_analysis.MarketIndicator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crypto_analysis.BaseActivity;
import com.example.crypto_analysis.R;

public class FGI_KR extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleAndUrl("공포탐욕지수 (한국)", "https://www.ubcindex.com/feargreed");

        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BullBear.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });


    }


}
