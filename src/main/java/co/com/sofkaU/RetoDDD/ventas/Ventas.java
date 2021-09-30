package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkaU.RetoDDD.ventas.events.*;
import co.com.sofkaU.RetoDDD.ventas.values.*;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;


public class Ventas extends AggregateEvent<IdVentas> {
    protected CanalVenta canalVenta;
    protected TipoVenta tipoVenta;
    protected Pedido pedidos;
    protected Set<Producto> productos;
    protected Factura facturas;

    public Ventas(IdVentas entityId, CanalVenta canalVenta, TipoVenta tipoVenta) {
        super(entityId);
        appendChange(new VentaCreada(tipoVenta, canalVenta)).apply();
    }

    public void actualizarDescripcionDePedido(IdPedido entityId, DescripcionPedido descripcionPedido){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcionPedido);
        appendChange(new DescripcionDePedidoActualizado(entityId, descripcionPedido)).apply();
    }

    public void agregarPedido(IdPedido entityId, NombrePedido nombrePedido, DescripcionPedido descripcionPedido){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombrePedido);
        Objects.requireNonNull(descripcionPedido);
        appendChange(new PedidoAgregado(entityId, nombrePedido, descripcionPedido)).apply();
    }

    public void agregarProducto(IdProducto entityId, NombreProducto nombreProducto){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombreProducto);
        appendChange(new ProductoAgregado(entityId, nombreProducto)).apply();
    }
    public void actualizarNombreDeProducto(IdProducto entityId, NombreProducto nombreProducto){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombreProducto);
        appendChange(new NombreProductoActualizado(entityId, nombreProducto)).apply();
    }

    public  void agregarFactura(IdFactura entityId, FechaFactura fechaFactura, Precio precio){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(fechaFactura);
        Objects.requireNonNull(precio);
        appendChange(new FacturaAgregada(entityId, fechaFactura, precio)).apply();
    }

    //Encontrar ffactura por id
    /*public Optional<Factura> getFacturaPorId(IdFactura entityId){
        return facturas().stream().filter(factura -> factura.identity().equals(entityId)).findFirst();
    }*/


    public TipoVenta tipoVenta(){
        return tipoVenta;
    }

    public CanalVenta canalVenta(){
        return canalVenta;
    }

    public Pedido pedidos(){
        return pedidos;
    }

    public Set<Producto> productos(){
        return productos;
    }

    public Factura factura(){
        return facturas;
    }
}
