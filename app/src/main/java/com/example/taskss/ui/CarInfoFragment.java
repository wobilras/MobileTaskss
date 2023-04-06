package com.example.taskss.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.taskss.R;
import com.example.taskss.data.models.State;
import com.example.taskss.ui.state_holder.CarInfoViewModel;

import java.util.List;

public class CarInfoFragment extends Fragment {
    public CarInfoFragment() {
        super(R.layout.fragmet_car_info);
    }

    private CarInfoViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(CarInfoViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        ImageView carInfoImage = view.findViewById(R.id.carInfoImage);
        TextView carInfoName = view.findViewById(R.id.carInfoName);
        parseArgs();
        viewModel.carListItemLd.observe(getViewLifecycleOwner(), new Observer<State>() {
            @Override
            public void onChanged(State states) {
                carInfoImage.setImageResource(states.getCarResource());
                carInfoName.setText(states.getName());
            }
        });

    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int pos = bundle.getInt(FragmentResview.TAG);
            viewModel.getListItem(pos);
        }
    }
}
