package com.asevensoft.a7002;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StartGame extends Activity{
    int limitConfig = 52;
    int counterConfig = 1;
    Boolean isDebug = false;
    int counter = counterConfig - 1, counter_show = counterConfig, limit = limitConfig - 1, limit_show = limitConfig, firstClick = 0, count_king = 0;
    ImageView cardImages;
    TextView titleNo, titleNo2;
    ProgressBar spinner;

    Integer images[] = {
            R.drawable.ace_of_clubs, R.drawable.ace_of_diamonds, R.drawable.ace_of_hearts, R.drawable.ace_of_spades,
            R.drawable.two_of_clubs, R.drawable.two_of_diamonds, R.drawable.two_of_hearts, R.drawable.two_of_spades,
            R.drawable.three_of_clubs, R.drawable.three_of_diamonds, R.drawable.three_of_hearts, R.drawable.three_of_spades,
            R.drawable.four_of_clubs, R.drawable.four_of_diamonds, R.drawable.four_of_hearts, R.drawable.four_of_spades,
            R.drawable.five_of_clubs, R.drawable.five_of_diamonds, R.drawable.five_of_hearts, R.drawable.five_of_spades,
            R.drawable.six_of_clubs, R.drawable.six_of_diamonds, R.drawable.six_of_hearts, R.drawable.six_of_spades,
            R.drawable.seven_of_clubs, R.drawable.seven_of_diamonds, R.drawable.seven_of_hearts, R.drawable.seven_of_spades,
            R.drawable.eight_of_clubs, R.drawable.eight_of_diamonds, R.drawable.eight_of_hearts, R.drawable.eight_of_spades,
            R.drawable.nine_of_clubs, R.drawable.nine_of_diamonds, R.drawable.nine_of_hearts, R.drawable.nine_of_spades,
            R.drawable.ten_of_clubs, R.drawable.ten_of_diamonds, R.drawable.ten_of_hearts, R.drawable.ten_of_spades,
            R.drawable.jack_of_clubs2, R.drawable.jack_of_diamonds2, R.drawable.jack_of_hearts2, R.drawable.jack_of_spades2,
            R.drawable.queen_of_clubs2, R.drawable.queen_of_diamonds2, R.drawable.queen_of_hearts2, R.drawable.queen_of_spades2,
            R.drawable.king_of_clubs2, R.drawable.king_of_diamonds2, R.drawable.king_of_hearts2, R.drawable.king_of_spades2,
    };
    Integer number[] ={
            0, 1, 2, 3,
            4, 5, 6, 7,
            8, 9, 10, 11,
            12, 13, 14, 15,
            16, 17, 18, 19,
            20, 21, 22, 23,
            24, 25, 26, 27,
            28, 29, 30, 31,
            32, 33, 34, 35,
            36, 37, 38, 39,
            40, 41, 42, 43,
            44, 45, 46, 47,
            48, 49, 50, 51
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game2);

        cardImages = (ImageView) findViewById(R.id.card_images);
        titleNo = (TextView) findViewById(R.id.title_no);
        titleNo2 = (TextView) findViewById(R.id.title_no_2);

        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);

        if(!isDebug){

            List<Integer> arr = Arrays.asList(number);
            Collections.shuffle(arr);

        }

        Integer imageNum = R.drawable.black_joker;
        cardImages.setImageResource(imageNum);

        titleNo2.setRotation(180);

        cardImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                cardImages.setEnabled(false);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        spinner.setVisibility(View.GONE);

                        if (firstClick == 0) {
                            if (number[counter] == 48 || number[counter] == 49 || number[counter] == 50 || number[counter] == 51)
                                count_king++;

                            FormatMessage total = new FormatMessage(getString(R.string.textTotal), counter_show, limit_show);
                            FormatMessage king = new FormatMessage(getString(R.string.textKing), count_king, 4);
                            titleNo.setText(total.getTitle() + " " + king.getTitle());
                            titleNo2.setText(total.getTitle() + " " + king.getTitle());
                            titleNo2.setRotation(180);

                            Integer imageNum = images[number[counter]];
                            cardImages.setImageResource(imageNum);

                            firstClick = 1;
                            cardImages.setEnabled(true);

                        } else {
                            if (counter < limitConfig) {
                                counter++;
                                counter_show++;
                                if (number[counter] == 48 || number[counter] == 49 || number[counter] == 50 || number[counter] == 51)
                                    count_king++;
                            }


                            FormatMessage total = new FormatMessage(getString(R.string.textTotal), counter_show, limit_show);
                            FormatMessage king = new FormatMessage(getString(R.string.textKing), count_king, 4);
                            titleNo.setText(total.getTitle() + " " + king.getTitle());
                            titleNo2.setText(total.getTitle() + " " + king.getTitle());
                            titleNo2.setRotation(180);

                            final Integer[] imageNum = {images[number[counter]]};
                            cardImages.setImageResource(imageNum[0]);

                            if (counter == 51) {

                                Toast.makeText(getApplicationContext(), getString(R.string.textGameOver),
                                        Toast.LENGTH_LONG).show();

                                cardImages.setEnabled(true);

                                cardImages.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Integer imageNum = R.drawable.black_joker;
                                        cardImages.setImageResource(imageNum);

                                        spinner.setVisibility(View.VISIBLE);
                                        cardImages.setEnabled(true);

                                        new Handler().postDelayed(new Runnable() {
                                            public void run() {

                                                Intent intentReturn = new Intent(StartGame.this, MainActivity.class);
                                                startActivity(intentReturn);

                                            }
                                        }, 5000);

                                    }
                                });
                            } else {
                                cardImages.setEnabled(true);
                            }
                        }

//                Toast.makeText(getApplicationContext(), rules[number[counter]],
//                Toast.LENGTH_LONG).show();
                    }

                }, 2000);
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getString(R.string.dialogTitle))
                .setMessage(getString(R.string.dialogMessage))
                .setPositiveButton(getString(R.string.dialogYesButton), new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton(getString(R.string.dialogNoButton), null)
                .show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus){
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
               |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
               |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
               |View.SYSTEM_UI_FLAG_FULLSCREEN
               |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
               |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }
}
