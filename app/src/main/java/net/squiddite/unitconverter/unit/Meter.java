package net.squiddite.unitconverter.unit;

public class Meter extends LengthUnit {
    public Meter( Double v ) {
        super( v );

        this.unit = UnitEnum.METER.toString();
        this.isBaseUnit = true;
        this.isMetric = true;

        this.conversionFactor = 1.0;
    }

    public Meter() {
        this( null );
    }
}
