package com.example.test_application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView field;
    private double op1;
    private double op2;
    private String lastOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field = findViewById(R.id.tv_print);
    }

    public void onNumberClick(View view){
        Button button = (Button)view;
        if(button.getText().toString().equals("AC")) {
            field.setText("");
            op1 = 0;
            op2 = 0;
            lastOperation = "=";
        }
        else if(!(field.getText().toString().contains(".") & button.getText().toString().equals("."))){
            field.append(button.getText());
        }
    }

    public void onOperationClick(View view){
        Button button = (Button)view;
        String operation = (String)button.getText();

        if(lastOperation.equals("=")){
            op1 = Double.parseDouble(field.getText().toString());
            field.setText("");
        }
        else {
            op2 = Double.parseDouble(field.getText().toString());
            field.setText("");
            op1 = getResultOperation(op1, op2, lastOperation);

                if(lastOperation.equals("/") & op1 == -1) {
                    field.setText("ERROR");
                }
                else if(operation.equals("=")) {
                    field.setText(op1 + "");
                }
                else {
                    field.setText("");
                }
        }
        lastOperation = operation;
    }

    public double getResultOperation(double op1, double op2, String operation){
        switch (operation) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if (op2 != 0) {
                    return op1 / op2;
                } else {
                    return -1;
                }
            case "=":
                return op1;
        }
        return 0;
    }
}