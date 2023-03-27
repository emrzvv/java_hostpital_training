package model.automata;

import conversation.Messages;
import model.exceptions.InvalidTransitionException;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiFunction;

public class FSM<T> {
    private Map<T, Set<T>> transitions;
    protected T currentState;
    protected T startState;
    protected T finalState;

    public FSM(Map<T, Set<T>> transitions, T startState, T finalState) {
        this.transitions = transitions;
        this.currentState = startState;
        this.startState = startState;
        this.finalState = finalState;
    }

    public T getCurrentState() {
        return currentState;
    }

    public void setCurrentState(T newState, BiFunction<T, T, Boolean> validate) throws InvalidTransitionException {
        if (currentState == finalState) {
            throw new NoSuchElementException(Messages.errorAlreadyDischarged);
        }
        if (!transitions.getOrDefault(currentState, Set.of(finalState)).contains(newState) ||
                !validate.apply(currentState, newState)) {
            throw new InvalidTransitionException("Invalid transition\n");
        }
        currentState = newState;
    }
}
