package conversation.actions;

import conversation.Messages;
import conversation.Validators;
import model.Department;
import model.Patient;
import model.Status;
import model.exceptions.InvalidTransitionException;
import model.exceptions.NeedConfirmationException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StatusUp extends AbstractAction {
    public StatusUp() {
        this.argumentsAmount = 1;
        this.argumentMessages = new ArrayList<>() {
            {
                add(Messages.enterPatientsId);
            }
        };
    }

    @Override
    public void execute(Department department, String[] args) throws NeedConfirmationException {
        Patient[] patients = department.getPatients();
        try {
            int id = Integer.parseInt(args[0]);
            Validators.checkIfNotPositive(id);
            if (Validators.validateId(id)) {
                patients[id - 1].increaseStatus(isConfirmed);
                if (!patients[id - 1].getStatus().equals(Status.DISCHARGED))
                    System.out.println(Messages.newPatientStatus + patients[id - 1].getStatus());
            }
            else {
                System.out.print(Messages.invalidIdInput);
            }
        } catch (NumberFormatException e) {
            System.out.print(Messages.brokenIdInput);
        } catch (InvalidTransitionException e) {
            throw new NeedConfirmationException(Messages.dischargeConfirmation);
        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
    }
}
