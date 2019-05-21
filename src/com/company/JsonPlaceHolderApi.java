package com.company;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.ArrayList;

public interface JsonPlaceHolderApi {

    @GET("todos")
    Call<ArrayList<Todo>> getToDos();


}
