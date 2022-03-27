package com.ohme.domain.cell.standard;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.rule.Rule;
import com.ohme.util.CellState;

import java.util.ArrayList;

public class StandardCell extends Cell {

    public StandardCell() {
        state = CellState.DEAD;
        setNeighbours(new ArrayList<>());
    }

}
