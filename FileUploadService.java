package com.greensill.http.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class FileUploadService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> uploadFileViaHttp(String pathToFile, String fileName, String submissionUrl){

        return restTemplate.postForEntity(
                submissionUrl,
                createFileUploadRequest(pathToFile, fileName),
                String.class);
    }

    private HttpEntity<MultiValueMap<String, Object>> createFileUploadRequest(String pathToFile, String fileName){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add(fileName, new ClassPathResource(pathToFile));
        return new HttpEntity<>(body, headers);
    }
}
