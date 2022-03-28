package com.ohme.service.executor;

import com.ohme.domain.cell.base.Cell;
import com.ohme.domain.universe.base.Universe;
import com.ohme.domain.universe.glider.GliderUniverse;
import com.ohme.util.CellState;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GliderUniverseExecutorIntegrationTest {

    @Autowired
    @Qualifier("glider")
    private UniverseExecutor gliderUniverseExecutor;

    private final int DIMENSION = 25;

    private final Universe universe = new GliderUniverse(DIMENSION);

    @Test
    @Order(1)
    void getCurrentStateTest() {
        Universe u = gliderUniverseExecutor.getCurrentState();
        Assertions.assertEquals(universe, u);
    }

    @Test
    @Order(2)
    void firstTickTest() {
        Universe u = gliderUniverseExecutor.tick();
        simulateFirstTick();
        Assertions.assertEquals(universe, u);
    }

    @Test
    @Order(3)
    void resetTest() {
        Universe u = gliderUniverseExecutor.reset();
        simulateReset();
        Assertions.assertEquals(universe, u);
    }

    private void simulateFirstTick() {
        Cell[][] cells = universe.getUniverse();
        int centerPoint = DIMENSION / 2;
        // These cells would die
        cells[centerPoint - 1][centerPoint].setState(CellState.DEAD);
        cells[centerPoint + 1][centerPoint - 1].setState(CellState.DEAD);
        // These remain alive
        cells[centerPoint + 1][centerPoint].setState(CellState.ALIVE);
        cells[centerPoint][centerPoint + 1].setState(CellState.ALIVE);
        cells[centerPoint + 1][centerPoint + 1].setState(CellState.ALIVE);
        // These become alive
        cells[centerPoint][centerPoint - 1].setState(CellState.ALIVE);
        cells[centerPoint + 2][centerPoint].setState(CellState.ALIVE);
    }

    private void simulateReset() {
        Cell[][] cells = universe.getUniverse();
        int centerPoint = DIMENSION / 2;
        // Reset these
        cells[centerPoint - 1][centerPoint].setState(CellState.ALIVE);
        cells[centerPoint + 1][centerPoint - 1].setState(CellState.ALIVE);
        // These remain alive
        cells[centerPoint + 1][centerPoint].setState(CellState.ALIVE);
        cells[centerPoint][centerPoint + 1].setState(CellState.ALIVE);
        cells[centerPoint + 1][centerPoint + 1].setState(CellState.ALIVE);
        // Reset these
        cells[centerPoint][centerPoint - 1].setState(CellState.DEAD);
        cells[centerPoint + 2][centerPoint].setState(CellState.DEAD);
    }

}
