package conversation.actions;

import model.Department;
import model.exceptions.StopException;

import java.util.ArrayList;

public interface Action {
    void execute(Department department, String[] args) throws Exception;
    int getArgumentsAmount();
    ArrayList<String> getArgumentMessages();
    void setIsConfirmed(boolean isConfirmed);
    boolean isConfirmed();
}