package net.squiddite.unitconverter;

public class ConversionFactory {
    public Unit convert( Unit u, String  e ) {
        Unit newUnit = null;

        switch( UnitEnum.valueOf( e ) ) {
            case FOOT:
                newUnit = new Foot();
                break;
            case METER:
                newUnit = new Meter();
                break;
        }


        return newUnit;
    }
}
