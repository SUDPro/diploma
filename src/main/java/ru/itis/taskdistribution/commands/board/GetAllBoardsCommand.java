package ru.itis.taskdistribution.commands.board;

import ru.itis.taskdistribution.commands.AbstractCommand;
import ru.itis.taskdistribution.models.Request;

import java.util.Map;

public class GetAllBoardsCommand extends AbstractCommand {

    public GetAllBoardsCommand(String relativeUrl, Map<String, String> params) {
        super(relativeUrl, params);
    }

    @Override
    public Request buildRequest() {
        return null;
    }
}
