package com.brickgame.valbyte96.brickgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by demouser on 1/18/17.
 */

public class Brick {
    private float x, y, size;
    private int color;
    private boolean drawn;


    public Brick(float x, float y, int size, int color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.drawn=true;
        this.size = size;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public int getColor(){
        return this.color;
    }

    public boolean isTouched(float bX, float bY){
        if (this.drawn==false){
            return false;
        }
        if (bX>=x&&bX<=x+size&& bY>=y&&bY<=y+size){
            this.drawn=false;
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas, Paint paint){
        if(drawn) {
            canvas.drawRect(x, y, x + size, y + size, paint);
        }
    }
    public void resetDraw(){
        this.drawn=true;
    }
}
