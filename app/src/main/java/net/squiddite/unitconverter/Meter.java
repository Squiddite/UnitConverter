package net.squiddite.unitconverter;

class Meter extends LengthUnit {
    public Meter( Double v ) {
        super( v );

        this.unit = UnitEnum.METER.toString();
        this.isBaseUnit = true;
        this.isMetric = true;
    }
    public Meter() {
        this( null );
    }
}
