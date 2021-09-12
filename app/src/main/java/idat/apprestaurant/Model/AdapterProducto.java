package idat.apprestaurant.Model;

import android.content.Context;
import android.text.Layout;
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

import idat.apprestaurant.MenuActivity;
import idat.apprestaurant.R;

import static java.lang.String.valueOf;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<Producto> listaProducto;
    MenuActivity activity = new MenuActivity();
    //listener
    private View.OnClickListener listener;

    public AdapterProducto(Context context, ArrayList<Producto> listaProducto){
        this.inflater = LayoutInflater.from(context);
        this.listaProducto = listaProducto;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_productos, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        Producto producto = listaProducto.get(position);

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
                activity.aggListaFragment(plato);


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
                    activity.updateListaFragment(plato);
                    holder.cant.setText(valueOf(total));
                }else{
                    holder.layoutBtns.setVisibility(View.GONE);
                    holder.aggPlato.setVisibility(View.VISIBLE);
                    plato.setCantidad(total);
                    //Borrar de Lista
                    activity.removeListaFragment(plato);
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
                activity.updateListaFragment(plato);

                holder.cant.setText(valueOf(total));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProducto.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

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
}
