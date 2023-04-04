package com.example.taskss.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taskss.R;
import com.example.taskss.data.models.State;
import com.example.taskss.ui.state_holder.StateAdapter;

import java.util.ArrayList;

public class FragmentResview extends Fragment {
    String TAG = "carname";
    String[] cars = getResources().getStringArray(R.array.MarksOfCars);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resview, container, false);
        ArrayList<State> states = new ArrayList<State>();
        for(int i=0;i<20;i++){
            states.add(new State (cars[i],R.drawable.ic_action_name));
        }
        RecyclerView recyclerView = view.findViewById(R.id.carList);
        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {
                Log.d(TAG,state.getName());
                Toast.makeText(getContext(), state.getName(), Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_fragmentResview_to_carInfoFragment);
            }
        };
        StateAdapter adapter = new StateAdapter(getContext(), states, stateClickListener);
        recyclerView.setAdapter(adapter);
        return view;
    }
}