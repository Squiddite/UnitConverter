package net.squiddite.unitconverter;

// https://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/
public enum UnitClassEnum {
    LENGTH("Length"),
    WEIGHT("Weight"),
    VOLUME("Volume"),
    TIME("Time"),
    SPEED("Speed");

    private String value;
    private UnitClassEnum( String value ) {
        this.value = value;
    }
}
