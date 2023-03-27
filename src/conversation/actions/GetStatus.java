package conversation.actions;

import conversation.Messages;
import conversation.Validators;
import model.Department;

import java.util.ArrayList;

public class GetStatus extends AbstractAction {
    public GetStatus() {
        this.argumentsAmount = 1;
        this.argumentMessages = new ArrayList<>() {
            {
                add(Messages.enterPatientsId);
            }
        };
    }

    @Override
    public void execute(Department department, String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            Validators.checkIfNotPositive(id);
            if (Validators.validateId(id)) {
                System.out.println(Messages.patientsStatus + department.getPatients()[id - 1].getStatus());
            }
            else {
                System.out.print(Messages.invalidIdInput);
            }
        } catch (NumberFormatException e) {
            System.out.print(Messages.brokenIdInput);
        }
    }
}
