package idat.apprestaurant.api;

import java.util.List;

import idat.apprestaurant.Model.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PlatoService {

    @GET("1")
    Call<List<Producto>> getListaPromociones();

    @GET("2")
    Call<List<Producto>> getListaPiqueos();

    @GET("3")
    Call<List<Producto>> getListaCebiches();

    @GET("4")
    Call<List<Producto>> getListaNinos();

    @GET("5")
    Call<List<Producto>> getListaTiradito();

    @GET("6")
    Call<List<Producto>> getListaMakis();

    @GET("7")
    Call<List<Producto>> getListaSopas();

    @GET("8")
    Call<List<Producto>> getListaAcompanamientos();

    @GET("9")
    Call<List<Producto>> getListaEspecialidad();

    @GET("10")
    Call<List<Producto>> getListaPastasRisottos();

    @GET("11")
    Call<List<Producto>> getListaArroces();

    @GET("12")
    Call<List<Producto>> getListaBebidas();

    @GET("13")
    Call<List<Producto>> getListaTragos();

    @GET("14")
    Call<List<Producto>> getListaCervezas();

}
