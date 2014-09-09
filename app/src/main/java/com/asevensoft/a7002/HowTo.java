package com.asevensoft.a7002;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HowTo extends Activity {

    int counter;

    ImageView imageView;
    TextView titleTextView, descriptionTextView;
    Button previousButton, nextButton;

    String cards[] = {
            "Ace Clubs",
            "Two Clubs",
            "Three Clubs",
            "Four Clubs",
            "Five Clubs",
            "Six Clubs",
            "Seven Clubs",
            "Eight Clubs",
            "Nine Clubs",
            "Ten Clubs",
            "Jack Clubs",
            "Queen Clubs",
            "King Clubs",
    };

    Integer images[] = {
            R.drawable.ace_of_clubs,
            R.drawable.two_of_clubs,
            R.drawable.three_of_clubs,
            R.drawable.four_of_clubs,
            R.drawable.five_of_clubs,
            R.drawable.six_of_clubs,
            R.drawable.seven_of_clubs,
            R.drawable.eight_of_clubs,
            R.drawable.nine_of_clubs,
            R.drawable.ten_of_clubs,
            R.drawable.jack_of_clubs2,
            R.drawable.queen_of_clubs2,
            R.drawable.king_of_clubs2,
    };

    String rules[] = {
            "ผู้เล่นที่เปิดไพ่โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "(เริ่มนับจากคนเปิดไพ่) นับ 1 - 2 ผู้เล่นที่นับ 2 โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "(เริ่มนับจากคนเปิดไพ่) นับ 1 - 3 ผู้เล่นที่นับ 3 โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "(เริ่มนับจากคนเปิดไพ่) นับ 1 - 4 ผู้เล่นที่นับ 4 โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "(เริ่มนับจากคนเปิดไพ่) นับ 1 - 5 ผู้เล่นที่นับ 5 โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "ผู้เล่นที่เปิดไพ่ต้องตั้งคำถาม และเมื่อผู้เล่นคนใดที่ตอบ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "(เริ่มนับจากคนเปิดไพ่) ผู้เล่นทุกคนนับเลข 1 - 100 แต่ห้ามนับเลขที่หารด้วย 7 ลงตัว เมื่อผู้เล่นทำไม่ได้โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "ใช้การ์ดป้องกัน [2 นาที] สามารถหลบการทำโทษทุกชนิด (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "ผู้เล่นที่อยู่ด้านซ้าย ของผู้เปิดไพ่โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "ผู้เล่นที่อยู่ด้านขวา ของผู้เปิดไพ่โดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "ทำท่าทางตามผู้เล่นที่เปิดไพ่ให้เร็วที่สุด ผู้เล่นที่ทำตามช้าที่สุดหรือไม่ทำไม่สนใจเกมโดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "ห้ามพูดคุยหรือมีการเอยชื่อเอยถึงหยอกล้อผู้เล่นที่เปิดไพ่ได้ Queen ฝ่าฝืนโดนทำโทษ (ไพ่ทั้ง 4 สีมีความหมายเหมือนกัน)",
            "King ใบแรกที่เปิด สามารถสั่งให้ King ใบสุดท้ายทำอะไรก็ได้ อยู่ในขอบเขตที่เป็นไปได้และไม่มากจนเกินไป"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to);

        counter = 0;

        imageView = (ImageView) findViewById(R.id.card_image_view);
        titleTextView = (TextView) findViewById(R.id.title_text_view);
        descriptionTextView = (TextView) findViewById(R.id.description_text_view);
        previousButton = (Button) findViewById(R.id.previous_button);
        nextButton = (Button) findViewById(R.id.next_button);

        titleTextView.setText(cards[counter]);
        descriptionTextView.setText(rules[counter]);
        Integer imageInt = images[counter];
        imageView.setImageResource(imageInt);

    }



    public void nextButton(View view) {

        if(counter<12)
            counter++;

        titleTextView.setText(cards[counter]);
        descriptionTextView.setText(rules[counter]);
        Integer imageInt = images[counter];
        imageView.setImageResource(imageInt);

    }

    public void previousButton(View view) {

        if(counter>0)
            counter--;

        titleTextView.setText(cards[counter]);
        descriptionTextView.setText(rules[counter]);
        Integer imageInt = images[counter];
        imageView.setImageResource(imageInt);
    }
}
