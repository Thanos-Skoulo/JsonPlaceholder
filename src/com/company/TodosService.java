package com.company;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;

public class TodosService {

    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build()).build();
    private JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


    ArrayList<Todo> getToDos(){

            ArrayList<Todo> todos = null;

            Call<ArrayList<Todo>> todoResponceCall = jsonPlaceHolderApi.getToDos();

            try {
                Response<ArrayList<Todo>> response = todoResponceCall.execute();
                todos = response.body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return todos;
        }

        void getToDosAsync( Callback<ArrayList<Todo>> callback){


        Call<ArrayList<Todo>> toDosCallAsync = jsonPlaceHolderApi.getToDos();

        toDosCallAsync.enqueue(callback);


        }


}
