package idat.apprestaurant.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import idat.apprestaurant.R;

public class AdapterListaPedidos extends RecyclerView.Adapter<AdapterListaPedidos.ViewHolder> {

    Context context;
    List<Pedido> lista;

    public AdapterListaPedidos(Context context, List<Pedido> lista){
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_pedidos,parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(lista != null && lista.size() > 0){

            Pedido pedido = lista.get(position);
            holder.mesa.setText(pedido.getMesa().toString());
            holder.pagar.setText("Pagar");
            if(pedido.isListo()){
                holder.listo.setText("Listo");
            }else{
                holder.listo.setText("Preparando");
            }
        }else{
            return;
        }
    }

    @Override
    public int getItemCount() { return lista.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mesa, listo;
        Button pagar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mesa = itemView.findViewById(R.id.tab_list_mesa);
            listo = itemView.findViewById(R.id.tab_list_listo);
            pagar = itemView.findViewById(R.id.tab_list_pagar);
        }
    }
}
