package com.mate_matcher.storage;

import java.util.List;
import java.util.Map;

public class DtfUser {

    public String userId;
    public String name;
    public String email;
    public boolean ownsHouse;
    public String houseId;
    public int age;
    public String gender;
    public boolean isSmoker;
    public boolean isAlcoholic;
    public int monthlyExpectedExpenditure;
    public String currentAddress;
    public String locality;
    public SocialMediaDetails socials;
    public List<String> hobbies;
    public Requirements requirements;

    public static class SocialMediaDetails {
        public String source;
        public String url;
    }

    public static class Requirements {
        public boolean findFlat;
        public boolean findFlatmate;
        public String locality;
        public String alcoholTolerance;
        public String smokeTolerance;
        public String noiseTolerance;
        public int maxDistance;
    }
}
