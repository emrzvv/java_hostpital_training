`src/model/Status.java`: 
enum, обозначения состояний (0-5) пациента. в силу "простоты" переходов между состояниями имеет методы получения следующего и предыдущего состояний.

`src/model/automata/FSM.java`: 
абстракция конечного автомата, имеет метод установления нового состояния с возможностью валидацией перехода и метод получения текущего состояния.

`src/model/Patient.java`:
сущность пациент, содержит конечный автомат состояний (Status) с определёнными переходами между ними, доступны операции повышения/понижения состояния, перехода в финальное состояние, получения текущего состояния. 

`src/model/Department.java`:
сущность больница (отделение), содержит контейнер пациентов фиксированного размера

`src/model/exceptions/InvalidTransitionException.java`: exception, выбрасываемый при невалидированном переходе между состояниями автомата

`src/model/exceptions/NeedConfirmationException.java`: exception, выбрасываемый при исполнении команды, когда требуется подтверждение

`src/model/exceptions/StopException.java`: exception, выбрасываемый при остановке программы

`src/conversation/Conversation.java`: сущность, управляющая диалогом: регистрация команд, выполнение команд, получение данных об аргументах команды

`src/conversation/Messages.java`: сообщения для пользовательского интерфейса

`src/conversation/Validators.java`: методы валидации

`src/actions/Action.java` / `AbastractAction.java`: интерфейс и абстрактный класс действия (команды). 
интерфейс есть контракт, объединяющий все команды, нужен для удобного взаимодействия с командами в `Conversation` и `Main`, 
асбтрактный класс нужен для хранения общих полей команд, например, количества аргументов и сообщений, которые должны показываться пользователю при вводе аргументов


остальные классы в `src/conversation/actions` представляют собой классы, имплементирующие абстрактный класс `AbstractAction` с переопределённым методом `execute`,
соответствуют командам, описанным в задаче. за исключением `IllegalAction` - действие, выполняющееся при неверном указании команды пользователем.

взаимодействие с пользователем описано в `Main`