package com.example.smarttravel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class LoginManager {

    public static final String USERS = "users";

    public void register(String username, String pass, Context context) {
        String hash = md5(username + pass);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> users = sharedPreferences.getStringSet(USERS, new HashSet<>());
        if (users == null) {
            users = new HashSet<>();
        }

        Set<String> newSet = new HashSet<>(users);
        if (users.contains(hash)) {
            Toast.makeText(context, "Already registered", Toast.LENGTH_SHORT).show();
        }

        newSet.add(hash);
        sharedPreferences.edit().putStringSet(USERS, newSet).apply();
    }

    public boolean login(String username, String pass, Context context) {
        String hash = md5(username + pass);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> users = sharedPreferences.getStringSet(USERS, new HashSet<>());
        if (users == null) {
            users = new HashSet<>();
        }

        return users.contains(hash);
    }

    private String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
