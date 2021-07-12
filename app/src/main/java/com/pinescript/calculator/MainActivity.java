package com.pinescript.calculator;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String oldnumber="";
    String operator="";
    Boolean isNewOperator=true;
    TextView resultTextView;
    Boolean minusOff= true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView= findViewById(R.id.resultTextView);
    }

    public void numberEvent(View view){
        if (isNewOperator==true){
            resultTextView.setText("");
        }
        isNewOperator=false;
        String number= resultTextView.getText().toString();
        if (view.getId()== R.id.b1){
            number=number+"1";
        }
        else if (view.getId()== R.id.b2){
            number=number+"2";
        }
        else if (view.getId()== R.id.b3){
            number=number+"3";
        }
        else if (view.getId()== R.id.b4){
            number=number+"4";
        }
        else if (view.getId()== R.id.b5){
            number=number+"5";
        }
        else if (view.getId()== R.id.b6){
            number=number+"6";
        }
        else if (view.getId()== R.id.b7){
            number=number+"7";
        }
        else if (view.getId()== R.id.b8){
            number=number+"8";
        }
        else if (view.getId()== R.id.b9){
            number=number+"9";
        }
        else if (view.getId()== R.id.nul){
            number=number+"0";
        }
        else if (view.getId()== R.id.dot){
            number=number+".";
        }
        else if (view.getId()== R.id.plusminus){
            if (minusOff){                       //страховка от двойного минуса//
                number="-"+number;
                minusOff=false;
            }
            else {
                number=number.replace("-", "");
                minusOff=true;
            }

        }
        resultTextView.setText(number);

    }

    public void operEvent(View view) {
        isNewOperator=true;
        oldnumber=resultTextView.getText().toString();
        if (view.getId()==R.id.decriment){
            operator="-";
        }
        else if (view.getId()==R.id.incriment){
            operator="+";
        }
        else if (view.getId()==R.id.multiple){
            operator="*";
        }
        else if (view.getId()==R.id.devide){
            operator="/";
        }
    }

    public void equalEveht(View view) {
        String newNumber=resultTextView.getText().toString();
        double result= 0.0;
        if (operator=="+"){
            result=Double.parseDouble(oldnumber)+Double.parseDouble(newNumber);
        }
        else if (operator=="-"){
            result=Double.parseDouble(oldnumber)-Double.parseDouble(newNumber);
        }
        else if (operator=="*"){
            result=Double.parseDouble(oldnumber)*Double.parseDouble(newNumber);
        }
        else if (operator=="/"){
            result=Double.parseDouble(oldnumber)/Double.parseDouble(newNumber);
        }
        resultTextView.setText(result+"");
    }

    public void acEvent(View view) {
        resultTextView.setText("0");
        isNewOperator=true;
    }

    public void percentEvent(View view) {
        Double num=Double.parseDouble(resultTextView.getText().toString())/100;
        resultTextView.setText(num+"");
        isNewOperator=true;
    }
}