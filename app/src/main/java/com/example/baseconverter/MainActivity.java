package com.example.baseconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button convertBtn;
    private ImageView swapBtn;
    private EditText numberInput, fromInput, toInput;
    private TextView resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertBtn = findViewById(R.id.btn_convert);
        swapBtn = findViewById(R.id.btn_swap);
        numberInput = findViewById(R.id.input_number);
        fromInput = findViewById(R.id.input_from);
        toInput = findViewById(R.id.input_to);
        resultLabel = findViewById(R.id.label_result);

        swapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp = fromInput.getText().toString();
                fromInput.setText(toInput.getText().toString());
                toInput.setText(tmp);

            }
        });

        convertBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            Converter c = new Converter(numberInput.getText().toString(),
                    Integer.parseInt(fromInput.getText().toString()),
                    Integer.parseInt(toInput.getText().toString()));
            if(!c.valid()) {
                Toast.makeText(getApplicationContext(),
                        R.string.incorrect_value, Toast.LENGTH_SHORT).show();
            } else {
                resultLabel.setText(c.convert());
            }
        } catch(NumberFormatException e) {
            Toast.makeText(getApplicationContext(), R.string.incorrect_value, Toast.LENGTH_SHORT).show();
        }
    }
}
