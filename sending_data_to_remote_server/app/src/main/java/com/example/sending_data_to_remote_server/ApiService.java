package com.example.sending_data_to_remote_server;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import com.example.sending_data_to_remote_server.Student; // Make sure to import the correct Student class

public interface ApiService {

    @POST("insert_student.php")
    Call<Void> insertStudent(@Body Student student);
}
