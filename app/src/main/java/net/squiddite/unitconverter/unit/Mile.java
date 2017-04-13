package net.squiddite.unitconverter.unit;

public class Mile extends LengthUnit {
    public Mile( Double v ) {
        super( v );

        this.unit = UnitEnum.INCH.toString();
        this.isBaseUnit = false;
        this.isMetric = false;
    }
    public Mile() {
        this( null );
    }
}
