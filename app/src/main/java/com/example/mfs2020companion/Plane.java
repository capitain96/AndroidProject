package com.example.mfs2020companion;

public class Plane {
    private final String name;
    private final int cruiseSpeed;
    private final int maxAltitude;
    private final int range;
    private final String imagePath;

    public Plane(String name, int cruiseSpeed , int maxAltitude, int range, String imagePath) {
        this.name = name;
        this.cruiseSpeed = cruiseSpeed;
        this.maxAltitude = maxAltitude;
        this.range = range;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return this.imagePath;
    }
}
