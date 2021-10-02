package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreAsesor;
import co.com.sofkaU.RetoDDD.ventas.comands.AsociarPostVenta;
import co.com.sofkaU.RetoDDD.ventas.events.*;
import co.com.sofkaU.RetoDDD.ventas.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


public class Ventas extends AggregateEvent<IdVentas> {
    protected CanalVenta canalVenta;
    protected TipoVenta tipoVenta;
    protected Pedido pedido;
    protected Set<Producto> productos;
    protected Factura factura;
    protected IdPostVenta idPostVenta;

    //aplico ese metodo cuando el agregado es nuevo
    public Ventas(IdVentas entityId, CanalVenta canalVenta, TipoVenta tipoVenta) {
        super(entityId);
        appendChange(new VentaCreada(tipoVenta, canalVenta)).apply();
    }

    //Constructor privado para afectar los estados
    private Ventas(IdVentas entityId){
        super(entityId);
        subscribe(new VentasChange(this));
    }

//metodo para agregado el agregado que ya esta creado, vamos a crear la venta
    public static Ventas from(IdVentas idVentas, List<DomainEvent> events){
        var ventas = new Ventas(idVentas);
        events.forEach(ventas::applyEvent);
        return ventas;
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

    public void asociarPostVenta(IdPostVenta idPostVenta){
        appendChange(new PostVentaAsociada(idPostVenta)).apply();
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

    //Encontrar producto por id, no es comando
    public Optional<Producto>  getProductoPorId(IdProducto idProducto){
        return productos
                .stream()
                .filter(producto -> producto.identity().equals(idProducto))
                .findFirst();
    }


    public CanalVenta getCanalVenta() {
        return canalVenta;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
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
