package com.mate_matcher.storage;


import java.io.IOException;

public interface LoginInfoStore {
    void addUserLogin(DtfLogin user) throws IOException;

    LoginInfoStore getUserLoginInfo(String userId, String password) throws IOException;
}
