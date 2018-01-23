package com.github.jschwartzenberg.http_connectivity_prober.impl;

import static com.jcabi.http.Request.GET;

import com.github.jschwartzenberg.http_connectivity_prober.SimpleHttpClientInterface;
import com.jcabi.http.request.JdkRequest;

public class FluentHttpClientImpl implements SimpleHttpClientInterface {

	public String get(String url) throws Exception {
		return new JdkRequest(url)
				  .method(GET)
				  .fetch()
				  .body();
	}

}
