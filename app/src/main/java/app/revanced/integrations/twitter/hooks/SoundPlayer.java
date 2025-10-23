package app.revanced.integrations.twitter.hooks;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.content.Context;


public final class SoundPlayer {
    
    public static void playPullStart(Context ctx) {
        try {
            ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
            
            tg.startTone(ToneGenerator.TONE_PROP_BEEP2, 40);
        } catch (Throwable ignored) {}
    }

    
    public static void playRefreshComplete(Context ctx) {
        try {
            ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
            tg.startTone(ToneGenerator.TONE_PROP_ACK, 80);
        } catch (Throwable ignored) {}
    }
}
