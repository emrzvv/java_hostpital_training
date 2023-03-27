package model;


import java.util.Map;
import java.util.Set;

public class Department {
    private final int capacity;
    private Patient[] patients;

    public Department(Integer capacity) {
        this.capacity = capacity;
        this.patients = new Patient[capacity];
        for (int i = 0; i < capacity; ++i) {
            this.patients[i] = new Patient(defaultPatientTransitions);
        }
    }

    public static final Map<Status, Set<Status>> defaultPatientTransitions =
            Map.of(Status.SERIOUSLY_ILL, Set.of(Status.ILL, Status.DISCHARGED),
                    Status.ILL, Set.of(Status.SLIGHTLY_ILL, Status.SERIOUSLY_ILL, Status.DISCHARGED),
                    Status.SLIGHTLY_ILL, Set.of(Status.DISCHARGE_READY, Status.ILL, Status.DISCHARGED),
                    Status.DISCHARGE_READY, Set.of(Status.DISCHARGED, Status.SLIGHTLY_ILL));

    public int getCapacity() {
        return capacity;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }
}
