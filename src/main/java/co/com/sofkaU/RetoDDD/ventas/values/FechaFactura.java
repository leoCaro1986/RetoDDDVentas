package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaFactura implements ValueObject<String> {

    private final String value;

    public FechaFactura(String value){
        this.value= Objects.requireNonNull(value);
        if (this.value.toString().isBlank()){
            throw new IllegalArgumentException("La fecha de la factura no puede estar vacia");
        }
    }

    public String value() {
        return  value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaFactura that = (FechaFactura) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
