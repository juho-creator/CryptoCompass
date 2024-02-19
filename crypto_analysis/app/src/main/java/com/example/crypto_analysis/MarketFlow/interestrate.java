package com.example.crypto_analysis.MarketFlow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.crypto_analysis.BaseActivity;
import com.example.crypto_analysis.R;

public class interestrate extends BaseActivity {
    protected void setTitleAndContent(String title, String htmlContent1, String htmlContent2) {
        // Set title
        TextView tv = findViewById(R.id.tv);
        tv.setText(title);

        // Enable TextView
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);

        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);


        // Set WebView HTML content
        WebView myWebView1 = findViewById(R.id.display);
        myWebView1.loadDataWithBaseURL(null, htmlContent1, "text/html", "UTF-8", null);


        // Set WebView HTML content
        WebView myWebView2 = findViewById(R.id.display2);
        myWebView2.setVisibility(View.VISIBLE);
        myWebView2.loadDataWithBaseURL(null, htmlContent2, "text/html", "UTF-8", null);


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String htmlContent1 ="<iframe frameborder=\"0\" scrolling=\"no\" height=82 width=\"231\" allowtransparency=\"true\" marginwidth=\"0\" marginheight=\"0\" src=\"https://sslirates.investing.com/index.php?rows=2&bg1=FFFFFF&bg2=F1F5F8&text_color=333333&enable_border=show&border_color=0452A1&header_bg=0452A1&header_text=FFFFFF&force_lang=1\" align=\"center\"></iframe><br /><table width=\"200\"><tbody><tr><td style=\"text-align:left\"><a href=\"https://www.investing.com\" rel=\"nofollow\" target=\"_blank\"><img style=\"vertical-align:middle;\" title=\"Investing.com\" alt=\"Investing.com\" border=\"0\" src=\"https://92f8049275b46d631f32-c598b43a8fdedd4f0b9230706bd7ad18.ssl.cf1.rackcdn.com/forexpros_en_logo.png\"></a></td></tr><tr><td><span style=\"font-size: 11px;color: #333333;text-decoration: none;\">Interest Rates powered by <a href=\"//www.investing.com/\" rel=\"nofollow\" target=\"_blank\" style=\"font-size: 11px;color: #06529D; font-weight: bold;\" class=\"underline_link\">Investing.com</a>.</span></td></tr></tbody></table>";
        String htmlContent2 = "<iframe src=\"https://www.widgets.investing.com/live-currency-cross-rates?theme=lightTheme&hideTitle=true&pairs=9511,158,159,650\" width=\"100%\" height=\"100%\" frameborder=\"0\" allowtransparency=\"true\" marginwidth=\"0\" marginheight=\"0\"></iframe><div class=\"poweredBy\" style=\"font-family: Arial, Helvetica, sans-serif;\">Powered by <a href=\"https://www.investing.com?utm_source=WMT&amp;utm_medium=referral&amp;utm_campaign=LIVE_CURRENCY_X_RATES&amp;utm_content=Footer%20Link\" target=\"_blank\" rel=\"nofollow\">Investing.com</a></div>";


        super.onCreate(savedInstanceState);
        setTitleAndContent("글로벌 경제",htmlContent2,htmlContent1);
        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cryptovolume.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }
}
