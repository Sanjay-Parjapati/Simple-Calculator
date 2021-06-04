package com.parjapatsanjay1999.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_input1,tv_input2,tv_operator,tv_result;
    Button cancelButton,removeButton,powerButton,modButton,divideButton,multiplyButton,subtractButton,addButton,equalButton,dotButton,num0Button,num1Button,num2Button,num3Button,num4Button,num5Button,num6Button,num7Button,num8Button,num9Button;
    int operator,inputSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseAll();

        tv_input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tv_input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        TextView inputTextView;
        if(inputSelector == 1)
            inputTextView = tv_input1;
        else
            inputTextView = tv_input2;

        String previousInput = inputTextView.getText().toString();
        int id  = v.getId();


//        String toastMsg = "sanjay";
//        String logString = v.getResources().getResourceName(id);
//        Log.d(logString,toastMsg);

        switch (id)
        {
            // manipulating inputs
            case R.id.num0Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "0";
                    inputTextView.setText(previousInput);
                }
                break;
            }
            case R.id.num1Button:
            {
                if(!previousInput.equals("0")) {
                    previousInput += "1";
                }
                else
                {
                    previousInput = "1";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num2Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "2";
                }
                else
                {
                    previousInput = "2";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num3Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "3";
                }
                else
                {
                    previousInput = "3";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num4Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "4";
                }
                else
                {
                    previousInput = "4";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num5Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "5";
                }
                else
                {
                    previousInput = "5";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num6Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "6";
                }
                else
                {
                    previousInput = "6";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num7Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "7";
                }
                else
                {
                    previousInput = "7";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num8Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "8";
                }
                else
                {
                    previousInput = "8";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.num9Button:
            {
                if(!previousInput.equals("0"))
                {
                    previousInput += "9";
                }
                else
                {
                    previousInput = "9";
                }
                inputTextView.setText(previousInput);
                break;
            }
            case R.id.dotButton:
            {
                if(!previousInput.contains("."))
                {
                    previousInput += ".";
                    inputTextView.setText(previousInput);
                }
                else
                {
                    String msg = "Can enter only floating point numbers";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(),msg,duration);
                    toast.show();
                }
                break;
            }
            case R.id.cancelButton:
            {
                tv_input1.setText(R.string.empty_string);
                tv_input2.setText(R.string.empty_string);
                tv_result.setText(R.string.empty_string);
                tv_operator.setText(R.string.empty_string);
                inputSelector =1;
                operator = 0;
                break;
            }
            case R.id.removeButton:
            {
                if(previousInput.length() >1)
                {
                    previousInput = previousInput.substring(0, previousInput.length() - 1);
                }
                else if(previousInput.length() ==1)
                {
                    previousInput = "0";
                }
                inputTextView.setText(previousInput);
                break;
            }
            // operational inputs
            case R.id.modButton:
            {
                tv_operator.setText(R.string.mod);
                inputSelector =2;
                operator = 5;
                break;
            }
            case R.id.divideButton:
            {
                tv_operator.setText(R.string.divide);
                inputSelector =2;
                operator = 4;
                break;
            }
            case R.id.multiplyButton:
            {
                tv_operator.setText(R.string.multiply);
                inputSelector =2;
                operator = 3;
                break;
            }
            case R.id.subtractButton:
            {
                tv_operator.setText(R.string.subtract);
                inputSelector =2;
                operator = 2;
                break;
            }
            case R.id.addButton:
            {
                tv_operator.setText(R.string.add);
                inputSelector =2;
                operator = 1;
                break;
            }
            case R.id.powerButton:
            {
                tv_operator.setText(R.string.power);
                inputSelector =2;
                operator = 6;
                break;
            }
            case R.id.equaButton:
            {
                calculate(true);
                tv_input1.setTextSize(22);
                tv_input2.setTextSize(22);
                tv_result.setTextSize(35);
                tv_result.setTextColor(getResources().getColor(R.color.tv_result));
                break;
            }
        }
    }

    private void calculate(boolean isEqualButtonClicked)
    {
        String num1str = tv_input1.getText().toString(), num2str = tv_input2.getText().toString();
        if(!num1str.isEmpty() && !num2str.isEmpty())
        {
            tv_result.setTextSize(29);
            tv_result.setTextColor(getResources().getColor(R.color.tv_result_default));
            BigDecimal num1 = new BigDecimal(num1str), num2 = new BigDecimal(num2str);
            switch (operator)
            {
                case 1:
                    tv_result.setText(num1.add(num2) + "");
                    break;
                case 2:
                    tv_result.setText(num1.subtract(num2) + "");
                    break;
                case 3:
                    tv_result.setText(num1.multiply(num2) + "");
                    break;
                case 4:
                    try {
                        tv_result.setText(Double.parseDouble(num1+"") / Double.parseDouble(num2 + "") + "");
                    }
                    catch (Exception e) {
                        String msg = getResources().getString(R.string.divide_by_zero);
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                        toast.show();
                    }
                    break;
                case 5:
                    try {
                        tv_result.setText(num1.remainder(num2) + "");
                    }
                    catch (Exception e) {
                        if(isEqualButtonClicked)
                        {
                            String msg = getResources().getString(R.string.divide_by_zero);
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                            toast.show();
                        }
                    }
                    break;
                case 6:
                {
                    tv_result.setText(Math.pow(Double.parseDouble(num1+"") , Double.parseDouble(num2 + "")) + "");
                    break;
                }
            }
        }
        else
        {
            if(isEqualButtonClicked)
            {
                String msg = getResources().getString(R.string.enter_required_inputs);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
            }
        }
    }

    private void initialiseAll() {
        tv_input1 = findViewById(R.id.input1);
        tv_input2 = findViewById(R.id.input2);
        tv_operator = findViewById(R.id.inputOperator);
        tv_result = findViewById(R.id.result);

        cancelButton = findViewById(R.id.cancelButton);
        removeButton = findViewById(R.id.removeButton);
        powerButton = findViewById(R.id.powerButton);
        modButton = findViewById(R.id.modButton);
        divideButton = findViewById(R.id.divideButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        subtractButton = findViewById(R.id.subtractButton);
        addButton = findViewById(R.id.addButton);
        equalButton = findViewById(R.id.equaButton);
        dotButton = findViewById(R.id.dotButton);
        num0Button = findViewById(R.id.num0Button);
        num1Button = findViewById(R.id.num1Button);
        num2Button = findViewById(R.id.num2Button);
        num3Button = findViewById(R.id.num3Button);
        num4Button = findViewById(R.id.num4Button);
        num5Button = findViewById(R.id.num5Button);
        num6Button = findViewById(R.id.num6Button);
        num7Button = findViewById(R.id.num7Button);
        num8Button = findViewById(R.id.num8Button);
        num9Button = findViewById(R.id.num9Button);

        cancelButton.setOnClickListener(this);
        removeButton.setOnClickListener(this);
        powerButton.setOnClickListener(this);
        modButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        equalButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
        num0Button.setOnClickListener(this);
        num1Button.setOnClickListener(this);
        num2Button.setOnClickListener(this);
        num3Button.setOnClickListener(this);
        num4Button.setOnClickListener(this);
        num5Button.setOnClickListener(this);
        num6Button.setOnClickListener(this);
        num7Button.setOnClickListener(this);
        num8Button.setOnClickListener(this);
        num9Button.setOnClickListener(this);
        
        // operator 0 --- none
        // operator 1 --- add 
        // operator 2 --- subtract
        // operator 3 --- multiply
        // operator 4 --- divide
        // operator 5 --- mod
        // operator 6 --- power
        operator = 0;
        inputSelector = 1;
    }
}