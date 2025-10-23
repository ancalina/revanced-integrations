package app.revanced.integrations.twitter.hooks;

import android.util.Log;
import android.content.Context;
import app.revanced.integrations.shared.Utils;


public final class RefreshHooks {

    private static volatile boolean pullSoundPlayed = false;
    private static volatile float pullAccumPx = 0f;
    private static final float PULL_THRESHOLD_PX = 6.0f;

    private static final boolean DEBUG = false;

    public static void onPull(float delta) {

        if (delta > 0f) {
            pullAccumPx += delta;
            if (!pullSoundPlayed && pullAccumPx >= PULL_THRESHOLD_PX) {
                pullSoundPlayed = true;
                try {
                    Context ctx = Utils.getContext();
                    SoundPlayer.playPullStart(ctx);   // ← 'pull' sound
                } catch (Throwable ignored) {}
                if (DEBUG) Log.d("RV_TW", "onPull(): pull sound played, accum=" + pullAccumPx);
            }
        } else {

            pullAccumPx = Math.max(0f, pullAccumPx + delta);
        }
    }


    public static void onRefreshComplete() {

        try {
            Context ctx = Utils.getContext();
            SoundPlayer.playRefreshComplete(ctx);  // ← 'refresh' sound
        } catch (Throwable ignored) {}
        pullSoundPlayed = false;
        pullAccumPx = 0f;
        if (DEBUG) Log.d("RV_TW", "onRefreshComplete(): refresh sound played & state reset");
    }
}
