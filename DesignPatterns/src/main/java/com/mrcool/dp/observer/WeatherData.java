package com.mrcool.dp.observer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    @Getter
    @Setter
    private float temperature;
    @Getter
    @Setter
    private float humidity;
    @Getter
    @Setter
    private float pressure;

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public void measurementsChanged() {
        this.notifyObservers();
    }

    public void setMeasurements(final float temperature, final float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        this.measurementsChanged();
    }
}
