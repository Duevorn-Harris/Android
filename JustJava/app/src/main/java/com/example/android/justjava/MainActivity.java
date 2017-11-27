package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {

        Context context = getApplicationContext();
        CharSequence text = "You cannot order more than 100 cups of coffee at a time.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);

        if(quantity >= 100){
            toast.show();
        } else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        Context context = getApplicationContext();
        CharSequence text = "You cannot order less than 1 cup of coffee at a time.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);

        if(quantity <= 1){
            toast.show();
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /* int price = calculatePrice();
        String priceMessage = "Total: $" + price;
        priceMessage = priceMessage +"\nThank you";
        displayMessage(priceMessage);
        */

        displayMessage(createOrderSummary(calculatePrice()));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numeral) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numeral);
    }

    /**
     * Calculates the price of the order.
     *
     * // @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice() {

       return quantity * calculatePricePerCupOfCoffee();
    }

    private String getName(){
        EditText name = (EditText) findViewById(R.id.id_for_name);

        return name.getText().toString();
    }

    private boolean whippedCreamCheckBox() {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox_id);

        return whippedCream.isChecked();


    }

    private boolean chocolateCheckBox() {
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox_id);

        return chocolate.isChecked();


    }

    private int calculatePricePerCupOfCoffee(){
        int price = 5;

        if(whippedCreamCheckBox() && chocolateCheckBox()){
            price += 3;
        } else if(chocolateCheckBox()){
            price += 2;
        } else if(whippedCreamCheckBox()){
            price += 1;
        }

        return price;
    }

    private String createOrderSummary(int priceOfOrder){
        priceOfOrder = calculatePrice();
        String name = getName();
        boolean whippedCreamCheckBoxIsChecked = whippedCreamCheckBox();
        boolean chocolateCheckBoxIsChecked = chocolateCheckBox();
        int localQuantity = quantity;
        String thanks = "Thank you!";

        return "Name: " + name + "\n" + "Add whipped cream?: " + whippedCreamCheckBoxIsChecked + "\n"
                + "Add chocolate?: " + chocolateCheckBoxIsChecked + "\n" + "Quantity: "
                + localQuantity + "\n" + "Total: $" + priceOfOrder + "\n" + thanks;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}