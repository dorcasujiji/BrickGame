package com.brickgame.valbyte96.brickgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;

/**
 * Created by demouser on 1/17/17.
 */

public class Paddle {
    //coordinates of first corner of rectangle
    private float x, y, size;
    private Vibrator v;
    private int[] colors;

    //constructor
    public Paddle(float x, float y, float size, Context context, int[] colors){
        this.x=x;
        this.y=y;
        this.size=size;
        this.v =(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        this.colors=colors;
    }

    //moves the paddle
    public void move(float x){
        this.x=x;
    }

    //accessor methods
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }

    public void draw(Canvas canvas, Paint paint){
        //design 1
        paint.setColor(colors[0]);
        canvas.drawRect(x,y,x+size,y+size,paint);
        paint.setColor(colors[3]);
        canvas.drawRect(x+size,y,x+(size*2),y+size,paint);
        paint.setColor(colors[1]);
        canvas.drawRect(x+(size*2),y,x+(size*3),y+size,paint);
        paint.setColor(colors[2]);
        canvas.drawRect(x+(size*3),y,x+(size*4),y+size,paint);

        //design 2
//        paint.setColor(colors[2]);
//        canvas.drawRect(x,y,x+100,y+6,paint);
//        paint.setColor(colors[0]);
//        canvas.drawRect(x,y+6,x+100,y+12,paint);
//        paint.setColor(colors[3]);
//        canvas.drawRect(x,y+12,x+100,y+18,paint);
//        paint.setColor(colors[1]);
//        canvas.drawRect(x,y+18,x+100,y+24,paint);
    }

    public boolean reflect(float bX, float bY){

        if (bX>=x&&bX<=x+200&& bY>=y&&bY<=y+50){
           // v.vibrate(100);
            return true;
        }
        return false;
    }


}
