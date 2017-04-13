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

        this.conversionFactors.put( UnitEnum.METER.toString(), (Double) 1.0 );
        this.conversionFactors.put( UnitEnum.FOOT.toString(), (Double) 3.28084 );
        this.conversionFactors.put( UnitEnum.INCH.toString(), (Double) 39.37008 );
        this.conversionFactors.put( UnitEnum.MILE.toString(), (Double) 0.000621371 );

    }

    /*
    public LengthUnit() {
        this( null );
    }
    */

    final protected Unit getClassForMemberUnit( String s ) {
        LengthUnit newUnit = null;
        UnitEnum m = UnitEnum.valueOf( s );

        switch( m ) {
            case FOOT:
                newUnit = (Foot) new Foot();
                break;
            case METER:
                newUnit = (Meter) new Meter();
                break;
            case INCH:
                newUnit = (Inch) new Inch();
                break;
            case MILE:
                newUnit = (Mile) new Mile();
                break;
        }

        return newUnit;
    }
}
