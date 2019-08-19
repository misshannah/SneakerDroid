package com.olukoye.hannah.sneakerdroid.data;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.Call;

public interface UserRegInterface {

    @Headers("Content-Type: application/json")
    @POST("/api/v1/mobile/participants/")
    Call<UserPojo> registration(@Body Map<String, Object> storedata);

}

