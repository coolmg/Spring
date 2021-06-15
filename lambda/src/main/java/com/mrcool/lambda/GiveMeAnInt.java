/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import java.util.function.IntSupplier;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
public class GiveMeAnInt implements IntSupplier {

	@Override
	public int getAsInt() {
		return (int) (Math.random() * Integer.MAX_VALUE);
	}

}
