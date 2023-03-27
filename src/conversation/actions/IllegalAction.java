package conversation.actions;

import conversation.Messages;
import model.Department;

public class IllegalAction extends AbstractAction {
    @Override
    public void execute(Department department, String[] args) {
        System.out.println(Messages.illegalAction);
    }
}
