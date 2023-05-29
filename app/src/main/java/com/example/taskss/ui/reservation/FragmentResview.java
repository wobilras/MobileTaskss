package com.example.taskss.ui.reservation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taskss.R;
import com.example.taskss.data.db.entity.State;
import com.example.taskss.ui.state_holder.ReviewViewModel;
import com.example.taskss.ui.state_holder.StateAdapter;

import java.util.List;

public class FragmentResview extends Fragment {
    public static final String TAG = "carname";
    // String[] cars = getResources().getStringArray(R.array.MarksOfCars);
//    String[] cars = {"Nissan", "Toyota"};

    private ReviewViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resview, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ReviewViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        //        ArrayList<State> states = new ArrayList<State>();
//        for (int i = 0; i < 2; i++) {
//            states.add(new State(cars[i], R.drawable.ic_action_name));
//        }
        RecyclerView recyclerView = view.findViewById(R.id.carList);

        viewModel.carListLd.observe(getViewLifecycleOwner(), new Observer<List<State>>() {
            @Override
            public void onChanged(List<State> states) {
                StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
                    @Override
                    public void onStateClick(State state, int position) {
                        Log.d(TAG, state.getName());
                        Toast.makeText(getContext(), state.getName(), Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putInt(TAG, position);
                        Navigation.findNavController(view)
                                .navigate(R.id.action_fragmentResview_to_carInfoFragment, bundle);
                    }
                };
                StateAdapter adapter = new StateAdapter(getContext(), states, stateClickListener);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}