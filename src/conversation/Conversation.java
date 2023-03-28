package conversation;

import conversation.actions.Action;
import conversation.actions.IllegalAction;
import model.Department;
import utils.Config;

import java.util.*;

public class Conversation {
    private final Map<String, Action> actionByCommand;
    private final Department department;
    public Conversation(Map<String, Action> actionByCommand) {
        this.actionByCommand = actionByCommand;
        this.department = new Department(Config.departmentCapacity);
    }

    public Conversation() {
        this.actionByCommand = new HashMap<>();
        this.department = new Department(Config.departmentCapacity);
    }

    public void register(Action action, String... commands) {
        for (int i = 0; i < commands.length; ++i) {
            actionByCommand.put(commands[i], action);
        }
    }

    public Action getCommand(String commandName) {
        return actionByCommand.getOrDefault(commandName, new IllegalAction());
    }

    public void execute(String commandName, String[] args) throws Exception {
        Action action = actionByCommand.getOrDefault(commandName, new IllegalAction());
        action.execute(department, args);
    }

    public int getCommandArgumentsAmount(String commandName) {
        Action action = actionByCommand.getOrDefault(commandName, new IllegalAction());
        return action.getArgumentsAmount();
    }

    public ArrayList<String> getCommandArgumentMessages(String commandName) {
        Action action = actionByCommand.getOrDefault(commandName, new IllegalAction());
        return action.getArgumentMessages();
    }
}
