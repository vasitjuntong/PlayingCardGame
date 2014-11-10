package com.asevensoft.a7002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void onClickStartButton(View view) {

        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);

    }

    public void onClickHowToButton(View view) {

        Intent intent = new Intent(this, HowTo.class);
        startActivity(intent);
    }

    public void onClickAboutUsButton(View view) {

        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);

    }
}
