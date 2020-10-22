package com.example.mfs2020companion;

public class Airport {
    private final String name;
    private final String ICAOCode;
    private final int airportCode;
    private final int runways;
    private final String imagePath;

    public Airport(String name, int cruiseSpeed , int maxAltitude, int range, String imagePath) {
        this.name = name;
        this.cruiseSpeed = cruiseSpeed;
        this.maxAltitude = maxAltitude;
        this.range = range;
        this.imagePath = imagePath;
    }

    public String getName() {
        return (String)name;
    }

    public String getICAOCode() {
        return (String)ICAOCode;
    }

    public String getAirportCode() {
        return (String)airportCode;
    }

    public String getRunways() {
        return (String)runways;
    }
    
    public String getImagePath() {
        return this.imagePath;
    }
}
