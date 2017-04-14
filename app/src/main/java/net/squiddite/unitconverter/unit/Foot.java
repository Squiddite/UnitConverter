package net.squiddite.unitconverter.unit;

public class Foot extends LengthUnit {
    public Foot( Double v ) {
        super( v );

        this.unit = UnitEnum.FOOT.toString();
        this.isBaseUnit = false;
        this.isMetric = false;

        this.conversionFactor = 3.28084;
    }

    public Foot() {
        this( null );
    }
}