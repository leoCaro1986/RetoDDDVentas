package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkaU.RetoDDD.ventas.events.VentaCreada;
import co.com.sofkaU.RetoDDD.ventas.values.CanalVenta;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.TipoVenta;

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
}
