package com.example.android.menu;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView errorMessage1 = (TextView) findViewById(R.id.menu_item_1);
        String message = errorMessage1.getText().toString();
        Log.i("Menu.java", message);

        // Find second menu item TextView and print the text to the logs
        TextView errorMessage2 = (TextView) findViewById(R.id.menu_item_2);
        String message1 = errorMessage2.getText().toString();
        Log.i("Menu.java", message1);

        // Find third menu item TextView and print the text to the logs
        TextView errorMessage3 = (TextView) findViewById(R.id.menu_item_3);
        String message2 = errorMessage3.getText().toString();
        Log.i("Menu.java", message2);
    }
}