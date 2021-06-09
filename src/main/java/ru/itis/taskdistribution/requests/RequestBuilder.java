package ru.itis.taskdistribution.requests;

import ru.itis.taskdistribution.commands.AbstractCommand;
import ru.itis.taskdistribution.models.Request;

public class RequestBuilder {

    private final String HOST = "https://api.trello.com/1";

    public void build(AbstractCommand command) {
        Request request = command.buildRequest();
        request.send();
    }
}
