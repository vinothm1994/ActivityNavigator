package com.example.vinoth.activitynavigator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SimpleCalculator extends AppCompatActivity{
    private EditText FirstNumber;
    private EditText SecondNumber;
    private TextView resultNumber;
    public void doCalculation(View view){
        double num1=0,num2=0;
        try {
            num1 = Double.parseDouble(FirstNumber.getText().toString());
        }
        catch (Exception e){
         resultNumber.setText("enter number1");
        }
        try {
            num2=Double.parseDouble(SecondNumber.getText().toString());
        }
        catch (Exception e){
            resultNumber.setText("enter number2");
        }
        if(num1!=0&&num2!=0) {
            switch (view.getId()) {
                case R.id.btAdd:
                    resultNumber.setText("Result:" + (num1 + num2));
                    break;
                case R.id.btSub:
                    resultNumber.setText("Result:" + (num1 - num2));
                    break;
                case R.id.btMul:
                    resultNumber.setText("Result:" + (num1 * num2));
                    break;
                case R.id.btDiv:
                    resultNumber.setText("Result:" + (num1 / num2));
                    break;
                case R.id.btMode:
                    resultNumber.setText("Result:" + (num1 % num2));
                    break;
            }
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calculator_layout);
         FirstNumber =(EditText) findViewById(R.id.etFirstNumber);
         SecondNumber=(EditText)findViewById(R.id.etSecondNumber);
         resultNumber=(TextView)findViewById(R.id.tvResult);


    }

}