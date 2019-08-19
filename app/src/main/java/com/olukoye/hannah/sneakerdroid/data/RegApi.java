package com.olukoye.hannah.sneakerdroid.data;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RegApi {

    private static HttpLoggingInterceptor logging;
    private static OkHttpClient.Builder httpClient;

        private static Retrofit retrofit;
        public static Retrofit getUser() {


            if (retrofit==null) {
                logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient = new OkHttpClient.Builder();


                httpClient.addInterceptor(logging);
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://interviews.busaracenterlab.org")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
            }
            //UserRegInterface api = retrofit.create(UserRegInterface.class);
            return retrofit;
        }

}
