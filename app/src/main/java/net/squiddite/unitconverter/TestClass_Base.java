package net.squiddite.unitconverter;

public class TestClass_Base {
    protected Integer value;
    protected String name = null;

    public TestClass_Base() {
        name = null;
    }

    public void set( Integer v ) {
        value = v;
    }

    public Integer get() {
        return value;
    }

    public String getName() {
        return name;
    }

    protected void setName( String n ) {
        name = n;
    }
}
