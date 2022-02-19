package com.mrcool.dp.observer;

public class CurrentConditionsDisplay implements Observer, Display {

    private final WeatherData weatherData;
    private static final String DISPLAY_NAME = "Current Conditions";

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(DISPLAY_NAME + ":" + weatherData.getTemperature() + "F degrees and " +
                weatherData.getHumidity() + "% humidity");
    }

    @Override
    public void update() {
        this.display();
    }
}
