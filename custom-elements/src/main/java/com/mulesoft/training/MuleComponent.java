package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

public class MuleComponent {

	int count;

	public MuleComponent() {
		count = 1;
	}

	public Map<String, String> processMap(Map<String, String> inMap) {
		inMap.put("testKey", "testValue");
		return inMap;
	}

	public Map<String, String> processArray(List<String> inList) {
		Map<String, String> outMap = new HashMap<String, String>();
		for (String s : inList) {
			int i = 0;
			outMap.put("key_" + i, s);
			i++;
		}
		return outMap;
	}

	public Map<String, String> processString(String inStr) {
		Map<String, String> outMap = new HashMap<String, String>();
		outMap.put("key", inStr);
		return outMap;
	}

	public Map<String, String> processAll(@Payload Object input, @InboundHeaders("http.method") String httpMethod) {

		Map<String, String> outMap = new HashMap<String, String>();
		outMap.put("message", input.toString());
		outMap.put("executed by", "processAll method");
		outMap.put("http method used", httpMethod);
		outMap.put("count", String.valueOf(count));

		count++;

		return outMap;
	}

}
