package com.ohme.service.executor.glider;

import com.ohme.domain.rule.Rule;
import com.ohme.domain.rule.standard.StandardRule;
import com.ohme.domain.universe.base.Universe;
import com.ohme.service.executor.UniverseExecutor;
import com.ohme.service.factory.universe.UniverseFactory;
import com.ohme.service.factory.universe.glider.GliderUniverseFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("glider")
public class GliderUniverseExecutor implements UniverseExecutor {

    private final int DIMENSION = 25;

    private final UniverseFactory GLIDER_UNIVERSE_FACTORY = GliderUniverseFactory.getInstance();

    private Universe universe = GLIDER_UNIVERSE_FACTORY.createUniverse(DIMENSION);

    private final Rule STANDARD_RULE = new StandardRule();

    @Override
    public Universe tick() {
        // A dummy universe is used as updating the original would affect the calculations of other cells
        Universe resultUniverse = GLIDER_UNIVERSE_FACTORY.createUniverse(DIMENSION);
        for(int i = 0; i < DIMENSION; i++) {
            for(int j = 0; j < DIMENSION; j++) {
                // Update the cell in the result universe that represents the expected change based on the Standard rules
                resultUniverse.getUniverse()[i][j].setState(STANDARD_RULE.getCellState(universe.getUniverse()[i][j]));
            }
        }
        universe = resultUniverse;
        return resultUniverse;
    }

    @Override
    public Universe getCurrentState() {
        return universe;
    }

    @Override
    public Universe reset() {
        universe = GLIDER_UNIVERSE_FACTORY.createUniverse(DIMENSION);
        return universe;
    }
}
