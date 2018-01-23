package com.github.jschwartzenberg.http_connectivity_prober.impl;

import static com.github.jschwartzenberg.http_connectivity_prober.impl.HttpImplTestHelper.testHappyFlowWith;

import org.junit.Test;

public class OkHttpImplTest {

	@Test
	public void happyFlow() throws Exception {
		testHappyFlowWith(new OkHttpImpl());
	}

}
