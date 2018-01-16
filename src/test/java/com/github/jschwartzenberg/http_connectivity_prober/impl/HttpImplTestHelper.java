package com.github.jschwartzenberg.http_connectivity_prober.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.jschwartzenberg.http_connectivity_prober.SimpleHttpClientInterface;

public class HttpImplTestHelper {

	public static void testHappyFlowWith(SimpleHttpClientInterface sub) throws Exception {
		assertThat(sub.get("http://captive.apple.com/")).contains("Success");
	}

}
