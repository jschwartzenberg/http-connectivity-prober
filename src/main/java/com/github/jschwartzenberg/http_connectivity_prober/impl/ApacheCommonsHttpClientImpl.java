package com.github.jschwartzenberg.http_connectivity_prober.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

import com.github.jschwartzenberg.http_connectivity_prober.SimpleHttpClientInterface;

public class ApacheCommonsHttpClientImpl implements SimpleHttpClientInterface {

	public String get(String url) throws IOException {
		HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
		GetMethod get = new GetMethod(url);
		httpClient.executeMethod(get);
		return get.getResponseBodyAsString();
	}

}
