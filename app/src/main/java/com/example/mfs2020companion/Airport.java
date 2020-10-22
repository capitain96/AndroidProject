package com.example.mfs2020companion;

public class Airport {
    private final String name;
    private final String ICAOCode;
    private final String airportCode;
    private final String runways;
    private final String imagePath;

    public Airport(String name, String ICAOCode , String airportCode, String runways, String imagePath) {
        this.name = name;
        this.ICAOCode = ICAOCode;
        this.airportCode = airportCode;
        this.runways = runways;
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
