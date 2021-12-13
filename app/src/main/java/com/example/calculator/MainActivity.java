package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldString = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftString = oldString.substring(0,cursorPos);
        String rightString = oldString.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }else{
            display.setText(String.format("%s%s%s",leftString,strToAdd,rightString));
        }
        display.setSelection(cursorPos+1);
    }

    public void zerobtn(View view){
        updateText("0");
    }
    public void onebtn(View view){
        updateText("1");
    }
    public void twobtn(View view){
        updateText("2");
    }
    public void threebtn(View view){
        updateText("3");
    }
    public void fourbtn(View view){
        updateText("4");
    }
    public void fivebtn(View view){
        updateText("5");
    }
    public void sixbtn(View view){
        updateText("6");
    }
    public void sevenbtn(View view){
        updateText("7");
    }
    public void eightbtn(View view){
        updateText("8");
    }
    public void ninebtn(View view){
        updateText("9");
    }
    public void clearbtn(View view){
        display.setText("");
    }
    public void parenthesesbtn(View view){
        updateText("()");
    }
    public void exponenttbn(View view){
        updateText("^");
    }
    public void dividebtn(View view){
        updateText("/");
    }
    public void multiplybtn(View view){
        updateText("x");
    }
    public void subtractbtn(View view){
        updateText("-");
    }
    public void addbtn(View view){
        updateText("+");
    }
    public void equalsbtn(View view){
        updateText("=");
    }
    public void pointbtn(View view){
        updateText(".");
    }
    public void plusMinusbtn(View view){
        updateText("+/-");
    }
    public void backspacebtn(View view){
        int cursorPos = display.getSelectionStart();
        int lenText = display.getText().length();

        if (cursorPos !=0 && lenText !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
}