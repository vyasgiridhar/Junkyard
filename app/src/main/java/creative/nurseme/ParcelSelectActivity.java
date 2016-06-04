package creative.nurseme;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by vyas on 6/4/16.
 */
public class ParcelSelectActivity  extends Activity {
    @Bind(R.id.list) ListView l;
    Parcelselectoradaptor Adap = null;
    String TAG = "Poop";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parcel Q = new Parcel();
        final ArrayList<Parcel> Parcels = Q.populateparcel();

        Adap = new Parcelselectoradaptor(this,Parcels);
        l.setAdapter(Adap);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: "+Parcels.get(i).getFrom());
            }
        });
    }

}