package conversation.actions;

import conversation.Messages;
import conversation.Validators;
import model.Department;
import model.Patient;
import model.exceptions.InvalidTransitionException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StatusDown extends AbstractAction {
    public StatusDown() {
        this.argumentsAmount = 1;
        this.argumentMessages = new ArrayList<>() {
            {
                add(Messages.enterPatientsId);
            }
        };
    }

    @Override
    public void execute(Department department, String[] args) throws Exception {
        Patient[] patients = department.getPatients();
        try {
            int id = Integer.parseInt(args[0]);
            Validators.checkIfNotPositive(id);
            if (Validators.validateId(id)) {
                patients[id - 1].decreaseStatus();
                System.out.println(Messages.newPatientStatus + patients[id - 1].getStatus());
            }
            else {
                System.out.print(Messages.invalidIdInput);
            }
        } catch (NumberFormatException e) {
            System.out.print(Messages.brokenIdInput);
        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        } catch (InvalidTransitionException e) {

        }
    }
}
