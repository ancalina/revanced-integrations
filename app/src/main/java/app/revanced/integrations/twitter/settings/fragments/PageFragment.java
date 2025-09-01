package app.revanced.integrations.twitter.settings.fragments;

import app.revanced.integrations.shared.StringRef;
import android.content.Context;
import android.os.Bundle;
import android.preference.*;
import androidx.annotation.Nullable;
import app.revanced.integrations.shared.Utils;
import app.revanced.integrations.twitter.settings.widgets.Helper;
import app.revanced.integrations.twitter.settings.ScreenBuilder;
import app.revanced.integrations.twitter.settings.Settings;
import app.revanced.integrations.twitter.settings.ActivityHook;
import app.revanced.integrations.twitter.settings.SettingsStatus;
//import android.content.Intent;

@SuppressWarnings("deprecation")
public class PageFragment extends PreferenceFragment {
    private Context context;

//    @Override
//    public void onResume() {
//        super.onResume();
//        ActivityHook.toolbar.setTitle(StringRef.str("piko_title_settings"));
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        String toolbarText = "piko_title_settings";

        PreferenceManager preferenceManager = getPreferenceManager();
        PreferenceScreen screen = preferenceManager.createPreferenceScreen(context);
        preferenceManager.setSharedPreferencesName(Settings.SHARED_PREF_NAME);

        Helper helper = new Helper(context);
        ScreenBuilder screenBuilder = new ScreenBuilder(context, screen, helper);

        Bundle bundle = getArguments();
        String activity_name = bundle != null ? bundle.getString(Settings.ACT_NAME) : null;

//        setSupportActionBar(ActivityHook.toolbar);
        setPreferenceScreen(screen);

    }

}