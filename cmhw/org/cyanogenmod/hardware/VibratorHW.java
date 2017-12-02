 
/*
 * Copyright (C) 2016 The CyanogenMod Project
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

package org.cyanogenmod.hardware;

import org.cyanogenmod.internal.util.FileUtils;

import android.util.Log;

public class VibratorHW {

    private static final String TAG = "VibratorHW";

    public static boolean isSupported() {
    
    Log.e(TAG, "LEVEL_PATH " + FileUtils.isFileWritable(LEVEL_PATH));
    Log.e(TAG, "DEFAULT_PATH " + FileUtils.isFileReadable(DEFAULT_PATH));
    Log.e(TAG, "MAX_PATH " + FileUtils.isFileReadable(MAX_PATH));
    Log.e(TAG, "MIN_PATH " + FileUtils.isFileReadable(MIN_PATH));
        return FileUtils.isFileWritable(LEVEL_PATH) &&
                FileUtils.isFileReadable(DEFAULT_PATH) &&
                FileUtils.isFileReadable(MAX_PATH) &&
                FileUtils.isFileReadable(MIN_PATH);
    }

    public static int getMaxIntensity() {
        try {
            return Integer.parseInt(FileUtils.readOneLine(MAX_PATH));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return -1;
    }

    public static int getMinIntensity() {
        try {
            return Integer.parseInt(FileUtils.readOneLine(MIN_PATH));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return -1;
    }

    public static int getWarningThreshold() {
        return -1;
    }

    public static int getCurIntensity() {
        try {
            return Integer.parseInt(FileUtils.readOneLine(LEVEL_PATH));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return -1;
    }

    public static int getDefaultIntensity() {
        try {
            return Integer.parseInt(FileUtils.readOneLine(DEFAULT_PATH));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return -1;
    }

    public static boolean setIntensity(int intensity) {
        return FileUtils.writeLine(LEVEL_PATH, String.valueOf(intensity));
    }
}
