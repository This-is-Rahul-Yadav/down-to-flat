package com.mate_matcher.storage;

import java.io.IOException;

public interface UserStore {
    void addUser(DtfUser user) throws IOException;

    DtfUser getUser(String userId) throws IOException;
}
