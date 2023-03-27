package conversation.actions;

import java.util.ArrayList;

public abstract class AbstractAction implements Action {
    protected int argumentsAmount = 0;
    protected boolean isConfirmed = false;
    protected ArrayList<String> argumentMessages = new ArrayList<>();
    public int getArgumentsAmount() {
        return argumentsAmount;
    }
    public ArrayList<String> getArgumentMessages() {
        return argumentMessages;
    }

    @Override
    public boolean isConfirmed() {
        return isConfirmed;
    }

    @Override
    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}
