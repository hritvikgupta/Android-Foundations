package com.example.explicitintentvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity3 extends AppCompatActivity {

    EditText etSurname;
    Button btnSubmit, btnCancel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurname = findViewById(R.id.etSurname);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);


        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(etSurname.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this, "Please Enter Some Values",Toast.LENGTH_SHORT).show();
                }
                else {
                    String Surname;
                    Surname = etSurname.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("surname", Surname);
                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();


                }



            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();


            }
        });



    }
}