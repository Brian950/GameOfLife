package com.ohme.domain.universe.glider;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.universe.base.Universe;

public class GliderUniverse extends Universe {

    private GliderUniverse(int dimension) {
        this.dimension = dimension;
        buildUniverse(dimension);
    }

    public static GliderUniverse getInstance(int dimension) {
        return new GliderUniverse(dimension);
    }

    @Override
    protected void buildUniverse(int dimension) {
        universe = new Cell[dimension][dimension];
        applyGliderPatternToUniverse();
    }

    /*
        Glider pattern -> c = center point, x = active cells
        [ ][ ][ ][ ][ ]
        [ ][ ][x][ ][ ]
        [ ][ ][c][x][ ]
        [ ][x][x][x][ ]
        [ ][ ][ ][ ][ ]
     */
    private void applyGliderPatternToUniverse() {
        int centerPoint = dimension / 2;
        //universe[centerPoint][centerPoint]
    }
}
