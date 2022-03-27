package com.ohme.service.factory.universe;

import com.ohme.domain.universe.base.Universe;

public interface UniverseFactory {

    Universe createUniverse(int dimension);

}
