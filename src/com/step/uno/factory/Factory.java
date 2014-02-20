package com.step.uno.factory;

import com.step.communication.factory.CommunicationFactory;

public class Factory{
    public final CommunicationFactory communication ;

    public Factory() {
        communication = new CommunicationFactory();
    }
}
