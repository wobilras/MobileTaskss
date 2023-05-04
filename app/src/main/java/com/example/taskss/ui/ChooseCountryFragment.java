package com.example.taskss.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.taskss.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChooseCountryFragment extends Fragment {
    public String TAG = "list";
    //interface OnFragmentSendDataListener {
    //    void onSendData(String data);
    //}
    //private ChooseCountryFragment.OnFragmentSendDataListener fragmentSendDataListener;

    String[] countries = getResources().getStringArray(R.array.Countries);
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //fragmentSendDataListener = (ChooseCountryFragment.OnFragmentSendDataListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose, container, false);
        List<HashMap<String,String>> lst = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<20;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", countries[i]);
            hm.put("flag", Integer.toString(R.drawable.aiga_toilet_men) );
            lst.add(hm);
        }
        String[] from = { "flag","txt" };
        int[] to = { R.id.flag, R.id.txt};
        SimpleAdapter adapter = new SimpleAdapter(getContext(),lst,R.layout.list_layout,from, to);
        ListView countriesList = ( ListView ) view.findViewById(R.id.countryList);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                String selectedItem = (String)parent.getItemAtPosition(position);
                Log.d(TAG, selectedItem);
                Toast.makeText(getContext(),selectedItem,Toast.LENGTH_SHORT).show();
                //fragmentSendDataListener.onSendData(selectedItem);
            }
        });
        return view;
    }
}
