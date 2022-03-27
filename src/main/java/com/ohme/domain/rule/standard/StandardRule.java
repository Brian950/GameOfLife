package com.ohme.domain.rule.standard;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.rule.Rule;
import com.ohme.util.CellState;

public class StandardRule implements Rule {

    private final int LIVE_NEIGHBOURS_TO_STAY_ALIVE = 2;
    private final int MINIMUM_LIVE_NEIGHBOURS_TO_DIE = 4;
    private final int LIVE_NEIGHBOURS_TO_BECOME_ALIVE = 3;

    @Override
    public CellState getCellState(Cell cell) {
        int countOfLiveNeighbours = 0;
        for(Cell c : cell.getNeighbours()) {
            if(c.getState().equals(CellState.ALIVE)) countOfLiveNeighbours++;
        }

        // Check the current live neighbours against the cell and see if the cell will be alive or dead
        if(cell.getState().equals(CellState.ALIVE)) {
            if(countOfLiveNeighbours < LIVE_NEIGHBOURS_TO_STAY_ALIVE
                    || countOfLiveNeighbours >= MINIMUM_LIVE_NEIGHBOURS_TO_DIE) {
                return CellState.DEAD;
            }
            return CellState.ALIVE;
        } else {
            if(LIVE_NEIGHBOURS_TO_BECOME_ALIVE == 3) {
                return CellState.ALIVE;
            }
            return CellState.DEAD;
        }
    }
}
