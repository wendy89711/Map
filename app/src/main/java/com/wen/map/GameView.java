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
    private float posX,posY = 300;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    protected void onDraw (Canvas canvas) {
        super .onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.noodles);
        canvas.drawBitmap(bitmap,posX,posY,paint);
    }


    public void moveRight() {
        if (posX < getWidth()-250) {
            posX = posX + 50;
            invalidate();
        }
    }

    public void moveLeft() {
        if (posX > 50) {
            posX -= 50;
            invalidate();
        }
    }

    public void moveUp() {
        if (posY > 50) {
            posY -= 50;
            invalidate();
        }
    }

    public void moveDown() {
        if (posY < getHeight()-250) {
            posY = posY + 50;
            invalidate();
        }
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        if (posX > 0 && posX < getWidth()-200) {
            this.posX = posX;
        }
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        if (posY > 0 && posY < getHeight()-200) {
            this.posY = posY;
        }
    }
}
