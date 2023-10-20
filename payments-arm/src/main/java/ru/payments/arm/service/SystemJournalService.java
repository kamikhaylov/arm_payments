package ru.payments.arm.service;

import lombok.AllArgsConstructor;
import ru.payments.arm.dto.request.SystemJournalRequest;
import ru.payments.arm.dto.response.SystemJournalResponse;
import ru.payments.arm.logger.model.LogModel;
import ru.payments.arm.logger.service.LoggerService;
import ru.payments.arm.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис получения записей системного журнала
 */
@AllArgsConstructor
public class SystemJournalService {

    private LoggerService loggerService;
    private Mapper<LogModel, SystemJournalResponse> systemJournalResponseMapper;

    /**
     * Возвращает список записей из системного журнала
     *
     * @param request запрос
     * @return список записей
     */
    public List<SystemJournalResponse> getSystemJournal(SystemJournalRequest request) {
        List<LogModel> logs = loggerService.findAll();
        return logs.stream()
                       .map(systemJournalResponseMapper::map)
                       .collect(Collectors.toList());
    }
}
