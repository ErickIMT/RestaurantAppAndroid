package idat.apprestaurant.api;

import java.util.List;

import idat.apprestaurant.Model.Plato;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PlatoService {

    @GET("1")
    Call<List<Plato>> getListaPromociones();

    @GET("2")
    Call<List<Plato>> getListaPiqueos();

    @GET("3")
    Call<List<Plato>> getListaCebiches();

    @GET("4")
    Call<List<Plato>> getListaNinos();

    @GET("5")
    Call<List<Plato>> getListaTiradito();

    @GET("6")
    Call<List<Plato>> getListaMakis();

    @GET("7")
    Call<List<Plato>> getListaSopas();

    @GET("8")
    Call<List<Plato>> getListaAcompanamientos();

    @GET("9")
    Call<List<Plato>> getListaEspecialidad();

    @GET("10")
    Call<List<Plato>> getListaPastasRisottos();

    @GET("11")
    Call<List<Plato>> getListaArroces();

    @GET("12")
    Call<List<Plato>> getListaBebidas();

    @GET("13")
    Call<List<Plato>> getListaTragos();

    @GET("14")
    Call<List<Plato>> getListaCervezas();

}
