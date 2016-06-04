package creative.nurseme;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vyas.g on 6/1/2016.
 */
public class Parcel {

    private String Desc,From,To;
    private Double weight;
    private Date ondelivered,onrecieved;
    private Boolean delivered;
    private int priority;

    public Parcel(){

    }
    public Parcel(String D,String F,String T,Date OnD,Date OnR,Boolean d,int P,Double W){
        this.Desc = D;
        this.From = F;
        this.To = T;
        this.ondelivered = OnD;
        this.onrecieved = OnR;
        this.delivered = d;
        this.priority = P;//Priority is from 1-10
        this.weight = W;
    }

    public ArrayList<Parcel> populateparcel(){
        ArrayList<Parcel> x = new ArrayList<>();
        int i = 0;
        Parcel p;
        Date d = new Date("12-12-12");
        for(i = 0;i<10;i++){
            p = new Parcel("Mouse"+1,"Adyar","Coimbatore",d,null,false,1,12.1);
            x.add(p);
        }
        for(Parcel y : x){
            Log.d("parcel", "populateparcel: "+ y.getDesc());
        }
        return x;
    }

    public java.lang.String getDesc() {
        return Desc;
    }

    public Double getWeight() {
        return weight;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public int getPriority() {
        return priority;
    }

    public Date getOnrecieved() {
        return onrecieved;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public Date getOndelivered() {
        return ondelivered;
    }

}
