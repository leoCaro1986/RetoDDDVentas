package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreProducto implements ValueObject<String> {
    private final String value;

    public NombreProducto(String value){
        this.value= Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El nombre del producto no puede estar vacio");
        }
    }
    public String value() {
        return  value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreProducto that = (NombreProducto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
