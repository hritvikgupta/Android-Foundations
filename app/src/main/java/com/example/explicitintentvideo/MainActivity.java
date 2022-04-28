package com.example.explicitintentvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import android.app.Activity;


public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btn1, btn2;
    TextView tvresults;
    // final here we used to create a constant and all must be UPPER CASE letter
    //3 is a constant we use it to identify activity3 when we are sending data from
    // some activity to the main activity
    final int ACTIVITY3 = 3;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK )
                    {
                        // There are no request codes
                        Intent data = result.getData();
                        //Catching the data from the Activity3 using surname
                        tvresults.setText(data.getStringExtra("surname"));

                    }
                    if(result.getResultCode() == Activity.RESULT_CANCELED)
                    {
                            tvresults.setText("No Data Received");
                    }
                }
            });




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Linking the names to the xml file
        etName = findViewById(R.id.etName);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        tvresults = findViewById(R.id.tvresults);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                if(etName.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
                else{
                    String name = etName.getText().toString().trim();
                    //Takes the value where you are now and where you want to go
                    // so where in the main activity and want to go to the activiy 2
                    Intent intent = new Intent(MainActivity.this, com.example.explicitintentvideo.Activity2.class);
                    //We need to pass on the string value pair where string is the id and next is the data we want to send
                    // to the activity2 page and can use as many putExtra you want
                    intent.putExtra("Data", name);
                    startActivity(intent);

                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.explicitintentvideo.Activity3.class);
                //Start activity for the specific purpose
                someActivityResultLauncher.launch(intent);

            }
        });


    }
}