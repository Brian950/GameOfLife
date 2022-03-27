package com.ohme.domain.cell.base;

import com.ohme.domain.rule.Rule;
import com.ohme.util.CellState;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Cell {

    protected CellState state;

    private List<Cell> neighbours;

    public void addNeighbour(Cell neighbour) {
        neighbours.add(neighbour);
    }

    public boolean isAlive() {
        return state.equals(CellState.ALIVE);
    }

}
