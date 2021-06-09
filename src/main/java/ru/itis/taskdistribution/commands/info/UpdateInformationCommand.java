package ru.itis.taskdistribution.commands.info;

import ru.itis.taskdistribution.commands.AbstractCommand;
import ru.itis.taskdistribution.models.Request;

import java.util.Map;

public class UpdateInformationCommand extends AbstractCommand {

    public UpdateInformationCommand(String relativeUrl, Map<String, String> params) {
        super(relativeUrl, params);
    }

    @Override
    public Request buildRequest() {
        return null;
    }
}
