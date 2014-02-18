package com.tw.uno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Random {
    List list;

    public Random(List list) {
        this.list = list;
    }

    public List shuffleCards(){
        List<Object> result = new ArrayList<>();
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
