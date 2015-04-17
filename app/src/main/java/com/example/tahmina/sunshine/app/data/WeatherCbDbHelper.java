package com.example.tahmina.sunshine.app.data;

import android.content.Context;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tahmina on 15-04-17.
 */
public class WeatherCbDbHelper {

    private final String LOG_TAG = "TAMZ";


    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "weather.cb";

    private String WEATHER_FORCAST_ID="weatherForcastId";

    private Context mContext;

    //a manager
    private Manager manager;
    private  Database database;


    private Document document;

    // create an object that contains data for a document
    Map<String, Object> weatherDocContent;




    public WeatherCbDbHelper(Context context){
        mContext=context;
        try {
            manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
            Log.d (LOG_TAG, "CB Manager created");
        } catch (IOException e) {
            Log.e(LOG_TAG, "Cannot create CB manager object");
            return;
        }



        // create a name for the database and make sure the name is legal

        if (!Manager.isValidDatabaseName(DATABASE_NAME)) {
            Log.e(LOG_TAG, "Bad database name");
            return;
        }

        // create a new database

        try {
            database = manager.getDatabase(DATABASE_NAME);


        } catch (CouchbaseLiteException e) {
            Log.e(LOG_TAG, "Cannot get database");
            return;
        }
    }


    public Document getDocument(){


        // create an object that contains data for a document
      weatherDocContent = new HashMap<String, Object>();

        // get the current date and time
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        Calendar calendar = GregorianCalendar.getInstance();
        String currentTimeString = dateFormatter.format(calendar.getTime());

        if(database.getExistingDocument(WEATHER_FORCAST_ID)==null){

            // create an empty document if the document is empty
            document= database.createDocument();

            //add creation date and time
            weatherDocContent.put("creationDate", currentTimeString);

            try {
                document.putProperties(weatherDocContent);
            } catch (CouchbaseLiteException e) {
                Log.e("Error Creating Document", e.getMessage(), e);
            }

        }else {

            //Get an existing document

           document= database.getExistingDocument(WEATHER_FORCAST_ID);




        }

        return document;
    }

}
