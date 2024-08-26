package com.mate_matcher.storage;


import java.io.IOException;

public interface HouseStore {
    void addHouse(DtfHouse house) throws IOException;

    HouseStore getHouse(String houseId) throws IOException;
}
