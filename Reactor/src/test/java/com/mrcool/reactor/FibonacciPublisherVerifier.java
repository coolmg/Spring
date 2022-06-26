package com.mrcool.reactor;

import org.reactivestreams.Publisher;
import org.reactivestreams.tck.PublisherVerification;
import org.reactivestreams.tck.TestEnvironment;
import reactor.core.publisher.Flux;

public class FibonacciPublisherVerifier extends PublisherVerification<Integer> {

	public FibonacciPublisherVerifier() {
		this(new TestEnvironment(), 1000);
	}

	public FibonacciPublisherVerifier(TestEnvironment env, long publisherReferenceGCTimeoutMillis) {
		super(env, publisherReferenceGCTimeoutMillis);
	}

	@Override
	public Publisher<Integer> createPublisher(long l) {
		return Flux.fromArray(new Integer[] { 1, 2, 3 });
	}

	@Override
	public Publisher<Integer> createFailedPublisher() {
		return new FibonacciPublisher();
	}

}