package utils;

import model.Status;

import java.util.Map;
import java.util.Set;

public class Config {
    public static final int departmentCapacity = 200;
    public static final Map<Status, Set<Status>> defaultPatientTransitions =
            Map.of(Status.SERIOUSLY_ILL, Set.of(Status.ILL, Status.DISCHARGED),
                    Status.ILL, Set.of(Status.SLIGHTLY_ILL, Status.SERIOUSLY_ILL, Status.DISCHARGED),
                    Status.SLIGHTLY_ILL, Set.of(Status.DISCHARGE_READY, Status.ILL, Status.DISCHARGED),
                    Status.DISCHARGE_READY, Set.of(Status.DISCHARGED, Status.SLIGHTLY_ILL));
}
