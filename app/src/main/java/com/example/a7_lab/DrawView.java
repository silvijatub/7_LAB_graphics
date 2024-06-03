package com.example.a7_lab;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.view.View;

import java.util.Random;

public class DrawView extends View {

    private static final int NONE = 0;
    private static final int TRIANGLE = 1;
    private static final int CIRCLE = 2;
    private static final int RECTANGLE = 3;
    private static final int STAR = 4;
    public boolean fillFlag = false;
    private int figure;
    private int degree;

    public DrawView(Context context){
        super(context);
    }

    public DrawView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public DrawView(Context context, AttributeSet attributeSet, int defStyleAttr){
        super(context, attributeSet, defStyleAttr);
    }

    public int getFigure(){
        return figure;
    }

    public void setFigure(int figure){

        this.figure = figure;
    }

    public boolean getFillFlag(){
        return fillFlag;
    }

    public void setFillFlag(boolean fillFlag){
        this.fillFlag = fillFlag;
    }

    public int getDegree(){
        return degree;
    }

    public void setDegree(int degree){
        this.degree = degree;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Random rand1 = new Random();
        //int width = rand1.nextInt(getWidth());
        int height = getHeight();
        int width = getWidth();
        Paint paint;
        canvas.save();
        canvas.rotate(degree, width/2, height/2);
        switch (figure){
            case TRIANGLE:{
                paint = new Paint();
                paint.setColor(Color.GREEN);

                if (fillFlag) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                else{
                    paint.setStyle(Paint.Style.STROKE);
                }

                paint.setStrokeWidth(10f);

                Point point1_draw = new Point(width/2, 0);
                Point point2_draw = new Point(0, height);
                Point point3_draw = new Point(width, height);

                Path path = new Path();
                path.moveTo(point1_draw.x, point1_draw.y);
                path.lineTo(point2_draw.x, point2_draw.y);
                path.lineTo(point3_draw.x, point3_draw.y);
                path.lineTo(point1_draw.x, point1_draw.y);
                path.close();
                canvas.drawPath(path, paint);
                break;
            }
            case CIRCLE:{
                paint = new Paint();
                paint.setColor(Color.BLUE);

                if (fillFlag) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                else{
                    paint.setStyle(Paint.Style.STROKE);
                }

                paint.setStrokeWidth(10f);
                canvas.drawCircle(width/2, height/2, width/2, paint);
                break;
            }
            case RECTANGLE:{
                paint = new Paint();
                paint.setColor(Color.MAGENTA);

                if (fillFlag) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                else{
                    paint.setStyle(Paint.Style.STROKE);
                }
                paint.setStrokeWidth(10f);
                canvas.drawRect(0, 0, width, height, paint);
                break;
            }
            case STAR:{
                paint = new Paint();
                //paint.setColor(Color.YELLOW);
                Random rand = new Random();
                paint.setARGB(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                if (fillFlag) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                else{
                    paint.setStyle(Paint.Style.STROKE);
                }

                paint.setStrokeWidth(10f);

                Point point1_draw = new Point(width/2, 0);
                Point point2_draw = new Point(0, height/(3));
                Point point3_draw = new Point(width, height/(3));
                Point point4_draw = new Point(width/5, height);
                Point point5_draw = new Point((width/5)*4, height);

                Path path = new Path();
                path.moveTo(point4_draw.x, point4_draw.y);
                path.lineTo(point1_draw.x, point1_draw.y);
                path.lineTo(point5_draw.x, point5_draw.y);
                path.lineTo(point2_draw.x, point2_draw.y);
                path.lineTo(point3_draw.x, point3_draw.y);
                path.lineTo(point4_draw.x, point4_draw.y);
                path.close();
                canvas.drawPath(path, paint);
                break;
            }
            case NONE:{break;}
            default: break;
        }
        canvas.restore();
    }
}
