package creative.nurseme;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by vyas on 6/4/16.
 */
public class ParcelSelectActivity  extends Activity {
    Parcelselectoradaptor Adap = null;
    ListView l;
    String TAG = "Poop";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parcelsview);
        Parcel Q = new Parcel();
        l =  (ListView) this.findViewById(R.id.list);

        final ArrayList<Parcel> Parcels = Q.populateparcel();

        Adap = new Parcelselectoradaptor(this,Parcels);

        l.setAdapter(Adap);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: "+Parcels.get(i).getDesc());
                Toast.makeText(ParcelSelectActivity.this,"Select us to view more",Toast.LENGTH_LONG).show();

            }
        });
    }

}