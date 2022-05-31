package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Rules extends View {
    String string = ".Суть игры - пройти уровень до конца и не врезавшись в препятствия " ;
            String string1 =        "Игра начинается по нажатию на экран" ;
    String string2 =        "Что бы пройти первый уровень надо набрать 25 очков" ;
            String string3 =        "Что бы пройти первый уровень надо набрать 50 очков и " +
                    "анимация персонажа быстрее" ;
    String string4 =       "Упровлять персонажем можно с помощью нажитий на экране";
    public Rules(Context context) {
        super(context);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(30);
        canvas.drawText(string,0,50,p);
        canvas.drawText(string1,0,150,p);
        canvas.drawText(string2,0,250,p);
        canvas.drawText(string3,0,350,p);
        canvas.drawText(string4,0,450,p);
    }
}