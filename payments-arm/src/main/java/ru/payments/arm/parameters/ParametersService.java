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

    /** Возвращает признак включения сервиса вставки типа платежа */
    boolean isMergeTypeServiceEnabled();

    /** Возвращает признак включения сервиса удаления типа платежа */
    boolean isDeleteTypeServiceEnabled();

    /** Возвращает признак включения сервиса регистрации пользователя */
    boolean isSingUpServiceEnabled();
}
