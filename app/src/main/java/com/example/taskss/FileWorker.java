package com.example.taskss;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWorker extends Worker {
    private final Context context;
    public static final String KEY_LOGIN = "login";

    public FileWorker(@NonNull Context context,
                      @NonNull WorkerParameters workerParams
    ) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        String login = getInputData().getString(KEY_LOGIN);

        String filename = "login";
        String fileContents = login;
        File dir = context.getFilesDir();
        File file_login = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_login);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContents);
            Log.d("FileWorker", "uses worker");
            writer.close();
            fos.close();
            return Result.success();
        } catch (IOException e) {
            return Result.failure();
        }
    }
}
