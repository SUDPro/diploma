package ru.itis.taskdistribution.models;

import lombok.Getter;
import ru.itis.taskdistribution.requests.RestTemplateAdapter;

import java.util.Map;

@Getter
public class Request {

    private String relativeUrl;
    private String requestType;
    private Map<String, String> params;

    public Request(String relativeUrl, String requestType, Map<String, String> params) {
        this.relativeUrl = relativeUrl;
        this.params = params;
        this.requestType = requestType;
    }

    public void send() {
        RestTemplateAdapter restTemplate = new RestTemplateAdapter();
        restTemplate.sendRequest(this);
    }
}
