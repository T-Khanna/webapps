package jett_apps.grouvie.HelperObjects;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Cinema implements Serializable {

    private String name;
    private LatLng location;
    private int index;

    public Cinema() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public LatLng getLocation() {
        return location;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
