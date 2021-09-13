package idat.apprestaurant.Model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import idat.apprestaurant.R;

import static java.lang.String.valueOf;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolder>{

    private LayoutInflater inflater;
    private ArrayList<Plato> listaPlato;
    private platoListClickListener listListener;

    public AdapterProducto(Context context, ArrayList<Plato> listaPlato, platoListClickListener listListener){
        this.inflater = LayoutInflater.from(context);
        this.listaPlato = listaPlato;
        this.listListener = listListener;
    }

    public AdapterProducto(Context context, ArrayList<Plato> listaPlato){
        this.inflater = LayoutInflater.from(context);
        this.listaPlato = listaPlato;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_productos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        Plato producto = listaPlato.get(position);

        PedidoPlato plato = new PedidoPlato();

        holder.nombre.setText(producto.getNombre());
        holder.precio.setText(valueOf(producto.getPrecio()));
        holder.imagen.setImageResource(R.drawable.menupromo);
        holder.aggPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plato.setCantidad(1);
                plato.setPlatoPed(producto);
                //agregarALista en Activity
                Log.i("Adapter Producto", "onClick: AggPlato: "+plato.getCantidad()+" y "+plato.getPlatoPed().getNombre());
                listListener.agregarPlatoLista(plato);

                holder.layoutBtns.setVisibility(View.VISIBLE);
                holder.aggPlato.setVisibility(View.GONE);
                holder.cant.setText(valueOf(plato.getCantidad()));
            }
        });

        holder.menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = plato.getCantidad();
                total--;
                if(total > 0){
                    plato.setCantidad(total);
                    //Actualizar Lista;
                    listListener.modificarPlatoLista(plato);
                    holder.cant.setText(valueOf(total));
                }else{
                    holder.layoutBtns.setVisibility(View.GONE);
                    holder.aggPlato.setVisibility(View.VISIBLE);
                    plato.setCantidad(total);
                    //Borrar de Lista
                    listListener.eliminarPlatoLista(plato);
                }
            }
        });

        holder.mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = plato.getCantidad();
                total++;
                plato.setCantidad(total);
                //ClickListener Actualizar Lista;
                listListener.modificarPlatoLista(plato);

                holder.cant.setText(valueOf(total));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPlato.size();
    }

    /*@Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, precio, cant, aggPlato;
        ImageView imagen, menos, mas;
        LinearLayout layoutBtns;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombreProducto);
            precio = itemView.findViewById(R.id.txtPrecioProducto);
            cant = itemView.findViewById(R.id.txvCantPlato);
            imagen = itemView.findViewById(R.id.imgProducto);
            menos = itemView.findViewById(R.id.imgMenos);
            mas = itemView.findViewById(R.id.imgMas);
            layoutBtns = itemView.findViewById(R.id.layoutBtnsProducto);
            aggPlato = itemView.findViewById(R.id.btnAgregarPlato);
        }
    }

    public interface platoListClickListener{
        public void agregarPlatoLista(PedidoPlato plato);
        public void modificarPlatoLista(PedidoPlato plato);
        public void eliminarPlatoLista(PedidoPlato plato);
    }
}
