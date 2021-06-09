package ru.itis.taskdistribution.commands;

import ru.itis.taskdistribution.models.Request;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCommand {

    protected String relativeUrl;
    protected Map<String, String> params;

    public AbstractCommand(String relativeUrl, Map<String, String> params) {
        this.relativeUrl = relativeUrl;
        this.params = params;
    }

    public abstract Request buildRequest();
    
}