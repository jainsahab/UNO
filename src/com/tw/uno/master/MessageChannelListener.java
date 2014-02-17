package com.tw.uno.master;

public interface MessageChannelListener {
    void onMessage(MessageChannel messageChannel, Object o);

    void onConnectionClosed(MessageChannel messageChannel);

    void onError(MessageChannel messageChannel, Exception e);
}
