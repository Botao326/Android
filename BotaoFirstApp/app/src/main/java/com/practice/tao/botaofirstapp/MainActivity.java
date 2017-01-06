package com.practice.tao.botaofirstapp;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Example of a call to a native method

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public void submitOrder(View view) {
        String message = "Free";

        CheckBox whippedCream = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCream.isChecked();
        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();
        Log.v("MainActivity", "has whipped cream: "+ hasWhippedCream + "\nhas chocolate: " + hasChocolate);

        EditText textName = (EditText) findViewById(R.id.name_field);
        String userName = textName.getText().toString();
        String orderMessage = createOrderSummary(userName, calculateTotalPrice(hasWhippedCream, hasChocolate, quantity),
                hasWhippedCream, hasChocolate);
        displayMessage(orderMessage);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Order for: " + userName);
        intent.putExtra(Intent.EXTRA_TEXT, orderMessage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    public void increment(View view) {
        if (quantity < 100)
           quantity += 1;
        displayQuantity(quantity);
        displayPrice(calculatePrice(quantity));
    }

    public void decrement(View view){
        if (quantity > 0)
            quantity -= 1;
        displayQuantity(quantity);
        displayPrice(calculatePrice(quantity));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(double number){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.total_text_view);
        priceTextView.setText(message);
    }

    private double calculatePrice(double quantity){
        double price = quantity * 7.5;
        return price;
    }

    private double calculateTotalPrice(boolean hasWhipped, boolean hasChocolate, double quantity){
        double basePrice = 5;
        if (hasChocolate) basePrice += 3;
        if (hasWhipped) basePrice += 1.5;
        double price = quantity * basePrice;
        return price;
    }

    private String createOrderSummary(String name, double price, boolean hasWhippedCream,
                                      boolean hasChocolate){
        String priceMesage = "Name: " + name;
        priceMesage += "\nQuantity " + quantity;
        priceMesage += "\nAdd Whipped Cream? " + hasWhippedCream;
        priceMesage += "\nAdd Chocolate? " + hasChocolate;
        priceMesage += "\nTotal $ " + price;
        priceMesage += "\nThank you!";
        return priceMesage;
    }
}
