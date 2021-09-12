package idat.apprestaurant.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PedidoPlato {

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
    private Producto platoPed;

    public PedidoPlato(){}

    public PedidoPlato(int cantidad, Producto platoPed) {
        this.cantidad = cantidad;
        this.platoPed = platoPed;
    }

    public PedidoPlato(Integer idPedidoPlato, int cantidad, Producto platoPed) {
        this.idPedidoPlato = idPedidoPlato;
        this.cantidad = cantidad;
        this.platoPed = platoPed;
    }

    public PedidoPlato(Integer idPedidoPlato, int cantidad, Pedido pedido, Producto platoPed) {
        this.idPedidoPlato = idPedidoPlato;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.platoPed = platoPed;
    }

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

    public Producto getPlatoPed() {
        return platoPed;
    }

    public void setPlatoPed(Producto platoPed) {
        this.platoPed = platoPed;
    }
}
