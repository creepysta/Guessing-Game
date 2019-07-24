package com.sam.guessinggame;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

public abstract class OnSwipeGestureListener implements GestureDetector.OnGestureListener {

    private final GestureDetector gestureDetector = new GestureDetector(new GestureListener());

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 60;
        private static final int SWIPE_THRESHOLD_VELOCITY = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                rightToLeft();

                return true;
            }

            return false;
        }
    }

    protected abstract void rightToLeft();
}