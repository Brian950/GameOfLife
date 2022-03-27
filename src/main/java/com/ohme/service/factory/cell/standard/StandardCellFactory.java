package com.ohme.service.factory.cell.standard;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.cell.standard.StandardCell;
import com.ohme.service.factory.cell.CellFactory;

public class StandardCellFactory implements CellFactory {

    @Override
    public Cell createCell() {
        return new StandardCell();
    }
}
