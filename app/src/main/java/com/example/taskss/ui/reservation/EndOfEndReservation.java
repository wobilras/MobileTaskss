package com.example.taskss.ui.reservation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.taskss.R;

public class EndOfEndReservation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_end_of_end_reservation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView resultTime = view.findViewById(R.id.finalTime);
        Bundle bundle = getArguments();
        String time = bundle.getString("time");
        String timeSec = time.substring(18);
        String timeMin = time.substring(15,17);
        resultTime.setText(time);
        TextView resultCost = view.findViewById(R.id.finalCost);
        float cost = (float) (Integer.parseInt(timeSec) * 0.05 + 3 * Integer.parseInt(timeMin));
        resultCost.setText(getString(R.string.totalCost) + " " + cost + "руб");
        Button btnContinue = view.findViewById(R.id.btnContinueEnd);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });
    }
}