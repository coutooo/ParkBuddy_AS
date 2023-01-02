package com.example.parkbuddy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PaymentActivity extends AppCompatActivity {

    // initializing variables for our edit text and button.
    private EditText amountEdt, upiEdt, nameEdt, descEdt;
    private TextView transactionDetailsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_layout);

        // o nosso vermelho
        int color = Color.parseColor("#A0282C");

        // Get the app bar for the activity
        ActionBar appBar = getSupportActionBar();
        appBar.setBackgroundDrawable(new ColorDrawable(color));
        appBar.setTitle("PAYMENTS");

        // Enable the "back" button in the app bar
        appBar.setDisplayHomeAsUpEnabled(true);

        // initializing all our variables.
        amountEdt = findViewById(R.id.idEdtAmount);
        upiEdt = findViewById(R.id.idEdtUpi);
        nameEdt = findViewById(R.id.idEdtName);
        descEdt = findViewById(R.id.idEdtDescription);
        Button makePaymentBtn = findViewById(R.id.idBtnMakePayment);
        transactionDetailsTV = findViewById(R.id.idTVTransactionDetails);

        // on below line we are getting date and then we are setting this date as transaction id.
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault());
        String transcId = df.format(c);

        // on below line we are adding click listener for our payment button.
        makePaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting data from our edit text.
                String amount = amountEdt.getText().toString();
                String upi = upiEdt.getText().toString();
                String name = nameEdt.getText().toString();
                String desc = descEdt.getText().toString();
                // on below line we are validating our text field.
                if (TextUtils.isEmpty(amount) && TextUtils.isEmpty(upi) && TextUtils.isEmpty(name) && TextUtils.isEmpty(desc)) {
                    Toast.makeText(PaymentActivity.this, "Please enter all the details..", Toast.LENGTH_SHORT).show();
                } else {
                    // if the edit text is not empty then
                    // we are calling method to make payment.
                    Toast.makeText(PaymentActivity.this, "PAYMENT SUCCESSFULLY COMPLETED", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PaymentActivity.this, MainMenu.class);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle "up" button click
        if (item.getItemId() == android.R.id.home) {
            // Navigate the user back to the previous activity
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

