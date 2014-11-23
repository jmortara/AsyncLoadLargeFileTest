package com.deitel.asyncloadlargefile;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

//    private FileLoader fileLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AssetManager assetManager = this.getAssets();
//        fileLoader = new FileLoader( assetManager );
//        fileLoader.execute();

        // Start counting off the main UI thread
        LoadingTask tsk = new LoadingTask();
        tsk.execute();
    }

    private class LoadingTask extends AsyncTask<Void, Integer, Integer>
    {
        AssetManager assetManager = getAssets();
        HashMap<String, String> myDict;
        private int currentLine = 0;
        private int lastLineToPrint = Integer.MAX_VALUE;
        String line;
        InputStream ims;
        BufferedReader r;
        TextView counterText;
        String lastLine;

        // constructor
        LoadingTask()
        {
            Log.d(TAG, "new LoadingTask ");

            myDict = new HashMap<String, String>();

            counterText = (TextView) findViewById(R.id.counter);
            counterText.setText("Load init");
        }

        @Override
        protected Integer doInBackground(Void... unused)
        {
            Log.d(TAG, "doInBackground: ");

            try
            {
                ims = assetManager.open("dictionary_GIANT.txt");
                r = new BufferedReader(new InputStreamReader(ims));
                try
                {
                    while ((line=r.readLine()) != null)
                    {
                        myDict.put(line, line);
                        if ( currentLine <= lastLineToPrint && currentLine % 1000 == 0 )    // print lines only occasionally
                        {
//                            Log.d(TAG, "read line: " + line);
                            publishProgress( currentLine );
                        }
                        lastLine = line;
                        currentLine++;
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return currentLine;
        }

        protected void onProgressUpdate(Integer... progress)
        {
//            Log.d(TAG, "onProgressUpdate: " + progress);
            counterText.setText(progress[0] + " lines read, " + line);
        }

        protected void onPostExecute(Integer result)
        {
            String str = "onPostExecute: Load Complete: " + result + "lines \n size: " + myDict.size() + "\n last line: " + ( myDict.get(lastLine) ) ;
            Log.d(TAG, str );
            counterText.setText(str);
            Model.setGlobalDict( myDict );
            myDict = null;
            str += "\n onPostExecute: Load Complete: \n Model.globalDict size: " + Model.globalDict.size() + "\n last line: " + ( Model.globalDict.get(lastLine) ) ;
            Log.d(TAG, str );
            counterText.setText(str);
            if ( myDict == null ) Log.d(TAG, "original hashmap safely deleted" );
        }

    }   // end inner class




}
