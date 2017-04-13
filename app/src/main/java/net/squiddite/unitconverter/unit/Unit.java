package net.squiddite.unitconverter.unit;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Unit {
    protected String unit;
    protected Double value;
    protected Boolean isBaseUnit;

    protected String unitClass;
    protected String baseUnit;
    protected ArrayList<String> memberUnits;
    protected Boolean isMetric;

    protected HashMap<String, Double> conversionFactors;

    public Unit( Double v ) {
        this.unit = null;
        this.value = null;
        this.isBaseUnit = null;
        this.unitClass = null;
        this.baseUnit = null;
        this.isMetric = null;
        this.memberUnits = new ArrayList<String>();
        this.conversionFactors = new HashMap<String, Double>();

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

    public HashMap<String, Double> getConversionFactors() {
        return this.conversionFactors;
    }

    public Double getConversionFactorForUnit( String unit ) {
        return this.conversionFactors.get( unit );
    }

    public Double get() {
        return this.value;
    }

    // TODO: manage the explicit Double requirement down to a more generic Number if possible
    public void set( Double v ) {
        this.value = v;
    }

    public Unit convertTo( String newUnit ) {
        Unit convertedUnit;
        Unit baseUnit;
        Double newValue;

        // TODO: de-dupe this redundant logic
        if( !this.isBaseUnit() ) {
            baseUnit = getClassForMemberUnit( this.baseUnit );
            newValue = this.get() * ( 1 / baseUnit.getConversionFactorForUnit( this.getName() ));
            baseUnit.set( newValue );
        } else {
            baseUnit = this;
        }

        if( baseUnit.getName() != newUnit ) {
            convertedUnit = getClassForMemberUnit( newUnit );
            newValue = baseUnit.get() * baseUnit.getConversionFactorForUnit( newUnit );
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
