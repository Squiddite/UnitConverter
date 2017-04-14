package net.squiddite.unitconverter.unit;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Unit foot, meter;
    final private Double fivePointTwo = 5.2, negativeFive = -5.0;
    final private Integer three = 3;

    @Before
    public void setup() {
        this.foot = new Foot();
        this.meter = new Meter( this.fivePointTwo );
    }

    @Test
    public void inheritanceChain() {
        assertThat( this.foot, instanceOf( Unit.class ));
        assertThat( this.foot, instanceOf( LengthUnit.class ));
        assertThat( this.meter, instanceOf( Unit.class ));
        assertThat( this.meter, instanceOf( LengthUnit.class ));
    }

    @Test
    public void expectedSetProperties() {
        assertThat( this.foot.value, equalTo( null ));
        assertThat( this.meter.value, equalTo( this.fivePointTwo ));
    }

    @Test
    public void expectedInheritedProperties() {
        assertThat( this.foot.isMetric, equalTo( false ));
        assertThat( this.foot.isBaseUnit, equalTo( false ));
        assertThat( this.foot.unit, equalTo( UnitEnum.FOOT.toString() ));
        assertThat( this.foot.unitClass, equalTo( UnitClassEnum.LENGTH.toString() ));
        assertThat( this.foot.baseUnit, equalTo( UnitEnum.METER.toString() ));

        assertThat( this.meter.isMetric, equalTo( true ));
        assertThat( this.meter.isBaseUnit, equalTo( true ));
        assertThat( this.meter.unit, equalTo( UnitEnum.METER.toString() ));
        assertThat( this.meter.unitClass, equalTo( UnitClassEnum.LENGTH.toString() ));
        assertThat( this.meter.baseUnit, equalTo( UnitEnum.METER.toString() ));
    }

    @Test
    public void getters() {
        assertThat( this.foot.get(), equalTo( this.foot.value ));
        assertThat( this.foot.isMetric(), equalTo( this.foot.isMetric ));
        assertThat( this.foot.isBaseUnit(), equalTo( this.foot.isBaseUnit ));
        assertThat( this.foot.getName(), equalTo( this.foot.unit ));
        assertThat( this.foot.unitClass(), equalTo( this.foot.unitClass ));
        // no current baseUnit getter?

        assertThat( this.meter.get(), equalTo( this.meter.value ));
    }

    @Test
    public void setter() {
        this.foot.set( this.fivePointTwo );
        assertThat( this.foot.get(), equalTo( 5.2 ));

        this.foot.set( this.three );
        assertThat( this.foot.get(), equalTo( 3.0 ));

        this.foot.set( null );
        assertThat( this.foot.get(), equalTo( null ));

        this.foot.set( this.negativeFive );
        assertThat( this.foot.get(), equalTo( -5.0 ));
    }

    @Test
    public void conversionFactory() {

    }
}