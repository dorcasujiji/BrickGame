package com.brickgame.valbyte96.brickgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by demouser on 1/18/17.
 */

public class ScoreBoard {

    public float leftX;
    public float leftY;
    public int score;
    public int level;
    public int lives;

    public ScoreBoard(float x, float y){
        this.leftX=x;
        this.leftY=y;
        this.score=0;
    }

    //function that updates the scoreboard and draws it
    public void draw(Canvas canvas,Paint paint,int score, int level, int lives){
        this.score=score;
        paint.setTextSize(30);
        canvas.drawText("Level: "+Integer.toString(level)+"   Score: "+Integer.toString(score)+"   lives: "+Integer.toString(lives),leftX,leftY,paint);

    }


}
