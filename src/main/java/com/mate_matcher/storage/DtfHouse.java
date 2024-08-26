package com.mate_matcher.storage;

import java.util.List;

public class DtfHouse {
    public String houseId;
    public String address;
    public String locality;
    public String houseType;
    public boolean hasPool;
    public boolean hasSecurity;
    public boolean hasBackupElectricity;
    public boolean hasLift;
    public int floorCount;
    public List<Integer> currentOccupants;
    public List<Room> rooms;
    public int floorArea;
    public boolean isFurnished;
    public List<String> amenities;
    public List<String> landmarks;

    public static class Room {
        public int roomId;
        public boolean hasWashroom;
        public boolean hasWindow;
        public boolean hasAC;
        public boolean isAvailable;
    }
}

