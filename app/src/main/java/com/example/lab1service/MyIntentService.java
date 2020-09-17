package com.example.lab1service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    String input = "";
    int charA, charB, charC = 0;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        input = intent.getStringExtra("input");

        char[] arr = input.toCharArray();
        for (char c : arr) {
            switch (Character.toString(c)) {
                case "A":
                case "a":
                    charA++;
                    break;
                case "B":
                case "b":
                    charB++;
                    break;
                case "C":
                case "c":
                    charC++;
                    break;
                default:
                    break;
            }
        }

        if (charA != 0) {
            Toast.makeText(this, "Số lượng ký tự A: " + charA, Toast.LENGTH_SHORT).show();
        }

        if (charB != 0) {
            Toast.makeText(this, "Số lượng ký tự B: " + charB, Toast.LENGTH_SHORT).show();
        }

        if (charC != 0) {
            Toast.makeText(this, "Số lượng ký tự C: " + charC, Toast.LENGTH_SHORT).show();
        }

        if (charA == 0 && charB == 0 && charC == 0) {
            Toast.makeText(this, "Không có A, B, C", Toast.LENGTH_SHORT).show();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
