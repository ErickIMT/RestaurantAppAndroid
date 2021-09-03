package idat.apprestaurant.Model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import idat.apprestaurant.R;

public class AdapterListaReservas extends RecyclerView.Adapter<AdapterListaReservas.ViewHolder> {

    Context context;
    List<Reserva> lista;

    public AdapterListaReservas(Context context, List<Reserva> lista){
        this.context = context;
        this.lista = lista;
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_reservas,parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(lista != null && lista.size() > 0) {
            Reserva reserva = lista.get(position);
            holder.fecha.setText(String.valueOf(reserva.getFecha()));
            holder.hora.setText(reserva.getHora());
            holder.mesa.setText(String.valueOf(reserva.getMesa()));
            holder.cliente.setText(reserva.getNombreCliente());
        }else{
            Log.e("Lista", "Vacia: "+lista.isEmpty());
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView fecha, hora, mesa, cliente;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fecha = itemView.findViewById(R.id.tab_list_rfecha);
            hora = itemView.findViewById(R.id.tab_list_rhora);
            mesa = itemView.findViewById(R.id.tab_list_rmesa);
            cliente = itemView.findViewById(R.id.tab_list_rcliente);
        }
    }
}
