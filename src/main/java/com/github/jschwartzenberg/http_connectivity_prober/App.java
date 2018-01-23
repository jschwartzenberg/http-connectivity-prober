package com.github.jschwartzenberg.http_connectivity_prober;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

public class App {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, Exception {
		Set<Class<? extends SimpleHttpClientInterface>> httpClients = findHttpClients();
		List<String> urls = asList(
				"http://captive.apple.com/",
				"http://www.msftncsi.com/ncsi.txt",
				"http://winshipway.com/",
				"http://wrs21.winshipway.com/",
				"http://clients3.google.com/",
				"http://www.airport.us/",
				"http://whoami.scansafe.net/",
				"http://detectportal.firefox.com/success.txt",
				"https://httpbin.org/get"
//				"https://www.fortiguard.com/wftest/1.html"
			);

		for (Class<? extends SimpleHttpClientInterface> httpClient : httpClients) {
			out.println("Testing client: " + httpClient.getSimpleName());
			for (String url : urls) {
				out.println("================== BEGIN " + url + " ==================");
				out.println(httpClient.newInstance().get(url));
				out.println("==================   END " + url + " ==================\n\n");
			}
		}
	}

	private static Set<Class<? extends SimpleHttpClientInterface>> findHttpClients() {
		Reflections reflections = new Reflections("com.github.jschwartzenberg.http_connectivity_prober");

		Set<Class<? extends SimpleHttpClientInterface>> httpClients = reflections
				.getSubTypesOf(SimpleHttpClientInterface.class);

		if (httpClients.isEmpty()) {
			err.println("Couldn't find any HTTP client implementations. (Reflection issue.)");
			exit(1);
		}
		return httpClients;
	}
}
