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
        return name;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public int getRange() {
        return range;
    }
}
