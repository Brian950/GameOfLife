package com.ohme.rule;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.rule.Rule;
import com.ohme.domain.rule.standard.StandardRule;
import com.ohme.service.factory.cell.standard.StandardCellFactory;
import com.ohme.util.CellState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StandardRuleTest {

    private final Rule STANDARD_RULE = new StandardRule();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void standardLivingCellBehaviourTest(int neighbours) {
        Cell standardCell = StandardCellFactory.getInstance().createCell();
        standardCell.setState(CellState.ALIVE);

        // Add the required number of living neighbours to the cell being tested
        for(int i = 0; i < neighbours; i++) {
            Cell aliveCell = StandardCellFactory.getInstance().createCell();
            aliveCell.setState(CellState.ALIVE);
            standardCell.addNeighbour(aliveCell);
        }

        CellState cellState = STANDARD_RULE.getCellState(standardCell);
        switch (neighbours) {
            case(1):
            case(4):
            case(5):
            case(6):
            case(7):
            case(8):
                Assertions.assertEquals(CellState.DEAD, cellState);
                break;
            case(2):
            case(3):
                Assertions.assertEquals(CellState.ALIVE, cellState);
                break;
        }
    }
};
