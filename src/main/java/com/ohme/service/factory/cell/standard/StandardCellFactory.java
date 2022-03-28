package com.ohme.service.factory.cell.standard;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.cell.standard.StandardCell;
import com.ohme.service.factory.cell.CellFactory;
import com.ohme.service.factory.universe.UniverseFactory;
import com.ohme.service.factory.universe.glider.GliderUniverseFactory;

public class StandardCellFactory implements CellFactory {

    private static CellFactory INSTANCE;

    private StandardCellFactory(){}

    public static CellFactory getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new StandardCellFactory();
        }
        return INSTANCE;
    }

    @Override
    public Cell createCell() {
        return new StandardCell();
    }
}
