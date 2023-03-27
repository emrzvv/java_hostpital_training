package conversation.actions;

import conversation.Messages;
import model.Department;
import model.exceptions.StopException;

public class Stop extends AbstractAction {
    public Stop() {}

    @Override
    public void execute(Department department, String... arg) throws StopException {
        throw new StopException(Messages.stop);
    }
}
