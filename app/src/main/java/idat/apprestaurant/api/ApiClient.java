package idat.apprestaurant.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import idat.apprestaurant.Model.Usuario;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getClient(String url, OkHttpClient okHttpClient){

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory .create(gson))
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
