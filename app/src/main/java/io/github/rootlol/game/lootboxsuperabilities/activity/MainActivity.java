/*
 * Copyright © 2020. Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.game.lootboxsuperabilities.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

import io.github.rootlol.game.lootboxsuperabilities.R;

public class MainActivity extends AppCompatActivity {
    String[] sa = {
            "Аморфизм",
            "Живой компьютер",
            "Генерация биоауры",
            "Гипноз",
            "Гибкость",
            "Дедуктивное мышление",
            "Замедленное старение",
            "Заморозка",
            "хамло"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openBox(View view){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_main2);
        dialog.setCancelable(false);
        dialog.show();
        class MalibuCountDownTimer extends CountDownTimer {
            int colTick = 0;
        public MalibuCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }
        @Override
        public void onFinish() {
            dialog.cancel();
            final Random random = new Random();
            ((ImageView) MainActivity.this.findViewById(R.id.imageView)).setImageResource(R.drawable.o_box);
            ((TextView) MainActivity.this.findViewById(R.id.textView5)).setText("твоя супер способность '"+sa[random.nextInt(sa.length)]+"'");
        }
        @Override
        public void onTick(long millisUntilFinished) {
            switch (colTick){
                case 1:
                    ((ImageView) dialog.findViewById(R.id.imageView2)).setImageResource(android.R.drawable.checkbox_on_background);
                    break;
                case 2:
                    ((ImageView) dialog.findViewById(R.id.imageView3)).setImageResource(android.R.drawable.checkbox_on_background);
                    break;
                case 3:
                    ((ImageView) dialog.findViewById(R.id.imageView5)).setImageResource(android.R.drawable.checkbox_on_background);
                    break;
                default:
                    break;
            }
            colTick++;
        }
        }

        new MalibuCountDownTimer(10000, 2500).start();


    }


}
