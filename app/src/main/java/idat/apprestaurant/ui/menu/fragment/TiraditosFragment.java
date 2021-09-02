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

import idat.apprestaurant.Model.AdapterProducto;
import idat.apprestaurant.Model.Producto;
import idat.apprestaurant.R;
import idat.apprestaurant.api.PlatoApi;
import idat.apprestaurant.api.PlatoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TiraditosFragment extends Fragment {

    AdapterProducto adapterProducto;
    RecyclerView rView;
    ArrayList<Producto> listaProductos = new ArrayList<>();
    List<Producto> listaApi = new ArrayList<>();
    PlatoService servP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tiraditos, container, false);
        rView = view.findViewById(R.id.rViewTiraditos);

        //Cargar datos a la lista
        consultarApi();
        return view;
    }

    public void consultarApi(){
        servP = PlatoApi.getListaPromoService();
        Call<List<Producto>> call = servP.getListaTiradito();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                listaApi.addAll(response.body());

                //Cargar Datos a la lista
                for(Producto p : listaApi){
                    listaProductos.add(new Producto(p.getNombre(),p.getPrecio()));
                }

                //Mostrar Datos
                mostrarData();
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(getContext(), "Ocurrio Un Error: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void mostrarData(){
        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterProducto = new AdapterProducto(getContext(), listaProductos);
        rView.setAdapter(adapterProducto);

        adapterProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = listaProductos.get(rView.getChildAdapterPosition(v)).getNombre();
                Toast.makeText(getContext(),"Selecciono: "+nombre,Toast.LENGTH_SHORT).show();
            }
        });
    }
}