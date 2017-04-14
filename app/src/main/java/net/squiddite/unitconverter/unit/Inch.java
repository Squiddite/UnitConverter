package net.squiddite.unitconverter.unit;

public class Inch extends LengthUnit {
    public Inch( Double v ) {
        super( v );

        this.unit = UnitEnum.INCH.toString();
        this.isBaseUnit = false;
        this.isMetric = false;

        this.conversionFactor = 39.37008;
    }
    public Inch() {
        this( null );
    }
}
