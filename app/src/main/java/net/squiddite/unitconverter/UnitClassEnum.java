package net.squiddite.unitconverter;

// https://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/
public enum UnitClassEnum {
    LENGTH(1),
    WEIGHT(2),
    VOLUME(3),
    TIME(4);

    private int value;
    private UnitClassEnum( int value ) {
        this.value = value;
    }
}
