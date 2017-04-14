package net.squiddite.unitconverter.unit;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Unit {
    protected String unit;
    protected Double value;

    protected String unitClass;
    protected String baseUnit;
    protected Boolean isMetric;

    protected Boolean isBaseUnit;
    protected Double conversionFactor;

    protected ArrayList<String> memberUnits;

    public Unit( Double v ) {
        this.unit = null;
        this.value = null;
        this.isBaseUnit = null;
        this.unitClass = null;
        this.baseUnit = null;
        this.isMetric = null;
        this.conversionFactor = null;
        this.memberUnits = new ArrayList<String>();

        this.set( v );
    }
    public Unit() {
        this( null );
    }

    public String getName() {
        return unit;
    }

    public String unitClass() {
        return unitClass;
    }

    public Boolean isMetric() {
        return isMetric;
    }

    public Boolean isBaseUnit() {
        return this.isBaseUnit;
    }

    public Double getConversionFactorToBase() {
        return ( 1 / this.conversionFactor );
    }

    public Double getConversionFactorFromBase() {
        return this.conversionFactor;
    }

    public Double get() {
        return this.value;
    }

    // TODO: manage the explicit Double requirement down to a more generic Number if possible
    public void set( Number v ) {
        if( v != null ) {
            this.value = v.doubleValue();
        } else {
            this.value = null;
        }
    }

    public Unit convertTo( String newUnit ) {
        Unit convertedUnit;
        Unit baseUnit;
        Double newValue;

        // TODO: de-dupe this redundant logic
        if( !this.isBaseUnit() ) {
            baseUnit = getClassForMemberUnit( this.baseUnit );
            //newValue = this.get() * ( 1 / baseUnit.getConversionFactorForUnit( this.getName() ));
            newValue = this.get() * this.getConversionFactorToBase();
            baseUnit.set( newValue );
        } else {
            baseUnit = this;
        }

        if( baseUnit.getName() != newUnit ) {
            convertedUnit = getClassForMemberUnit( newUnit );
            //newValue = baseUnit.get() * baseUnit.getConversionFactorForUnit( newUnit );
            newValue = baseUnit.get() * convertedUnit.getConversionFactorFromBase();
            convertedUnit.set( newValue );
        } else {
            convertedUnit = baseUnit;
        }

        return convertedUnit;
    }

    public Boolean isClassMember( String unit ) {
        Boolean found = false;

        try {
            UnitEnum.valueOf( unit );
        } catch( Exception e ) {
            return false;
        }

        if( memberUnits.contains( unit )) {
            found = true;
        }

        return found;
    }

    // TODO: this function name is awful
    abstract protected Unit getClassForMemberUnit( String s );
}
