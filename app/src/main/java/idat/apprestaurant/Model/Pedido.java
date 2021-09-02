package idat.apprestaurant.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.util.List;

public class Pedido {

    @SerializedName("idPedido")
    @Expose
    private Integer idPedido;
    @SerializedName("numDoc")
    @Expose
    private String numDoc;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("total")
    @Expose
    private float total;
    @SerializedName("listo")
    @Expose
    private boolean listo;
    @SerializedName("pago")
    @Expose
    private boolean pago;
    @SerializedName("mesa")
    @Expose
    private Integer mesa;
    @SerializedName("tipoPedido")
    @Expose
    private TipoPedido tipoPedido;
    @SerializedName("pedidoPlatoPed")
    @Expose
    private List<PedidoPlato> pedidoPlatoPed;

    public Pedido(){}

    public Pedido(String numDoc, String fecha, float total, boolean listo, boolean pago, TipoPedido tipoPedido, List<PedidoPlato> pedidoPlatoPed) {
        this.numDoc = numDoc;
        this.fecha = fecha;
        this.total = total;
        this.listo = listo;
        this.pago = pago;
        this.tipoPedido = tipoPedido;
        this.pedidoPlatoPed = pedidoPlatoPed;
    }

    public Pedido(Integer idPedido, String numDoc, String fecha, float total, boolean listo, boolean pago, TipoPedido tipoPedido, List<PedidoPlato> pedidoPlatoPed) {
        this.idPedido = idPedido;
        this.numDoc = numDoc;
        this.fecha = fecha;
        this.total = total;
        this.listo = listo;
        this.pago = pago;
        this.tipoPedido = tipoPedido;
        this.pedidoPlatoPed = pedidoPlatoPed;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public List<PedidoPlato> getPedidoPlatoPed() {
        return pedidoPlatoPed;
    }

    public void setPedidoPlatoPed(List<PedidoPlato> pedidoPlatoPed) { this.pedidoPlatoPed = pedidoPlatoPed; }
    public boolean isListo() { return listo; }

    public void setListo(boolean listo) { this.listo = listo; }

    public boolean isPago() { return pago; }

    public void setPago(boolean pago) { this.pago = pago; }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }
}
