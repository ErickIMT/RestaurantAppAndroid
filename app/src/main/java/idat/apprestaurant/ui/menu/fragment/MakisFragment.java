package idat.apprestaurant.ui.menu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import idat.apprestaurant.MenuActivity;
import idat.apprestaurant.Model.AdapterProducto;
import idat.apprestaurant.Model.PedidoPlato;
import idat.apprestaurant.Model.Plato;
import idat.apprestaurant.R;
import idat.apprestaurant.api.PlatoApi;
import idat.apprestaurant.api.PlatoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakisFragment extends Fragment implements AdapterProducto.platoListClickListener{

    AdapterProducto adapterProducto;
    RecyclerView rView;
    ArrayList<Plato> listaPlatoes = new ArrayList<>();
    PlatoService servP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_makis, container, false);
        rView = view.findViewById(R.id.rViewMakis);

        //Cargar datos a la lista
        consultarApi();
        return view;
    }

    public void consultarApi(){
        servP = PlatoApi.getListaPromoService();
        Call<List<Plato>> call = servP.getListaMakis();
        call.enqueue(new Callback<List<Plato>>() {
            @Override
            public void onResponse(Call<List<Plato>> call, Response<List<Plato>> response) {
                listaPlatoes.addAll(response.body());

                //Mostrar Datos
                mostrarData();
            }

            @Override
            public void onFailure(Call<List<Plato>> call, Throwable t) {
                Toast.makeText(getContext(), "Ocurrio Un Error: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void mostrarData(){
        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterProducto = new AdapterProducto(getContext(), listaPlatoes,this);
        rView.setAdapter(adapterProducto);
    }

    @Override
    public void agregarPlatoLista(PedidoPlato plato) {
        ((MenuActivity)getActivity()).aggListaFragment(plato);
    }

    @Override
    public void modificarPlatoLista(PedidoPlato plato) {
        ((MenuActivity)getActivity()).updateListaFragment(plato);
    }

    @Override
    public void eliminarPlatoLista(PedidoPlato plato) {
        ((MenuActivity)getActivity()).removeListaFragment(plato);
    }
}