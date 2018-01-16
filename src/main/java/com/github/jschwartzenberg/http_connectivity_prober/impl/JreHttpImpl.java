package com.github.jschwartzenberg.http_connectivity_prober.impl;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.github.jschwartzenberg.http_connectivity_prober.SimpleHttpClientInterface;
import com.google.common.io.CharStreams;

public class JreHttpImpl implements SimpleHttpClientInterface {

	public String get(String url) throws IOException {
		URLConnection connection = new URL(url).openConnection();
        String string = CharStreams.toString(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        connection.connect();
		return string;
	}

}
