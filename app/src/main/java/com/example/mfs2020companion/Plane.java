package com.example.mfs2020companion;

public class Plane {
    private final String name;
    private final int cruiseSpeed;
    private final int maxAltitude;
    private final int range;

    public Plane(String name, int cruiseSpeed , int maxAltitude, int range) {
        this.name = name;
        this.cruiseSpeed = cruiseSpeed;
        this.maxAltitude = maxAltitude;
        this.range = range;
    }

    public String getName() {
        return (String)name;
    }

    public String getCruiseSpeed() {
        Integer cruiseSpeed = (Integer) this.cruiseSpeed;
        return cruiseSpeed.toString();
    }

    public String getMaxAltitude() {
        Integer maxAltitude = (Integer) this.maxAltitude;
        return maxAltitude.toString();
    }

    public String getRange() {
        Integer range = (Integer) this.range;
        return range.toString();
    }
}
