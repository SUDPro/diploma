package ru.itis.taskdistribution.requests;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.taskdistribution.models.Request;

public class RestTemplateAdapter {

    public void sendRequest(Request request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(new JSONObject(request.getParams()));

    }
}
