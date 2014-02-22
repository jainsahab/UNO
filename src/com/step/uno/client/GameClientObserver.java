package com.step.uno.client;

import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;

public interface GameClientObserver {
    void update(Snapshot snapshot);

    void onGameOver(GameResult result);
}
