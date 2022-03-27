package com.ohme.domain.cell.standard;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.rule.Rule;

public class StandardCell extends Cell {

    @Override
    protected void recalculateState(Rule rule) {
        state = rule.getCellState(this);
    }
}
