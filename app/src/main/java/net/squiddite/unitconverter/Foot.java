package net.squiddite.unitconverter;

class Foot extends LengthUnit {
    public Foot( Double v ) {
        super( v );

        this.unit = UnitEnum.FOOT.toString();
        this.isBaseUnit = false;
        this.isMetric = false;
    }
    public Foot() {
        this( null );
    }
}

// 0.3048
// 3.28084