package creative.nurseme;

/**
 * Created by vyas on 6/4/16.
 */

import android.content.Context;
        import java.util.ArrayList;
        import java.util.HashMap;

        import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

public class Parcelselectoradaptor extends BaseAdapter {

    private Activity activity;
    private static LayoutInflater inflater=null;
    private ArrayList<Parcel> parcel;
    public Parcelselectoradaptor(Activity a, ArrayList<Parcel> P) {
        activity = a;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parcel = P;
    }

    public int getCount() {
        return parcel.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.listview_item, null);

        TextView Weight = (TextView)vi.findViewById(R.id.Weight); // Weight
        TextView  Desc= (TextView)vi.findViewById(R.id.Desc); //  Description
        TextView Dest = (TextView)vi.findViewById(R.id.Destination); // Destination

         Parcel P = parcel.get(position);

        // Setting all values in listview
        Weight.setText(P.getWeight().toString());
        Desc.setText(P.getDesc());
        Dest.setText(P.getTo());

        return vi;
    }
}