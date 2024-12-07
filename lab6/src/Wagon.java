// Интерфейс для общих операций с вагоном
public interface Wagon {
    // Получить и установить регистрационный номер вагона
    String getRegistrationNumber();
    void setRegistrationNumber(String registrationNumber);

    // Получить и установить пункт назначения
    String getDestination();
    void setDestination(String destination);

    // Получить и установить владельца вагона
    String getOwner();
    void setOwner(String owner);

    // Получить и установить статус вагона
    Status getStatus();
    void setStatus(Status status);

    // Узнать снаряженную массу вагона
    double getTareWeight();

    // Операции с вагоном
    void sendToDestination();
    void service();
    void repair();
    void load();
    void unload();

    // Узнать хрупкость или ценность груза
    boolean isFragile();
    boolean isValuable();
}

// Перечисление возможных статусов вагона
enum Status {
    LOADING, UNLOADING, EN_ROUTE, IN_REPAIR, READY_TO_DEPART, NEEDS_REPAIR
}

