package idat.apprestaurant.Model;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import idat.apprestaurant.R;

import static java.lang.String.valueOf;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<Producto> listaProducto;
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

        String nombre = listaProducto.get(position).getNombre();
        float precio = listaProducto.get(position).getPrecio();
        holder.nombre.setText(nombre);
        holder.precio.setText(valueOf(precio));
        holder.imagen.setImageResource(R.drawable.menupromo);
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
        TextView nombre, precio;
        ImageView imagen;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombreProducto);
            precio = itemView.findViewById(R.id.txtPrecioProducto);
            imagen = itemView.findViewById(R.id.imgProducto);
        }
    }
}
