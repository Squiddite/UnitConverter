package net.squiddite.unitconverter.unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum UnitEnum {
    FOOT("Foot"),
    METER("Meter"),
    INCH("Inch"),
    MILE("Mile"),
    POUND("Pound"),
    KILOGRAM("Kilogram");

    private final String value;

    // http://stackoverflow.com/questions/32089114/how-to-store-value-of-enum-in-arraylist
    private static final List<String> values;
    static {
        values = new ArrayList<>();
        for( UnitEnum unitEnum : UnitEnum.values() ) {
            values.add( unitEnum.value );
        }
    }

    private UnitEnum( String value ) {
        this.value = value;
    }
    public static List<String> getValues() {
        return Collections.unmodifiableList( values );
    }
}
