package com.example.messagingrabbitmq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

public class Utils {
	private static Gson gson = new Gson(); 
	private static final Log logger = LogFactory.getLog(Utils.class);
	
	@SuppressWarnings("unchecked")
	public static List<DnsServicesConfiguration> listAll(){
		InputStream stream = DnsServicesController.class.getResourceAsStream("/dnsStorage.json");
		
		try {
		 List<DnsServicesConfiguration> dnsDtos = (List<DnsServicesConfiguration>) gson
				  .fromJson(Utils.getStringFromInputStream(stream), List.class);
		 return dnsDtos;
		}catch (Exception e) {
			logger.error("Erro ao tentar obter a lista de dns", e);
		}
		 return null;
	}
	
	
	public static void save(DnsServicesConfiguration dns) {
		List<DnsServicesConfiguration> listAll = listAll();
		listAll.add(dns);
		try {
			URL url = DnsServicesController.class.getResource("/dnsStorage.json");
			FileWriter writer = new FileWriter(new File(url.toURI()).getAbsoluteFile());  
		    BufferedWriter buffer = new BufferedWriter(writer);  
		    buffer.write(gson.toJson(listAll));  
		    buffer.close();  
		}catch(IOException | URISyntaxException e) {
			logger.error(e);
		} 
	}
	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
}
