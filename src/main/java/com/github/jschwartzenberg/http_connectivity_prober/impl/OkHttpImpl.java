package com.github.jschwartzenberg.http_connectivity_prober.impl;

import com.github.jschwartzenberg.http_connectivity_prober.SimpleHttpClientInterface;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpImpl implements SimpleHttpClientInterface {

	public String get(String url) throws Exception {
		return new OkHttpClient()
				.newCall(new Request.Builder().url(url).build())
				.execute()
				.body()
				.string();
	}

}
