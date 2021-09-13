package idat.apprestaurant.Model;

import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PedidoPlato implements Serializable {

    @SerializedName("idPedidoPlato")
    @Expose
    private Integer idPedidoPlato;
    @SerializedName("cantidad")
    @Expose
    private int cantidad;
    @SerializedName("pedido")
    @Expose
    private Pedido pedido;
    @SerializedName("platoPed")
    @Expose
    private Plato platoPed;

    public PedidoPlato(){}

    public PedidoPlato(int cantidad, Plato platoPed) {
        this.cantidad = cantidad;
        this.platoPed = platoPed;
    }

    public PedidoPlato(Integer idPedidoPlato, int cantidad, Plato platoPed) {
        this.idPedidoPlato = idPedidoPlato;
        this.cantidad = cantidad;
        this.platoPed = platoPed;
    }

    public PedidoPlato(Integer idPedidoPlato, int cantidad, Pedido pedido, Plato platoPed) {
        this.idPedidoPlato = idPedidoPlato;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.platoPed = platoPed;
    }

    protected PedidoPlato(Parcel in) {
        if (in.readByte() == 0) {
            idPedidoPlato = null;
        } else {
            idPedidoPlato = in.readInt();
        }
        cantidad = in.readInt();
    }
/*
    public static final Creator<PedidoPlato> CREATOR = new Creator<PedidoPlato>() {
        @Override
        public PedidoPlato createFromParcel(Parcel in) {
            return new PedidoPlato(in);
        }

        @Override
        public PedidoPlato[] newArray(int size) {
            return new PedidoPlato[size];
        }
    };*/

    public Integer getIdPedidoPlato() {
        return idPedidoPlato;
    }

    public void setIdPedidoPlato(Integer idPedidoPlato) {
        this.idPedidoPlato = idPedidoPlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Plato getPlatoPed() {
        return platoPed;
    }

    public void setPlatoPed(Plato platoPed) {
        this.platoPed = platoPed;
    }
/*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cantidad);
        dest.writeValue(platoPed);
    }*/
}
