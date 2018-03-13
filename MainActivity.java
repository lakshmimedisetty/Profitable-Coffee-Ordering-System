package com.example.freewaresys.justjavabscs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void decrement(View view) {
        quantity=quantity-1;
        displayquantity(quantity);

    }

    private void displayquantity(int quantity) {
        EditText quantity1 = (EditText) findViewById(R.id.quantityTxt);
        quantity1.setText(""+quantity);


    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayquantity(quantity);
    }





    private void displayMessage(String finalMessage) {
        TextView Message = (TextView) findViewById(R.id.resultTxt);
        Message.setText(""+finalMessage);


    }

    private String createFinalMessage(String names, Boolean chocs, Boolean whipped,int price) {
        String Message = "Name: "+names+"\n"+"chocolate ordered :"+chocs+"\n"+"whipped ordered  :"+whipped+"\n"+" Total Price $: "+price;
        return  Message;


    }

    private int calculatePrice(Boolean chocs, Boolean whipped) {
        int price =10;
        if (chocs)
        {
            price =price+2;
        }
        if (whipped)
        {
            price=price+3;
        }
        return price*quantity;
    }


    public void orderButton(View view) {
        EditText name = (EditText) findViewById(R.id.nameTxt);

        String names = name.getText().toString();
        CheckBox choc = (CheckBox) findViewById(R.id.chocalate_checkbox);
        Boolean chocs = choc.isChecked();
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean whipped = whippedCream.isChecked();
        int price = calculatePrice(chocs,whipped);
        String finalMessage =createFinalMessage (names,chocs,whipped,price);
        displayMessage(finalMessage);
    }
}

