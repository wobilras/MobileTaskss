package com.example.taskss;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.taskss.ui.MainActivity;

public class CarService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        TextView timer = new TextView(this);
        Button btn = new Button(this);
        btn.setBackgroundColor(Color.WHITE);
        timer.setTextColor(Color.BLACK);
        new CountDownTimer(200000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                timer.setText("До конца бесплатного ожидания: "
                        + millisUntilFinished / 1000);
                btn.setText(timer.getText());
            }
            public void onFinish() {
                timer.setText("Время бесплатного ожидания окончено!");
                btn.setText(timer.getText());
            }
        }.start();
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            stopSelf();
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
            windowManager.addView(btn,params);
            params.gravity = Gravity.TOP | Gravity.START;
            windowManager.updateViewLayout(btn,params);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}