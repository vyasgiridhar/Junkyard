package creative.nurseme;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.GoogleMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vyas.g on 6/1/2016.
 */
public class PlacePopulator extends AsyncTask<Void, Void, Void> {

    String TAG = "Places ";
    protected Double latitude,longitude;
    GoogleMap the_map;
    protected StringBuilder googlePlacesUrl;
    String outputresponse;
    JSONObject placesjson;
    List<HashMap<String, String>> googlePlacesList = null;
    Places placeJsonParser;



    public void init(Double x,Double y,GoogleMap m){
        this.latitude = x;
        this.longitude = y;
        this.the_map = m;
    }

    @Override
    protected void onPreExecute(){
        googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + 50000);
        googlePlacesUrl.append("&types=" + "post_office");
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" +"AIzaSyADB0b0XmBqFdvTaspURI2JchNEU9RanOs");

    }
    @Override
    protected Void doInBackground(Void... params) {
       // Places placeJsonParser = new Place;

        try{
            URL url = new URL(googlePlacesUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream stream = connection.getInputStream();
            InputStreamReader isReader = new InputStreamReader(stream );
            BufferedReader br = new BufferedReader(isReader );
            outputresponse = br.readLine();
            Log.d(TAG, "doInBackground: "+ outputresponse);
            placesjson = new JSONObject(outputresponse);
           // googlePlacesList = placeJsonParser.parse(googlePlacesJson);

        }catch(IOException e){
            Log.e(TAG, "doInBackground: ");
        }
        catch (JSONException e){
            Log.d(TAG, "doInBackground: "+ "Not working" );
        }

            return null;
        }
}
/*
    Result result = new Result();

    @Override
    protected Result doInBackground(Object... params) {
        // do things with this.itemsToProcess..
        if (isCancelled()) { return null);
            //

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            if (onProgressListener != null) {
                onProgressListener.onProgress(this, (double)values[0] / (double) remoteFiles.length );
            }
        }

        @Override
        protected void onPostExecute(Result result) {
            super.onPostExecute(result);

            if (onFinishedListener != null) {
                onFinishedListener.onFinished(this, result);
            }
        }
    }*/

