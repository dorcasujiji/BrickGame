package com.brickgame.valbyte96.brickgame;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by demouser on 1/17/17.
 */

public class BrickView extends View {


    private Paint bgPaint;
    private Paint bPaint;
    private Paddle mPaddle;
    private Ball mBall;
    private float dx;
    private float dy;


    public BrickView(Context context) {
        super(context);
        init();
    }

    public BrickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public BrickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BrickView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        bgPaint = new Paint();
        bgPaint.setColor(Color.rgb(0,0,0));
        bPaint = new Paint();
        bPaint.setColor(Color.rgb(200,0,0));
        mPaddle = new Paddle(200,650);
        mBall = new Ball(270,380);

        dx=2;
        dy=2;


        setOnTouchListener(new OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent motionEvent) {
               if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
                   return true;
               }
               if (motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {
                   Log.d("test", "x: " + motionEvent.getX() + ", y: " + motionEvent.getY());
                   mPaddle.move(motionEvent.getX());
                   return true;
               }
               return false;
           }
         }
       );
   }

    @Override
    protected void onDraw(Canvas canvas) {
        //draw circle and rectangle
        canvas.drawRect(mPaddle.getX(),mPaddle.getY(),mPaddle.getX()+100,mPaddle.getY()+50,bgPaint);
        canvas.drawCircle(mBall.getX(),mBall.getY(),15,bPaint);

        mBall.move(dx,dy);//move ball

        //conditions for reflecting
        //checks to see if it has hit the paddle
        if (mBall.getX()>=mPaddle.getX()&&mBall.getX()<=mPaddle.getX()+100&&
                mBall.getY()>=mPaddle.getY()&&mBall.getY()<=mPaddle.getY()){
            dy=-dy;
        }
        //too far left or right
        if (mBall.getX()<=0||mBall.getX()>=getWidth()){
            dx=-dx;
        }
        //too far up or down
        if (mBall.getY()<=0||mBall.getY()>=getHeight()){
            dy=-dy;
        }

        postInvalidateOnAnimation();

    }
}