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
    private Paint paint = new Paint();
    Bitmap bitmapNoodles;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw (Canvas canvas) {
        super .onDraw(canvas);
        if (noodles == null) {
            noodles = new Noodles(this);
        }

        bitmapNoodles = BitmapFactory.decodeResource(getResources(),R.drawable.noodles);
        canvas.drawBitmap(bitmapNoodles, noodles.getX(), noodles.getY(), paint);
    }


    public void moveRight() {
        if (noodles.getX() < getWidth()-250) {
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
        if (noodles.getY() < getHeight()-250) {
            noodles.setDirection(Noodles.DIERCTION_UP);
            invalidate();
        }
    }
}
