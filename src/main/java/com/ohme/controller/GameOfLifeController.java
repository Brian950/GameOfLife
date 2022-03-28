package com.ohme.controller;

import com.ohme.service.executor.UniverseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameOfLifeController {

    @Autowired
    @Qualifier("glider")
    private UniverseExecutor executor;

    /*
        Returns the current universe state
     */
    @GetMapping("/state")
    public String getGameState() {
        return executor.getCurrentState().toHtmlString();
    }

    /*
        Progresses the universe to the next generation
     */
    @GetMapping("/tick")
    public String nextTimeTick() {
        return executor.tick().toHtmlString();
    }

    /*
        Resets the universe back to its original state
     */
    @GetMapping("/reset")
    public String resetGameState() {
        return executor.reset().toHtmlString();
    }
}
