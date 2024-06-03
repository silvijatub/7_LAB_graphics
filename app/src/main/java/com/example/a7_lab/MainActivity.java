package com.example.a7_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private DrawView drawView;
    private Button btnTriangle, btnRec, btnCircle, btnClear, btnRotate, btnCustom;
    private CheckBox fillFlagCh;
    private boolean fillFlag = false;
    private EditText rotateDegree;

    private int currentFigure = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView = (DrawView) findViewById(R.id.draw_view);
        btnCircle = (Button) findViewById(R.id.btnCircle);
        btnRec = (Button) findViewById(R.id.btnRec);
        btnTriangle = (Button) findViewById(R.id.btnTriangle);
        btnClear = (Button) findViewById(R.id.btnClear);
        fillFlagCh = (CheckBox) findViewById(R.id.chFill);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        rotateDegree = (EditText) findViewById(R.id.rotateDegree);
        btnCustom = (Button) findViewById(R.id.btnCustomFigure);
        Button btnSecond = (Button) findViewById(R.id.btnSecond);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SecondActivity.class));
            }
        });

        btnCircle.setOnClickListener(circleBtnClick);
        btnClear.setOnClickListener(clearBtnClick);
        btnTriangle.setOnClickListener(triangleBtnClick);
        btnRec.setOnClickListener(rectangleBtnClick);
        fillFlagCh.setOnCheckedChangeListener(fillFlagCBChange);
        btnRotate.setOnClickListener(rotateBtnClick);
        btnCustom.setOnClickListener(starBtnClick);
    }

    public void setFigure (final int figure, final boolean fillFlag){
        runOnUiThread((new Runnable() {
            @Override
            public void run() {
                drawView.setFigure(figure);
                drawView.setFillFlag(fillFlag);
                drawView.invalidate();
            }
        }));
    }

    CompoundButton.OnCheckedChangeListener fillFlagCBChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            fillFlag = isChecked;
            }
        };

    View.OnClickListener triangleBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFigure(1, fillFlag);
            currentFigure = 1;
        }
    };

    View.OnClickListener circleBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFigure(2, fillFlag);
            currentFigure = 2;
        }
    };

    View.OnClickListener rectangleBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFigure(3, fillFlag);
            currentFigure = 3;
        }
    };

    View.OnClickListener starBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFigure(4, fillFlag);
            currentFigure = 4;
        }
    };

    View.OnClickListener clearBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFigure(0, fillFlag);
            currentFigure = 0;
        }
    };

    View.OnClickListener rotateBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String degreeText = rotateDegree.getText().toString();
            if(!degreeText.isEmpty()){
                int degree = Integer.parseInt(degreeText);
                setFigure(currentFigure, fillFlag);
                drawView.setDegree(degree);
            }
        }
    };
}