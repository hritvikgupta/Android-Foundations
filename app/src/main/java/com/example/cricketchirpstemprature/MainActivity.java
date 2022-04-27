package com.example.cricketchirpstemprature;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    EditText numide;
    Button bide;
    TextView tvide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting the buttons from the Main activity or the front page to over here
        // numide is the id that we created on activity_main page to enter number now we are connecting that here
        //Using the R (Resources ) Java files on tha resources folder that contains all the information of the app
        numide =  findViewById(R.id.numide);
        bide = findViewById(R.id.bide);
        tvide = findViewById(R.id.tvide);
        tvide.setVisibility(View.GONE);// it will remove the text "text view" that is popping on the emulator before getting any output
        DecimalFormat formatter = new DecimalFormat("#0.00");
        // /Now enabling the submit button that we have created
        bide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(numide.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
                else {
                    int chirps = Integer.parseInt(numide.getText().toString().trim());
                    double temp = (chirps / 3.0) + 4.0;
                    String results = "OutSide Temperature will be" + formatter.format(temp) + "Degree Celsius";

                    tvide.setText(results);
                    tvide.setVisibility(View.VISIBLE);
                }

            }
        });


    }
}