package com.ohme.domain.cell.base;

import com.ohme.domain.rule.Rule;
import com.ohme.util.CellState;

import java.util.List;

public abstract class Cell {

    protected CellState state;

    private List<Cell> neighbours;

    protected abstract void recalculateState(Rule rule);

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public List<Cell> getNeighbours() {
        return neighbours;
    }
}
