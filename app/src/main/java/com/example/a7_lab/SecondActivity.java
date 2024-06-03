package com.example.a7_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private Button circle, triangle, clear;
    private CheckBox fillFlag, rotCheck;
    private DrawView2 drawView2;
    private EditText rotDegree;
    private int currentFigure = 0;
    private int currentDegree = 0;
    private boolean fillFl = false;
    private boolean rotFl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        circle = (Button) findViewById(R.id.btnCircle);
        triangle = (Button) findViewById(R.id.btnTriangle);
        clear = (Button) findViewById(R.id.btnClear);
        fillFlag = (CheckBox) findViewById(R.id.fillCheck);
        drawView2 = (DrawView2) findViewById(R.id.drawView);
        rotCheck = (CheckBox) findViewById(R.id.rotCheck);
        rotDegree = (EditText) findViewById(R.id.rotDegree);

        circle.setOnClickListener(circleOnClick);
        triangle.setOnClickListener(triangleOnClick);
        clear.setOnClickListener(clearOnClick);

        fillFlag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                fillFl = isChecked;
            }
        });

         rotCheck.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 rotFl = isChecked;
                 drawView2.setRotFlag(rotFl);
                 String degreeText = rotDegree.getText().toString();
                 if (rotFl) {
                     if (!degreeText.isEmpty()){
                         int degree = Integer.parseInt(rotDegree.getText().toString());
                         drawView2.setDegree(degree);
                     } else{
                         int degree = 0;
                         drawView2.setDegree(degree);
                     }
                 } else {
                     drawView2.setDegree(0);
                 }
                 drawView2.invalidate(); // Redraw the view
             }
         }));

    }

    public void setFigure(final int figure, final boolean fillFlag) {
        runOnUiThread((new Runnable() {
            @Override
            public void run() {
                drawView2.setFigure(figure);
                drawView2.setFillFlag(fillFlag);
                drawView2.invalidate();
            }
        }));
    }

        View.OnClickListener circleOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFigure(1, fillFl);
                currentFigure = 1;
            }
        };

        View.OnClickListener triangleOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFigure(2, fillFl);
                currentFigure = 2;
            }
        };

        View.OnClickListener clearOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFigure(0, fillFl);
                currentFigure = 0;
            }
        };


}