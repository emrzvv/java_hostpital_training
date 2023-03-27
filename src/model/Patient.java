package model;

import model.automata.FSM;
import model.exceptions.InvalidTransitionException;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Patient {
    private FSM<Status> controller;
    public Patient(Map<Status, Set<Status>> transitions) {
        this.controller = new FSM<>(transitions, Status.ILL, Status.DISCHARGED);
    }

    public Status getStatus() {
        return controller.getCurrentState();
    }

    public void increaseStatus(Boolean wantToDischarge) throws InvalidTransitionException, NoSuchElementException {
        Status currentState = controller.getCurrentState();
        if (wantToDischarge) {
            controller.setCurrentState(currentState.next(), (current, next) -> true);
        }
        else {
            controller.setCurrentState(currentState.next(), (current, next) -> current != Status.DISCHARGE_READY && next != Status.DISCHARGED);
        }
    }

    public void decreaseStatus() throws InvalidTransitionException, NoSuchElementException {
        controller.setCurrentState(controller.getCurrentState().previous(), (current, next) -> true);
    }

    public void discharge() throws InvalidTransitionException {
        controller.setCurrentState(Status.DISCHARGED, (current, next) -> true);
    }
}
