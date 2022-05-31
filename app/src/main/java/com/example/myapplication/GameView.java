package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class GameView extends View{
    int points = 0 ;

    private final Sprite playerBird;
    private final Sprite enemyBird;

    private int viewWidth;


    private final int timerInterval = 60;

    public GameView(Context context) {
        super(context);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        int w = b.getWidth()/6;
        int h = b.getHeight()/3;
        Rect firstFrame = new Rect(10, 0, w, h);
        playerBird = new Sprite(10, 0, 0, 0, firstFrame, b);

        b = BitmapFactory.decodeResource(getResources(), R.drawable.enemy);
        enemyBird = new Sprite(2500, 1145, -170, 0, firstFrame, b);
        Timer t = new Timer();
        t.start();
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawRGB(255, 255, 255);
        playerBird.draw(canvas);
        enemyBird.draw(canvas);
        canvas.drawLine(0,1370,1250,1370 , p);
        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText(points+"", viewWidth - 100, 70, p);
    }

    protected void update () {
        playerBird.update(timerInterval);
        enemyBird.update(timerInterval);

        if (playerBird.getY() + playerBird.getFrameHeight() > 1420) {
            playerBird.setY(1420 - playerBird.getFrameHeight());

        }

        else if (playerBird.getY() <0) {

            playerBird.setY(0);
            playerBird.setVy(-playerBird.getVy());
        }

        if (enemyBird.getX() < - enemyBird.getFrameWidth()) {
            teleportEnemy();

        }
        if (!enemyBird.intersect(playerBird)){
            points++;
        }
        if (enemyBird.intersect(playerBird)) {
            playerBird.setY(0);
            playerBird.setVy(0);
            enemyBird.setX(2500);
            enemyBird.setVx(0);
            points = 0;
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        int eventAction = event.getAction();
        if (eventAction == MotionEvent.ACTION_DOWN)  {

            if (event.getY() < playerBird.getBoundingBoxRect().top) {
                playerBird.setVy(-100);

            }
            else if (event.getY() > (playerBird.getBoundingBoxRect().bottom)) {
                playerBird.setVy(+100);
            }
        }

        return true;
    }

    private void teleportEnemy () {
        enemyBird.setX(viewWidth + Math.random() * 500);
        enemyBird.setY(1145);
    }

    class Timer extends CountDownTimer {

        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            update ();
        }

        @Override
        public void onFinish() {

        }
    }
}
