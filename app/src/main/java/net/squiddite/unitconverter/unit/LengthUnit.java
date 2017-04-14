package net.squiddite.unitconverter.unit;

abstract class LengthUnit extends Unit {
    public LengthUnit( Double v ) {
        super( v );

        this.unitClass = UnitClassEnum.LENGTH.toString();
        this.baseUnit = UnitEnum.METER.toString();

        this.memberUnits.add( UnitEnum.METER.toString() );
        this.memberUnits.add( UnitEnum.FOOT.toString() );
        this.memberUnits.add( UnitEnum.INCH.toString() );
        this.memberUnits.add( UnitEnum.MILE.toString() );
    }

    /**
     * Fast facades for in-type conversion, unique to this UnitClass
     *
     * @return Unit of the converted type and value
     */
    final public Foot toFeet() {
        return (Foot) this.convertTo( UnitEnum.FOOT.toString() );
    }

    final public Meter toMeters() {
        return (Meter) this.convertTo( UnitEnum.METER.toString() );
    }

    final public Inch toInches() {
        return (Inch) this.convertTo( UnitEnum.INCH.toString() );
    }

    final public Mile toMiles() {
        return (Mile) this.convertTo( UnitEnum.MILE.toString() );
    }

    /**
     * Get an instance of the type of unit you're performing a conversion into
     *
     * @param s Stringified value of a UnitEnum (belonging to the appropriate class)
     * @return Unit of the appropriate type
     */
    final protected Unit getClassForMemberUnit( String s ) {
        LengthUnit newUnit = null;
        UnitEnum m = UnitEnum.valueOf( s );

        // TODO: if s is not in-class (via this.memberUnits) then die gracefully

        switch( m ) {
            case FOOT:
                newUnit = new Foot();
                break;
            case METER:
                newUnit = new Meter();
                break;
            case INCH:
                newUnit = new Inch();
                break;
            case MILE:
                newUnit = new Mile();
                break;
        }

        return newUnit;
    }
}
