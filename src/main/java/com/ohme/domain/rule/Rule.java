package com.ohme.domain.rule;

import com.ohme.domain.cell.base.Cell;
import com.ohme.util.CellState;

public interface Rule {

    CellState getCellState(Cell cell);

}
