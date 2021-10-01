package co.com.sofkaU.RetoDDD.atencionAlCLiente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeAsesoria implements ValueObject<String> {

    private final String value;

    public TipoDeAsesoria(String value){
        this.value= Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El tipo de producto no puede estar vacio");
        }
    }

    public String value() {
        return  value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDeAsesoria that = (TipoDeAsesoria) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
