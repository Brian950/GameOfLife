package com.ohme.service.executor;

import com.ohme.domain.universe.base.Universe;

public interface UniverseExecutor {

    Universe tick();

    Universe getCurrentState();

    Universe reset();

}
