package com.example.taskss.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taskss.R;
import com.example.taskss.data.models.Post;
import com.example.taskss.ui.state_holder.WebServiceViewModel;

import java.util.List;

public class WebServiceRequests extends Fragment {
    private WebServiceViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web_service_requests, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WebServiceViewModel.class);
        TextView textGet = view.findViewById(R.id.textGet);
        TextView textPost = view.findViewById(R.id.textPost);
        TextView textGet2 = view.findViewById(R.id.textGet2);
        viewModel.getPostLiveData().observe(getViewLifecycleOwner(), new Observer<Post>() {
            @Override
            public void onChanged(Post post) {
                textGet.setText("Get: " + post.getTitle());
            }
        });
        viewModel.getPushResponseLiveData().observe(getViewLifecycleOwner(), new Observer<Post>() {
            @Override
            public void onChanged(Post postResponse) {
                textPost.setText("Post: " + postResponse.getTitle());
            }
        });
        viewModel.getListPostsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                textGet2.setText("Get: " + posts.get(10).getTitle());
            }
        });
    }
}