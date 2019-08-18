package com.olukoye.hannah.sneakerdroid.data;

import com.olukoye.hannah.sneakerdroid.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegApi {

        private static Retrofit retrofit = null;
        public static UserRegInterface getUser() {

            // change your base URL
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(String.valueOf(R.string.base_url))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            //Creating object for our interface
            UserRegInterface api = retrofit.create(UserRegInterface.class);
            return api; // return the APIInterface object
        }

}
