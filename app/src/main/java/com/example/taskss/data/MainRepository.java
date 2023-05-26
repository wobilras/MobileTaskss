package com.example.taskss.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.taskss.data.api.PostAPI;
import com.example.taskss.data.api.RetrofitFactory;
import com.example.taskss.data.models.LoginPerson;
import com.example.taskss.data.db.entity.State;
import com.example.taskss.data.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainRepository implements MainProtocol {
    private Context context;
    private DBRemoteDataSource dataSource;

    public MainRepository(Context context) {
        this.context = context;
        dataSource = new DBRemoteDataSource(context);
    }

    @Override
    public LiveData<List<State>> getCarList() {
        return dataSource.getCarList();
    }


    @Override
    public boolean personLogin(LoginPerson loginPerson, boolean allow) {
        return dataSource.PersonLogin(loginPerson, allow);
    }

    @Override
    public LiveData<State> getItem(int position) {
        return dataSource.getItem(position);
    }

    @Override
    public Call<Post> getFirstPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        PostAPI postAPI = retrofit.create(PostAPI.class);
        Call<Post> call = postAPI.getFirstPost();
        return call;
    }

    @Override
    public Call<Post> pushPost(Post post) {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        PostAPI postAPI = retrofit.create(PostAPI.class);
        Call<Post> call = postAPI.pushPost(post);
        return call;
    }

    @Override
    public Call<List<Post>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        PostAPI postAPI = retrofit.create(PostAPI.class);
        Call<List<Post>> call = postAPI.getAllPosts();
        return call;
    }
}
