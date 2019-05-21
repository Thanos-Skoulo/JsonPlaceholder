package com.company;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TodosService todosService = new TodosService();

        todosService.getToDosAsync(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                for(Todo todo : response.body()){
                    System.out.println(todo.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable throwable) {

            }
        });



    }
}
