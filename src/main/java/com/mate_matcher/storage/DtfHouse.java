package com.mate_matcher.storage;

import java.util.List;


public class DtfHouse {
    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean isHasSecurity() {
        return hasSecurity;
    }

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public boolean isHasBackupElectricity() {
        return hasBackupElectricity;
    }

    public void setHasBackupElectricity(boolean hasBackupElectricity) {
        this.hasBackupElectricity = hasBackupElectricity;
    }

    public boolean isHasLift() {
        return hasLift;
    }

    public void setHasLift(boolean hasLift) {
        this.hasLift = hasLift;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public List<Integer> getCurrentOccupants() {
        return currentOccupants;
    }

    public void setCurrentOccupants(List<Integer> currentOccupants) {
        this.currentOccupants = currentOccupants;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public int getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(int floorArea) {
        this.floorArea = floorArea;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public void setFurnished(boolean furnished) {
        isFurnished = furnished;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public List<String> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<String> landmarks) {
        this.landmarks = landmarks;
    }

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

