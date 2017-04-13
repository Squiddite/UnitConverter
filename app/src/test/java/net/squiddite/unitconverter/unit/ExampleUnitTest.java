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
    @Before
    public void setup() {
    }

    @Test
    public void inheritanceChain() {
        Unit foot = new Foot();
        assertThat( foot, instanceOf( Unit.class ));
        assertThat( foot, instanceOf( LengthUnit.class ));
    }

    @Test
    public void nullValueOnDefaultInstantiation() {
        Foot foot = new Foot();
        assertEquals( foot.value, null);
    }

    @Test
    public void correctValueOnValuedInstantiation() {
        Foot foot = new Foot( 5.0 );
        Double five = 5.0;

        assertThat( foot.value, not( equalTo( null )));
        assertThat( foot.value, equalTo( five ));
    }

    @Test
    public void expectedPropertiesOnInstantiation() {
        Foot foot = new Foot( 5.0 );

        assertThat( foot.value, equalTo( 5.0 ));
        assertThat( foot.isMetric, equalTo( false ));
        assertThat( foot.isBaseUnit, equalTo( false ));
        assertThat( foot.unit, equalTo( UnitEnum.FOOT.toString() ));
        assertThat( foot.unitClass, equalTo( UnitClassEnum.LENGTH.toString() ));
        assertThat( foot.baseUnit, equalTo( UnitEnum.METER.toString() ));
    }

    @Test
    public void newInstanceOverwrites() {
        Foot foot = new Foot( 5.0 );
        foot = new Foot( 13.0 );
        assertThat( foot.value, equalTo( 13.0 ));
    }

    @Test
    public void setter() {
        Foot foot = new Foot();
        Double five = 5.0;

        foot.set( five );
        assertThat( foot.value, equalTo( five ));

        foot = new Foot( five );
        foot.set( 13.0 );
        assertThat( foot.value, equalTo( 13.0 ));
    }

    @Test
    public void getters() {
        Foot foot = new Foot( 5.0 );

        assertThat( foot.get(), equalTo( foot.value ));
        assertThat( foot.isMetric(), equalTo( foot.isMetric ));
        assertThat( foot.isBaseUnit(), equalTo( foot.isBaseUnit ));
        assertThat( foot.getName(), equalTo( foot.unit ));
        assertThat( foot.unitClass(), equalTo( foot.unitClass ));
        // baseUnit?

    }

    @Test
    public void conversionInstances() {
        Foot foot = new Foot( 5.0 );

    }
}