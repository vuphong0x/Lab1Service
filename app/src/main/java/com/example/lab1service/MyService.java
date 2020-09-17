package com.example.lab1service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Bundle bundle = intent.getBundleExtra("student");
        String MSSV = bundle.getString("MSSV");
        String Name = bundle.getString("Name");
        String Class = bundle.getString("Class");
        Toast.makeText(this, "Thêm sinh viên thành công!\n" + MSSV + "\n" + Name + "\n" + Class, Toast.LENGTH_SHORT).show();
        super.onStart(intent, startId);
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
