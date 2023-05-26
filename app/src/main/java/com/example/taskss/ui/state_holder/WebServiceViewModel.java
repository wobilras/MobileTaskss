package com.example.taskss.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskss.data.MainRepository;
import com.example.taskss.data.models.Post;
import com.example.taskss.ui.WebServiceRequests;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceViewModel extends AndroidViewModel {

    public WebServiceViewModel(@NonNull Application application) {
        super(application);
        repository.getFirstPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post post = response.body();
                    postLiveData.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });
        repository.pushPost(new Post(
                1337,
                482,
                "VLD",
                "Anglichankasosatb")
        ).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post post = response.body();
                    pushResponseLiveData.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

        repository.getAllPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();
                    listPostsLiveData.setValue(posts);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
    }

    private final MainRepository repository = new MainRepository(getApplication());
    private MutableLiveData<Post> postLiveData = new MutableLiveData<>();

    public LiveData<Post> getPostLiveData() {
        return postLiveData;
    }

    private MutableLiveData<Post> pushResponseLiveData = new MutableLiveData<>();

    public LiveData<Post> getPushResponseLiveData() {
        return pushResponseLiveData;
    }

    private MutableLiveData<List<Post>> listPostsLiveData = new MutableLiveData<>();

    public LiveData<List<Post>> getListPostsLiveData() {
        return listPostsLiveData;
    }
}