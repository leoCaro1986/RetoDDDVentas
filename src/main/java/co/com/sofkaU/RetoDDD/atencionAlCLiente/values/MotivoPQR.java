package co.com.sofkaU.RetoDDD.atencionAlCLiente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MotivoPQR implements ValueObject<String> {

    private final String value;

    public MotivoPQR(String value){
        this.value= Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El motivo del PQR no puede estar vacio");
        }
        if (this.value.length()>=20){
            throw new IllegalArgumentException("EL motivo del PQR debe contener mas de 20 caracteres");
        }
    }

    public String value() {
        return  value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotivoPQR motivoPQR = (MotivoPQR) o;
        return Objects.equals(value, motivoPQR.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
