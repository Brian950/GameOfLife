package com.ohme.domain.universe.glider;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.universe.base.Universe;
import com.ohme.service.factory.cell.CellFactory;
import com.ohme.service.factory.cell.standard.StandardCellFactory;
import com.ohme.util.CellState;

public class GliderUniverse extends Universe {

    private final CellFactory standardCellFactory = new StandardCellFactory();

    public GliderUniverse(int dimension) {
        this.dimension = dimension;
        buildUniverse(dimension);
    }

    // Create an empty universe of dead standard cells
    @Override
    protected void buildUniverse(int dimension) {
        universe = new Cell[dimension][dimension];
        // Create the cells & initialise the universe array
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                universe[i][j] = standardCellFactory.createCell();
            }
        }
        // Set the neighbours for each cell
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i > 0)
                    universe[i - 1][j].addNeighbour(universe[i][j]);
                if (j > 0)
                    universe[i][j - 1].addNeighbour(universe[i][j]);
                if (i > 0 && j > 0)
                    universe[i - 1][j - 1].addNeighbour(universe[i][j]);
                if (i < dimension - 1)
                    universe[i + 1][j].addNeighbour(universe[i][j]);
                if (j < dimension - 1)
                    universe[i][j + 1].addNeighbour(universe[i][j]);
                if (i < dimension - 1 && j < dimension - 1)
                    universe[i + 1][j + 1].addNeighbour(universe[i][j]);
                if (i < dimension - 1 && j > 0)
                    universe[i + 1][j - 1].addNeighbour(universe[i][j]);
                if (i > 0 && j < dimension - 1)
                    universe[i - 1][j + 1].addNeighbour(universe[i][j]);
            }
        }
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
        universe[centerPoint - 1][centerPoint].setState(CellState.ALIVE);
        universe[centerPoint][centerPoint + 1].setState(CellState.ALIVE);
        universe[centerPoint + 1][centerPoint + 1].setState(CellState.ALIVE);
        universe[centerPoint + 1][centerPoint].setState(CellState.ALIVE);
        universe[centerPoint + 1][centerPoint - 1].setState(CellState.ALIVE);
    }
}
