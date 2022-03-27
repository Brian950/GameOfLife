package com.ohme.domain.universe.base;

import com.ohme.domain.cell.base.Cell;

public abstract class Universe {

    protected int dimension;

    // Using a boolean[][] array will default all values to false
    protected Cell[][] universe;

    protected abstract void buildUniverse(int dimension);

    public Cell[][] getUniverse() {
        return universe;
    }

}
