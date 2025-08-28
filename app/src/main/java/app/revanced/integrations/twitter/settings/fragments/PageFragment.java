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
        if (activity_name.equals(Settings.PREMIUM_SECTION.key)) {
            screenBuilder.buildPremiumSection(false);
            toolbarText = "piko_title_premium";
        }else if (activity_name.equals(Settings.DOWNLOAD_SECTION.key)) {
            screenBuilder.buildDownloadSection(false);
            toolbarText = "piko_title_download";
        }else if (activity_name.equals(Settings.FLAGS_SECTION.key)) {
            screenBuilder.buildFeatureFlagsSection(false);
            toolbarText = "piko_title_feature_flags";
        }else if (activity_name.equals(Settings.ADS_SECTION.key)) {
            screenBuilder.buildAdsSection(false);
            toolbarText = "piko_title_ads";
        }else if (activity_name.equals(Settings.MISC_SECTION.key)) {
            screenBuilder.buildMiscSection(false);
            toolbarText = "piko_title_misc";
        }else if (activity_name.equals(Settings.CUSTOMISE_SECTION.key)) {
            screenBuilder.buildCustomiseSection(false);
            toolbarText = "piko_title_customisation";
        }else if (activity_name.equals(Settings.TIMELINE_SECTION.key)) {
            screenBuilder.buildTimelineSection(false);
            toolbarText = "piko_title_timeline";
        }else if (activity_name.equals(Settings.BACKUP_SECTION.key)) {
            screenBuilder.buildExportSection(false);
            toolbarText = "piko_title_backup";
        }else if (activity_name.equals(Settings.NATIVE_SECTION.key)) {
            screenBuilder.buildNativeSection(false);
            toolbarText = "piko_title_native";
        }else if (activity_name.equals(Settings.LOGGING_SECTION.key)) {
            screenBuilder.buildLoggingSection(false);
            toolbarText = "piko_title_logging";
        }

        ActivityHook.toolbar.setTitle(StringRef.str(toolbarText));
//        setSupportActionBar(ActivityHook.toolbar);
        setPreferenceScreen(screen);

    }

}