package com.tps.universal.spring;

/**
 * Created by Junior on 4/22/14.
 */
public class Bar {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private Baz baz;

    public Baz getBaz() {
        return baz;
    }

    public void setBaz(Baz baz) {
        this.baz = baz;
    }
}
