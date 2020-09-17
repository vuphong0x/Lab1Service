package com.example.lab1service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnStartService, btnStopService, btnFind;
    EditText edtInput;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);
        btnFind = findViewById(R.id.btnFind);
        edtInput = findViewById(R.id.edtInput);


        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MyService.class);
                Bundle bundle = new Bundle();
                bundle.putString("MSSV", "PH09906");
                bundle.putString("Name", "Vũ Văn Phòng");
                bundle.putString("Class", "PT15354-MOB");
                intent.putExtra("student", bundle);
                startService(intent);
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getBaseContext(), MyIntentService.class);
                String input = edtInput.getText().toString();
                intent.putExtra("input", input);
                startService(intent);
            }
        });
    }
}