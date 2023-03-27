import conversation.Conversation;
import conversation.Messages;
import conversation.actions.*;
import model.exceptions.NeedConfirmationException;
import model.exceptions.StopException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void tryExecuteCommand(String command, String[] arguments, Conversation conv, Scanner s) throws StopException {
        try {
            conv.execute(command, arguments);
        } catch (StopException e) {
            throw e;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (NeedConfirmationException e) {
            System.out.print(e.getMessage());
            String confirmation = prettifyInput(s.nextLine());
            if (confirmation.equals("да") || confirmation.equals("yes")) {
                Action action = conv.getCommand(command);
                action.setIsConfirmed(true);
                tryExecuteCommand(command, arguments, conv, s);
                action.setIsConfirmed(false);
                System.out.print(Messages.patientHasBeenDischarged);
            }
            else {
                System.out.print(Messages.patientHasNotBeenDischarged);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void registerAllCommands(Conversation conv) {
        conv.register(new GetStatus(), "get status", "узнать статус пациента");
        conv.register(new StatusUp(), "status up", "повысить статус пациента");
        conv.register(new StatusDown(), "status down", "понизить статус пациента");
        conv.register(new Discharge(), "discharge", "выписать пациента");
        conv.register(new CalculateStatistics(), "calculate statistics", "рассчитать статистику");
        conv.register(new Stop(), "stop", "стоп");
    }

    private static String prettifyInput(String input) {
        return input.trim().toLowerCase();
    }

    public static void main(String[] args) {
        Conversation conv = new Conversation();
        registerAllCommands(conv);

        Scanner s = new Scanner(System.in);
        System.out.print(Messages.enterCommand);

        while (s.hasNextLine()) {
            String command = prettifyInput(s.nextLine());
            int argsAmount = conv.getCommandArgumentsAmount(command);
            String[] arguments = new String[argsAmount];
            ArrayList<String> argMessages = conv.getCommandArgumentMessages(command);
            for (int i = 0; i < argsAmount; ++i) {
                System.out.print(argMessages.get(i));
                String arg = s.nextLine();
                arguments[i] = arg;
            }
            try {
                tryExecuteCommand(command, arguments, conv, s);
            } catch (StopException e) {
                System.out.print(e.getMessage());
                break;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.print(Messages.enterCommand);
        }
    }
}