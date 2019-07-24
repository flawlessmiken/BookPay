/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bookpay.utils;

import android.content.Context;
import android.graphics.Color;

import androidx.core.content.ContextCompat;

import com.example.bookpay.R;

/**
 * ColorUtils is a class with one method, used to color the ViewHolders in
 * the RecyclerView. I put in a separate class in an attempt to keep the
 * code organized.
 *
 * We aren't going to go into detail about how this method works, but feel
 * free to explore!
 */
public class ColorUtils {


    public static int getCircularImageBackgroundColorFromInstance(Context context, int instanceNum) {
        switch (instanceNum) {
            case 0:
                return ContextCompat.getColor(context, R.color.material50);
            case 1:
                return ContextCompat.getColor(context, R.color.material100);
            case 2:
                return ContextCompat.getColor(context, R.color.material150);
            case 3:
                return ContextCompat.getColor(context, R.color.material200);
            case 4:
                return ContextCompat.getColor(context, R.color.material250);
            case 5:
                return ContextCompat.getColor(context, R.color.material300);
            case 6:
                return ContextCompat.getColor(context, R.color.material350);
            case 7:
                return ContextCompat.getColor(context, R.color.material400);
            case 8:
                return ContextCompat.getColor(context, R.color.material450);
            case 9:
                return ContextCompat.getColor(context, R.color.material500);
            case 10:
                return ContextCompat.getColor(context, R.color.material550);
            case 11:
                return ContextCompat.getColor(context, R.color.material600);
            case 12:
                return ContextCompat.getColor(context, R.color.material650);
            case 13:
                return ContextCompat.getColor(context, R.color.material700);
            case 14:
                return ContextCompat.getColor(context, R.color.material750);
            case 15:
                return ContextCompat.getColor(context, R.color.material800);
            case 16:
                return ContextCompat.getColor(context, R.color.material850);
            case 17:
                return ContextCompat.getColor(context, R.color.material900);
            default:
                return Color.WHITE;
        }
    }
}
