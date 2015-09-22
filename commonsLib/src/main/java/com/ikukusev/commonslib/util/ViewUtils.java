package com.ikukusev.commonslib.util;

import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ivan on 9/22/2015.
 */
public class ViewUtils {

    private static float PRESSED_ALPHA = 0.7F;

    public static void applyEffect(Effect effect, View... views) {
        for (View view : views) {
            effect.apply(view);
        }
    }

    public static void applyAlpha(View... views) {
        applyEffect(alpha, views);
    }


    public interface Effect {
        public void apply(View view);
    }

    public static Effect alpha = new Effect() {
        @Override
        public void apply(final View view) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        view.setAlpha(PRESSED_ALPHA);
                    } else {
                        view.setAlpha(1);
                    }
                    return false;
                }
            });
        }
    };
}
