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
            this.patients[i] = new Patient();
        }
    }

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
