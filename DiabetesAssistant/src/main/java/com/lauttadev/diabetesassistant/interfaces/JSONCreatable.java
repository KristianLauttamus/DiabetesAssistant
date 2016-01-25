package com.lauttadev.diabetesassistant.interfaces;

public interface JSONCreatable {
    /**
     * Function to create from JSON
     * @return JSONCreatable
     */
    public abstract JSONCreatable createFromJSON(); // TODO Require JSONArray
}