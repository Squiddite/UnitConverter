package net.squiddite.unitconverter;

public interface Convertible {
    public Unit convertTo( UnitClassEnum e );
    public Unit convertFrom( Unit u );
}
