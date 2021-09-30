package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkaU.RetoDDD.ventas.events.*;

import java.util.HashSet;

public class VentasChange extends EventChange {
    public VentasChange(Ventas ventas) {
        apply((VentaCreada event) ->{
            ventas.canalVenta =event.getCanalVenta();
            ventas.tipoVenta = event.getTipoVenta();
            ventas.productos = new HashSet<>();
        });

        apply((PostVentaAsociada event)->{
            ventas.idPostVenta = event.getIdPostVenta();
        });

        apply((PedidoAgregado event) ->{
            ventas.pedido = new Pedido(event.getIdPedido(), event.getNombrePedido(), event.getDescripcionPedido());
        });

        apply((FacturaAgregada event) ->{
            ventas.factura = new Factura(event.getIdFactura(), event.getFechaFactura(), event.getPrecio());
        });

        apply((ProductoAgregado event)->{
            ventas.productos.add( new Producto(event.getIdProducto(), event.getNombreProducto()));
        });

        apply((NombreProductoActualizado event) ->{
            var producto= ventas.getProductoPorId(event.getIdProducto())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el producto"));
            producto.actualizarNombreProducto(event.getNombreProducto());
        });

        apply((PrecioActualizado event) -> {
           ventas.factura.actualizarPrecio(event.getPrecio());
        });

        apply((DescripcionDePedidoActualizado event)->{
            ventas.pedido.actualizarDescripcion(event.getDescripcionPedido());
        });
    }
}
