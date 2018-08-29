package net.ramastudio.sitara20;

import android.app.Application;

import net.ramastudio.sitara20.utils.Pref;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Pref.init(this);
    }
}
