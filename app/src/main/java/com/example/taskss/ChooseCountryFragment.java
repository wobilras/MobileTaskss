package com.example.taskss;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ChooseCountryFragment extends Fragment {
    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    private ChooseCountryFragment.OnFragmentSendDataListener fragmentSendDataListener;
    String[] countries = getResources().getStringArray(R.array.Countries);
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentSendDataListener = (ChooseCountryFragment.OnFragmentSendDataListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose, container, false);
        ListView countriesList = view.findViewById(R.id.countryList);
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.activity_list_item, countries);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                String selectedItem = (String)parent.getItemAtPosition(position);

                //fragmentSendDataListener.onSendData(selectedItem);
            }
        });
        return view;
    }
}
