package com.wen.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    Noodles noodles;
//    private float posX,posY = 300;
    Bitmap bitmapNoodles;
    Bitmap bitmapNoodlesNG;
    private Paint paint = new Paint();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw (Canvas canvas) {
        super .onDraw(canvas);
        if (noodles == null) {
            noodles = new Noodles(this);
            bitmapNoodles = BitmapFactory.decodeResource(getResources(),R.drawable.noodles);
            bitmapNoodlesNG = BitmapFactory.decodeResource(getResources(),R.drawable.noodles_ng);
        }
        if (noodles.getDirection() == Noodles.DIERCTION_NG) {
            bitmapNoodles = bitmapNoodlesNG;
        }
        canvas.drawBitmap(bitmapNoodles, noodles.getX(), noodles.getY(), paint);
    }


    public void moveRight() {
        if (noodles.getX() < getWidth()-230) {
            noodles.setDirection(Noodles.DIERCTION_RIGHT);
            invalidate();
        }
    }

    public void moveLeft() {
        if (noodles.getX() > 50) {
            noodles.setDirection(Noodles.DIERCTION_LEFT);
            invalidate();
        }
    }

    public void moveUp() {
        if (noodles.getY() > 50) {
            noodles.setDirection(Noodles.DIERCTION_UP);
            invalidate();
        }
    }

    public void moveDown() {
        if (noodles.getY() < getHeight()-230) {
            noodles.setDirection(Noodles.DIERCTION_DOWN);
            invalidate();
        }
    }
}
