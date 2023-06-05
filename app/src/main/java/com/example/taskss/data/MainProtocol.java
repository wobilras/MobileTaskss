package com.example.taskss.data;

import androidx.lifecycle.LiveData;

import com.example.taskss.data.db.entity.User;
import com.example.taskss.data.models.LoginPerson;
import com.example.taskss.data.db.entity.State;
import com.example.taskss.data.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public interface MainProtocol {
    LiveData<List<State>> getCarList();

    LiveData<Boolean> personLogin(String login, String pass);

    LiveData<State> getItem(int position);

    Call<Post> getFirstPost();

    Call<Post> pushPost(@Body Post post);

    Call<List<Post>> getAllPosts();

    void registration(User user);

    void addCar(State state);
}
