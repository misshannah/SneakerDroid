package com.olukoye.hannah.sneakerdroid.data;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.Call;

public interface UserRegInterface {


    @FormUrlEncoded
    @POST("/api/v1/mobile/participants/")
        Call<UserPojo> registration(@Field("first_name") String first_name,
                                    @Field("last_name") String last_name );
}

