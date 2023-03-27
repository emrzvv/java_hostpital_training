package conversation.actions;

import model.Department;
import model.Patient;
import model.Status;

import java.util.Map;
import java.util.TreeMap;

public class CalculateStatistics extends AbstractAction {

    @Override
    public void execute(Department department, String[] args) throws Exception {
        Patient[] patients = department.getPatients();
        TreeMap<Status, Integer> counter = new TreeMap<>();
        for (int i = 0; i < department.getCapacity(); ++i) {
            Status currentStatus = patients[i].getStatus();
            counter.put(currentStatus, counter.getOrDefault(currentStatus, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("В больнице на данный момент находится ")
                .append(department.getCapacity() - counter.getOrDefault(Status.DISCHARGED, 0))
                .append(" чел., из них:\n");
        counter.remove(Status.DISCHARGED);

        for (Map.Entry<Status, Integer> entry: counter.entrySet()) {
            builder.append("\t\t- в статусе ")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(" чел.\n");
        }
        System.out.print(builder);
    }
}
