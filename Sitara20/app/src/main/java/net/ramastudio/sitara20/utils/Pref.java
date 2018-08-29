package net.ramastudio.sitara20.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import net.ramastudio.sitara20.model.Session;

public class Pref {
    public static Context context;
    public static SharedPreferences sp;
    public static SharedPreferences.Editor editor;
    public static final String SP_NAME = "pref.default";

    public static void init(Context context) {
        Pref.context = context;
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public static void put(Class clazz, Object data) {
        editor.putString(clazz.getName(), new Gson().toJson(data));
        editor.commit();
    }

    public static <T> T get(Class<T> clazz) {
        return new Gson().fromJson(sp.getString(clazz.getName(), null), clazz);
    }

    public static Session getSession(){
        return get(Session.class);
    }

    public static void deleteSession(){
        editor.remove(Session.class.getName());
        editor.commit();
    }
}
