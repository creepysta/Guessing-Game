package com.sam.guessinggame;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmInitialization extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
