package com.company;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TodosService todosService = new TodosService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose a user's id to update");
        int id = scanner.nextInt();
        todosService.updateToDo(new Todo(23,"baggelis"), id);


        System.out.println("choose a useId to delete");
        int userId = scanner.nextInt();

        todosService.deleteToDo(userId);



        todosService.createToDo(new Todo(99,"awesome"));


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
