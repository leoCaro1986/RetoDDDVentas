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
    protected Pedido pedido;
    protected Set<Producto> productos;
    protected Factura factura;

    public Ventas(IdVentas entityId, CanalVenta canalVenta, TipoVenta tipoVenta) {
        super(entityId);
        appendChange(new VentaCreada(tipoVenta, canalVenta)).apply();
    }

    //Constructor privado para afectar los estados
    private Ventas(IdVentas entityId){
        super(entityId);
        subscribe(new VentasChange(this));
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

    public void agregarProducto(IdProducto idProducto, NombreProducto nombreProducto){
        Objects.requireNonNull(idProducto);
        Objects.requireNonNull(nombreProducto);
        appendChange(new ProductoAgregado(idProducto, nombreProducto)).apply();
    }
    public void actualizarNombreDeProducto(IdProducto idProducto, NombreProducto nombreProducto){
        Objects.requireNonNull(idProducto);
        Objects.requireNonNull(nombreProducto);
        appendChange(new NombreProductoActualizado(idProducto, nombreProducto)).apply();
    }

    public void agregarFactura(IdFactura entityId, FechaFactura fechaFactura, Precio precio){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(fechaFactura);
        Objects.requireNonNull(precio);
        appendChange(new FacturaAgregada(entityId, fechaFactura, precio)).apply();
    }

    public void actualizarPrecio(IdFactura idFactura, Precio precio){
        Objects.requireNonNull(idFactura);
        Objects.requireNonNull(precio);
        appendChange(new PrecioActualizado(idFactura, precio)).apply();
    }

    //Encontrar producto por id
    public Optional<Producto>  getProductoPorId(IdProducto idProducto){
        return productos
                .stream()
                .filter(producto -> producto.identity().equals(idProducto))
                .findFirst();
    }



    public TipoVenta tipoVenta(){
        return tipoVenta;
    }

    public CanalVenta canalVenta(){
        return canalVenta;
    }

    public Pedido pedidos(){
        return pedido;
    }

    public Set<Producto> productos(){
        return productos;
    }

    public Factura factura(){
        return factura;
    }
}
