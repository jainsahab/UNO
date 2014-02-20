package com.step.uno.client;

import com.step.uno.messages.Snapshot;

public interface GameClientObserver {
    void update(Snapshot message);
}
