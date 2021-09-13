package idat.apprestaurant.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import idat.apprestaurant.R;

public class AdapterListaConfirmPedido extends RecyclerView.Adapter<AdapterListaConfirmPedido.ViewHolder> {

    Context context;
    List<PedidoPlato> pedidoPlato;

    public AdapterListaConfirmPedido(Context context, List<PedidoPlato> pedidoPlato){
        this.context = context;
        this.pedidoPlato = pedidoPlato;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_confirmacion_pedido,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(pedidoPlato != null || pedidoPlato.size() > 0){
            PedidoPlato pedido = pedidoPlato.get(position);

            holder.plato.setText(pedido.getPlatoPed().getNombre());
            holder.cant.setText(String.valueOf(pedido.getCantidad()));
            holder.precio.setText(String.valueOf(pedido.getPlatoPed().getPrecio()));
        }
    }

    @Override
    public int getItemCount() {
        return pedidoPlato.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView plato, cant, precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plato = itemView.findViewById(R.id.tab_list_platoC);
            cant = itemView.findViewById(R.id.tab_list_cantidadC);
            precio = itemView.findViewById(R.id.tab_list_precioC);
        }
    }
}
