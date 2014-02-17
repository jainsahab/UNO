package com.tw.uno;

import java.util.ArrayList;
import java.util.List;

public class Randomizer {
    List list;

    public Randomizer(List list) {
        this.list = list;
    }

    public List shuffle(){
        List<Object> result = new ArrayList();
        int limit = this.list.size()-1;
        int count = limit+1;
        for(int i = 0 ; i < count ; i++){
            int retrieveNumber = (int) (Math.random()*limit--);
            result.add(this.list.get(retrieveNumber));
            this.list.remove(retrieveNumber);
        }
        return result;
    }

}
