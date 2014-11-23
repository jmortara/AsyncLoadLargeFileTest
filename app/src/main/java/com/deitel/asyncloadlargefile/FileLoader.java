//package com.deitel.asyncloadlargefile;
//
//import android.content.Context;
//import android.content.res.AssetManager;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.HashMap;
//
///**
// * Created by jason on 11/15/2014.
// */
//public class FileLoader extends AsyncTask<Void, Void, Void>
//{
//    public static final String TAG = "FileLoader";
//    private MainActivity mainActivity;
//    AssetManager assetManager;
//
//
//    public  FileLoader(AssetManager assetManager)
//    {
//        Log.d(TAG, "new FileLoader");
////        this.mainActivity = mainActivity;
//        this.assetManager = assetManager;
//    }
//
//
////    public void init(MainActivity mainActivity)
////    {
////        Log.d(TAG, "init");
////        this.mainActivity = mainActivity;
////    }
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        Log.e("AsyncTask", "onPreExecute");
//    }
//
//    @Override
//    protected Void doInBackground(Void... params)
//    {
//        long numLines = 0;
//
//        // Escape early if cancel() is called
////            if (isCancelled()) break;
//
//        HashMap<String, String> myDict = new HashMap<String, String>();
////        AssetManager assetManager = mainActivity.getAssets();
//        String line;
//        int currentLine = 0;
//        int lastLineToPrint = 1000;
//        try
//        {
//            InputStream ims = assetManager.open("dictionary_GIANT.txt");
//            BufferedReader r = new BufferedReader(new InputStreamReader(ims));
//            try
//            {
//                while ((line=r.readLine()) != null)
//                {
//                    myDict.put(line, line);
//                    if ( currentLine <= lastLineToPrint)
//                    {
//                        Log.d(TAG, "read line: " + line);
//                        publishProgress((int) ((currentLine / (float) lastLineToPrint) * 100));
//                    }
//                    currentLine++;
//                }
//            }
//            catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //return numLines;
//    }
//
//
//    protected void onProgressUpdate(Integer... progress) {
//        Log.d(TAG, "onProgressUpdate: " + progress.toString());
////        setProgressPercent(progress[0]);
//    }
//
//    protected void onPostExecute(Long result) {
//        Log.d(TAG, "onPostExecute: " + result.toString());
////        showDialog("Downloaded " + result + " bytes");
//    }
//
//    @Override
//    protected Object doInBackground(Object[] objects) {
//        return null;
//    }
//}
