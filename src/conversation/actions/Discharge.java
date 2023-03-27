package conversation.actions;

import conversation.Messages;
import conversation.Validators;
import model.Department;
import model.Patient;
import model.Status;
import model.exceptions.InvalidTransitionException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Discharge extends AbstractAction {

    public Discharge() {
        this.argumentsAmount = 1;
        this.argumentMessages = new ArrayList<>() {
            {
                add(Messages.enterPatientsId);
            }
        };
    }
    @Override
    public void execute(Department department, String[] args) {
        Patient[] patients = department.getPatients();
        try {
            int id = Integer.parseInt(args[0]);
            Validators.checkIfNotPositive(id);
            if (Validators.validateId(id)) {
                patients[id - 1].discharge();
                System.out.print(Messages.patientHasBeenDischarged);
            }
            else {
                System.out.print(Messages.invalidIdInput);
            }
        } catch (NumberFormatException e) {
            System.out.print(Messages.brokenIdInput);
        } catch (InvalidTransitionException e) {
            System.out.print(Messages.transitionIsNotAllowed);
        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
    }
}
