package com.example.a7_lab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Random;

public class DrawView2 extends View {

    public static final int CIRCLE = 1;
    public static final int NONE = 0;
    public static final int TRIANGLE = 2;

    public boolean fillFlag = false;
    public boolean rotFlag = false;
    private int figure;
    private int degree;

    public DrawView2(Context context) {
        super(context);
    }
    public DrawView2(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public DrawView2(Context context, AttributeSet attributeSet, int defStyleAttr){
        super(context, attributeSet, defStyleAttr);
    }

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public boolean isFillFlag() {
        return fillFlag;
    }

    public boolean isRotFlag(){
        return rotFlag;
    }

    public void setFillFlag(boolean fillFlag) {
        this.fillFlag = fillFlag;
    }

    public void setRotFlag(boolean rotFlag) {
        this.rotFlag = rotFlag;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        int height = getHeight();
        int width = getWidth();

        Paint paint;
        canvas.save();

        if (rotFlag) {
            canvas.rotate(degree, width / 2, height / 2);
        }
        switch (figure){
            case CIRCLE:
                paint = new Paint();
                Random rand = new Random();
                paint.setColor(Color.argb(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));

                if (fillFlag)
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                else paint.setStyle(Paint.Style.STROKE);

                paint.setStrokeWidth(10f);
                canvas.drawCircle(width/2, height/2, width/2, paint);
                break;

            case TRIANGLE:
                paint = new Paint();
                paint.setColor(Color.GREEN);

                if (fillFlag)
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                else paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10f);

                Point point1 = new Point(width/2, 0);
                Point point2 = new Point(0, height);
                Point point3 = new Point(width, height);

                Path path = new Path();
                path.moveTo(point1.x, point1.y);
                path.lineTo(point2.x, point2.y);
                path.lineTo(point3.x, point3.y);
                path.lineTo(point1.x, point1.y);
                path.close();

                canvas.drawPath(path, paint);
                break;

            case NONE:
                break;

            default:break;
        }
        canvas.restore();
    }

}
