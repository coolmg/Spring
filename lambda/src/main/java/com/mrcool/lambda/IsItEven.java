/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import java.util.function.IntPredicate;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
public class IsItEven implements IntPredicate {

	@Override
	public boolean test(int value) {
		return value % 2 == 0;
	}

}
