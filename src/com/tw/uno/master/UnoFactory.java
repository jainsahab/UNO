package com.tw.uno.master;

import com.step.communication.channel.MessageChannel;
import com.step.communication.factory.CommunicationFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;

public class UnoFactory {

    public final CommunicationFactory communication = new CommunicationFactory();
}
