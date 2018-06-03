package com.example.rhianna.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.validatePassButton);
        final TextView output = findViewById(R.id.output);
        final EditText input = findViewById(R.id.input);
        final Validator validator = new Validator();

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                android.text.Editable password = input.getText();

                if(password.toString().equals("")){
                    output.setText("Please enter a password into the box below.");
                }

                else {

                    int rulesPassed = validator.validate(password.toString());

                    switch (rulesPassed) {
                        case 1: output.setText("Very Weak");
                                break;
                        case 2: output.setText("Very Weak");
                                break;
                        case 3: output.setText("Weak");
                                break;
                        case 4: output.setText("Moderate");
                                break;
                        case 5: output.setText("Strong");
                                break;
                    }
                }
            }
        });
    }
}
