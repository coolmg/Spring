/*
 * Copyright 2021-2021 MrCool.
 *
 */
package com.mrcool.dp.observer;

public interface Subject {

	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers();

}
