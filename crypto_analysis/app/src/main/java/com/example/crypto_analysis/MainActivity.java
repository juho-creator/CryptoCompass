    package com.example.crypto_analysis;

    import android.app.Activity;
    import android.app.AlertDialog;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.ContextMenu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.webkit.WebSettings;
    import android.webkit.WebView;
    import android.widget.Button;
    import android.widget.Toast;

    import com.example.crypto_analysis.BlockchainInfo.chainSignal;
    import com.example.crypto_analysis.MarketFlow.cryptovolume;
    import com.example.crypto_analysis.MarketIndicator.FGI_EN;
    import com.example.crypto_analysis.news.cryptoworld;


    public class MainActivity extends Activity {
        Button menuBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            menuBtn = (Button) findViewById(R.id.menuBtn);
            registerForContextMenu(menuBtn);

            Button marketSentiment = findViewById(R.id.marketSentiment);
            Button marketInfo = findViewById(R.id.marketInfo);
            Button marketFlow = findViewById(R.id.marketFlow);
            Button cryptoNews = findViewById(R.id.cryptoNews);

            marketSentiment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), FGI_EN.class);
                    startActivity(intent);
                }
            });
            marketInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), chainSignal.class);
                    startActivity(intent);
                }
            });
            marketFlow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), cryptovolume.class);
                    startActivity(intent);
                }
            });
            cryptoNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), cryptoworld.class);
                    startActivity(intent);
                }
            });

            WebView myWebView = findViewById(R.id.display);
//            myWebView.loadUrl("https://cryptobubbles.net/");
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setLoadsImagesAutomatically(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            webSettings.setEnableSmoothTransition(true);
            String iframeCode = "<iframe src=\"https://coin360.com/widget/top-10?utm_source=embed_map\" frameborder=\"0\" title=\"Coin360.com: Top 10 Coins\" width=\"380\" height=\"300\"></iframe>";
            myWebView.loadData(iframeCode, "text/html", "utf-8");
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater mInflater = getMenuInflater();
            if (v == menuBtn) {
                menu.setHeaderTitle("추가 메뉴");
                mInflater.inflate(R.menu.menu1, menu);
            }
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            int itemId = item.getItemId();
            if (itemId == R.id.item1) {
                Intent intent = new Intent(getApplicationContext(), diary.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.item2) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("앱 관련 문의");
                dlg.setMessage("개발자 이메일 : kjuho2021@gmail.com");
                dlg.setPositiveButton("확인",null);
                dlg.show();
                return true;
            } else if (itemId == R.id.item3) {
                Intent intent = new Intent(getApplicationContext(), calculator.class);
                startActivity(intent);
                return true;
            }
            return super.onContextItemSelected(item);
        }

    }
