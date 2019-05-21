package com.company;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;

public interface JsonPlaceHolderApi {

    @GET("todos")
    Call<ArrayList<Todo>> getToDos();


    @POST("todos")
    Call<Todo> createToDo(@Body Todo todo);

    @PUT("todos/{id}")
    Call<Todo> updateToDo(@Body Todo todo, @Path("id") int id);

    @DELETE("todos/{id}")
    Call<Void> deletedToDo(@Path("id") int id);




}
