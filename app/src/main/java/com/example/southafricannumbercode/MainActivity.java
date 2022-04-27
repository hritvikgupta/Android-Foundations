package com.example.southafricannumbercode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        // /Now enabling the submit button that we have created
       bide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = numide.getText().toString().trim(); //Trim is used to remove all tha trailling white spaces and toString converts the the input into the string
                //for getting the date of birth we have took first 5 characters from the string
                String dob = idNumber.substring(0, 6); // as it get values from 0 to 5 therefore we have given 6 here
                //As we are getting an character value in a integer therefore it might given as ascii value
                //Therefore we use the character.tostring method to convert it into the string
                // Then we can again convert into the integer using the following
                int gender  = Integer.parseInt(Character.toString(idNumber.charAt(6))); // this is to identify gender according to the given problem\
                String sGender;
                if(gender<5)
                {
                    sGender = "Female";
                }
                else
                    sGender = "Male";

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if(nationality == 0)
                    sNationality = "SA Citizen";
                else
                    sNationality = "Permanent Resident";
                // As the android is showing warning therefore we used alt+enter to create the new string resources
                // That is createed in the strings.xml file of the rsources

                //As this is still throwing error after being used method of the get string so we create a new
                //string variable for it
                //tvide.setText(getString(R.string.dob) + dob + getString(R.string.newline)+
                //                getString(R.string.sgender) + sGender + getString(R.string.newline)+
                //                getString(R.string.snationality) + sNationality);

                String text = getString(R.string.dob) + dob + "\n" +
                           getString(R.string.sgender) + sGender + "\n" +
                                getString(R.string.snationality) + sNationality;
                tvide.setText(text);
                //Setting the visibility again so that we can show our output
                tvide.setVisibility(View.VISIBLE);

            }
        });


    }
}