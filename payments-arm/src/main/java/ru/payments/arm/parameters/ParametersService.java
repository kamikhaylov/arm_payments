package ru.payments.arm.parameters;

/**
 * Интерфейс сервиса управления параметрами.
 */
public interface ParametersService {

    /** Возвращает признак включения сервиса получения списка платежей */
    boolean isListServiceEnabled();

    /** Возвращает признак включения сервиса получения детальной информации платежа */
    boolean isDetailsServiceEnabled();

    /** Возвращает признак включения сервиса получения метрик мониторинга */
    boolean isMonitoringServiceEnabled();

    /** Возвращает признак включения сервиса получения записей системного журнала */
    boolean isSystemJournalServiceEnabled();

    /** Возвращает признак включения сервиса получения списка типов платежей */
    boolean isTypeListServiceEnabled();
}
