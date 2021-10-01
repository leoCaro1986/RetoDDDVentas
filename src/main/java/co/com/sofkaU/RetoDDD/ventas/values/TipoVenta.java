package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoVenta implements ValueObject<String> {
    private final String value;

    public TipoVenta(String value){
        this.value= Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El tipo de venta no puede estar vacio");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoVenta tipoVenta = (TipoVenta) o;
        return Objects.equals(value, tipoVenta.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
