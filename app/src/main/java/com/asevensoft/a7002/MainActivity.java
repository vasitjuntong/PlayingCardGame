package com.asevensoft.a7002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
