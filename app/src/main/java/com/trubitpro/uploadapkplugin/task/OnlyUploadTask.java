package com.trubitpro.uploadapkplugin.task;


import com.android.build.gradle.api.BaseVariantOutput;
import com.trubitpro.uploadapkplugin.pramars.UploadPgyParams;


import org.gradle.api.GradleException;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Objects;

/**
 * Created by Android-ZX
 * 2021/9/3.
 */
public class OnlyUploadTask extends BaseTask {

    @TaskAction
    public void uploadToPGY() {

        for (BaseVariantOutput output : mVariant.getOutputs()) {
            File apkDir = output.getOutputFile();
            if (apkDir == null || !apkDir.exists()) {
                throw new GradleException("The compiled APK file to upload does not exist!");
            }
            System.out.println("ApkDir path: " + apkDir.getAbsolutePath());
            File apk = null;
            if (apkDir.getName().endsWith(".apk")) {
                apk = apkDir;
            } else {
                if (apkDir.listFiles() != null) {
                    for (int i = Objects.requireNonNull(apkDir.listFiles()).length - 1; i >= 0; i--) {
                        File apkFile = Objects.requireNonNull(apkDir.listFiles())[i];
                        if (apkFile != null && apkFile.exists() && apkFile.getName().endsWith(".apk")) {
                            apk = apkFile;
                            break;
                        }
                    }
                }
            }
            if (apk == null || !apk.exists()) {
                throw new GradleException("The compiled APK file to upload does not exist!");
            }
            System.out.println("Final upload apk path: " + apk.getAbsolutePath());
            uploadPgyQuickWay( apk);
        }

    }
}