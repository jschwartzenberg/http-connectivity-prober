package com.github.jschwartzenberg.http_connectivity_prober.impl;

import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.github.jschwartzenberg.http_connectivity_prober.SimpleHttpClientInterface;
import com.google.common.io.CharStreams;

public class ApacheHttpComponentsHttpClientImpl implements SimpleHttpClientInterface {

	public String get(String url) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);

		return CharStreams.toString(new InputStreamReader(response.getEntity().getContent()));
	}

}
