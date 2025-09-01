package app.revanced.integrations.twitter.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import app.revanced.integrations.twitter.model.Debug;
import app.revanced.integrations.twitter.Utils;

// Lcom/twitter/model/core/entity/d;
public class TweetInfo extends Debug {

    private Object obj;

    public TweetInfo(Object obj) {
        super(obj);
        this.obj = obj;
    }

    public String getLang() throws Exception {
        // y:String
        return (String) super.getField("tweetLang");
    }

    @Override
    public String toString() {
        try {
            return "TweetInfo [getLang()=" + getLang() + "]";

        } catch (Exception e) {
            Utils.logger(e);
            return e.getMessage();
        }

    }

}