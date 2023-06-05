package com.example.taskss.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.taskss.CarService;
import com.example.taskss.R;


public class SecondFragment extends Fragment implements View.OnClickListener {
    public Button btnCountry;
    public Button btnCars;
    public Button btnMessage;
    public Button btnShare;
    public Button btnLogout;
    private static final String CHANNEL_ID = "TestChannel";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCountry = view.findViewById(R.id.buttonCountry);
        btnCountry.setOnClickListener(this);
        btnCars = view.findViewById(R.id.buttonChooseAuto);
        btnCars.setOnClickListener(this);
        btnMessage = view.findViewById(R.id.buttonMessageTest);
        btnMessage.setOnClickListener(this);
        btnShare = view.findViewById(R.id.buttonShare);
        btnShare.setOnClickListener(this);
        btnLogout = view.findViewById(R.id.exitFromAcc);
        btnLogout.setOnClickListener(this);
        TextView tv = view.findViewById(R.id.userName);
        tv.setText(getArguments().getString("data"));
        createNotificationChannel();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCountry:
                Log.d("111","Clicked country choose");
                //Navigation.findNavController(v).navigate(R.id.action_secondFragment2_to_chooseCountryFragment);
                break;
            case R.id.buttonChooseAuto:
                Log.d("111","Clicked auto choose");
                Navigation.findNavController(v).navigate(R.id.action_secondFragment2_to_fragmentResview);
                break;
            case R.id.buttonMessageTest:
                Log.d("111","Clicked message");
                Intent intent = new Intent(requireContext(), CarService.class);
                requireActivity().startService(intent);
                showNotification();
                break;
            case R.id.buttonShare:
                Log.d("111", "Clicked share");
                Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                textIntent.putExtra(Intent.EXTRA_SUBJECT, "GOUL_SSS+");
                textIntent.putExtra(Intent.EXTRA_EMAIL, "CrashAPP@gmail.com");
                textIntent.putExtra(Intent.EXTRA_TEXT, "Присоединяйтесь к CrashAPP");
                requireActivity().startActivity(textIntent);
                break;
            case R.id.exitFromAcc:
                Log.d("111", "Clicked logout");
                Navigation.findNavController(v).navigate(R.id.action_secondFragment2_to_firstFragment);
                break;
        }
    }
    private void showNotification() {
        Notification notification = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_action_name)
                .setContentText("Раз вы видите сообщение, то проверка прошла успешно")
                .setContentTitle("Успешно")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, notification);

    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "TestChannel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager notificationManager =
                    (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

}