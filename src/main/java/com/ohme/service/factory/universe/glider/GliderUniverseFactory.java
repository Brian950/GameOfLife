package com.ohme.service.factory.universe.glider;

import com.ohme.domain.universe.base.Universe;
import com.ohme.domain.universe.glider.GliderUniverse;
import com.ohme.service.factory.universe.UniverseFactory;

public class GliderUniverseFactory implements UniverseFactory {

    @Override
    public Universe createUniverse(int dimension) {
        return new GliderUniverse(dimension);
    }
}
