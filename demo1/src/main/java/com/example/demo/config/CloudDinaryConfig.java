package com.example.demo.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudDinaryConfig {
    private final String CLOUD_NAME = "my_cloud_name";

    private final String API_KEY = "my_api_key";
    private final String API_SECRET = "my_api_secret";

    private final String FOLDER = "test";


    @Bean
    public Cloudinary cloudinary(){
        Map<String,String> config = new HashMap<>();
        config.put("cloud_name",CLOUD_NAME);
        config.put("api_key",API_KEY);
        config.put("api_secret",API_SECRET);
//        config.put("folder", FOLDER); // Add this line
        return new Cloudinary(config);
    }



}
