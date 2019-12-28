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