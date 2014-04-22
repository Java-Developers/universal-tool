package com.tps.universal.spring;

import java.util.List;

/**
 * Created by Junior on 4/22/14.
 */
public class Foo {

    private int id;


    public void setId(int id) {
        this.id = id;
    }

    private List<Bar> bars;

    public Foo() {

    }

    public void Foo(List<Bar> bars) {
        this.bars = bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public List<Bar> getBars() {
        return bars;
    }
}
