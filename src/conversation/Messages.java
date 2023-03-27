package conversation;

public class Messages {
    public static final String enterCommand = "Введите команду: ";
    public static final String enterPatientsId = "Введите ID пациента: ";
    public static final String dischargeConfirmation = "Желаете этого клиента выписать? (да/нет): ";
    public static final String patientHasBeenDischarged = "Пациент выписан из больницы\n";
    public static final String patientHasNotBeenDischarged = "Пациент остался в статусе \"Готов к выписке\"\n";
    public static final String brokenIdInput = "Ошибка. ID пациента должно быть числом (целым, положительным)\n";
    public static final String invalidIdInput = "Ошибка. В больнице нет пациента с таким ID\n";
    public static final String stop = "Сеанс завершён.\n";
    public static final String newPatientStatus = "Новый статус пациента: ";
    public static final String errorStatusDown = "Ошибка. Нельзя понизить самый низкий статус (наши пациенты не умирают)\n";
    public static final String transitionIsNotAllowed = "Переход между стаусами запрещён.\n";
    public static final String errorAlreadyDischarged = "Ошибка. Пациент выписан, операция недоступна.\n";
    public static final String patientsStatus = "Статус пациента: ";
    public static final String illegalAction = "Неизвестная команда! Попробуйте ещё раз";
}
