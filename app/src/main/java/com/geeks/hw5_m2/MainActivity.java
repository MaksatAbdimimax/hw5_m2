package com.geeks.hw5_m2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstValue, secondValue;
    private boolean isOperationClick;
    private String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {

        String text = ((MaterialButton)view).getText().toString();
        if (text.equals("AC")){
            textView.setText("0");
            firstValue =0;
            secondValue = 0;
        } else if (textView.getText().toString().equals("0")|| isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick =false;
    }

    public void onOperationClick(View view) {
        if (view.getId()==R.id.btn_plus){
            firstValue = Integer.valueOf(textView.getText().toString());
            operation = "+";
        }else if (view.getId() == R.id.btn_min) {
            firstValue = Integer.valueOf(textView.getText().toString());
            operation = "-";

        } else if (view.getId() == R.id.btn_umn) {
            firstValue = Integer.valueOf(textView.getText().toString());
            operation = "*";

        } else if (view.getId() == R.id.btn_del) {
            firstValue = Integer.valueOf(textView.getText().toString());
            operation = "/";  

        } else if (view.getId()==R.id.btn_equal) {
            secondValue = Integer.valueOf(textView.getText().toString());

            Integer result;
            if (operation.equals("+")) {
                result = firstValue + secondValue;
            } else if (operation.equals("-")) {
                result = firstValue - secondValue;
            } else if (operation.equals("*")) {
                result = firstValue * secondValue;
            }else {
                result = firstValue / secondValue;
            }
            textView.setText(result.toString());
        }
        isOperationClick = true;
    }

    /*public void onOperationClickMin(View view) {
        if (view.getId()==R.id.btn_min){
            firstValue = Integer.valueOf(textView.getText().toString());

        } else if (view.getId()==R.id.btn_equal) {
            secondValue = Integer.valueOf(textView.getText().toString());

            Integer result2 = firstValue - secondValue;
            textView.setText(result2.toString());
        }
        isOperationClick = true;
    }


    public void onOperationClickUmn(View view) {
        if (view.getId()==R.id.btn_umn){
            firstValue = Integer.valueOf(textView.getText().toString());

        } else if (view.getId()==R.id.btn_equal) {
            secondValue = Integer.valueOf(textView.getText().toString());

            Integer result3 = firstValue * secondValue;
            textView.setText(result3.toString());
        }
        isOperationClick = true;
    }*/
}