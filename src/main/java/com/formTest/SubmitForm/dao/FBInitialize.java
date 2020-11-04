package com.formTest.SubmitForm.dao;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service  
public class FBInitialize 
{  
	@PostConstruct  
	public void initialize() 
	{  
		try 
		{  
			Resource resource = new ClassPathResource("serviceaccount.json");
		    InputStream serviceAccount = resource.getInputStream();
					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setDatabaseUrl("https://fir-8a65a.firebaseio.com")
					  .build();

					FirebaseApp.initializeApp(options);
			
			
		} 
		catch (Exception e) 
		{  
			e.printStackTrace();  
		}
	}
}  