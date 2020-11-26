/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corona.coronavirustracker.models;

import java.text.NumberFormat;


/**
 *
 * @author PC
 */
public class LocationStats {
    
    
    private String state;
    private String Country;
    private int latestTotalCases;
    private int diffFromPrevDay;

    public int getDiffFromPrevDay() {
        return diffFromPrevDay;
    }

    public void setDiffFromPrevDay(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }
    
   
    @Override
    public String toString() {
        return "LocationStats{"
                + "state=" + state
                + ", Country=" + Country
                + ", latestTotalCases="
                + latestTotalCases
                + '}';
    }
    
}
