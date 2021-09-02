package idat.apprestaurant.api;

import idat.apprestaurant.Model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {

    @POST("login")
    Call<String> getLogin(@Body Usuario usuario);
}
