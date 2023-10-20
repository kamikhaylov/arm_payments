package ru.payments.arm.mapper;

import org.modelmapper.ModelMapper;
import ru.payments.arm.dto.response.SystemJournalResponse;
import ru.payments.arm.logger.model.LogModel;

/**
 * Маппер ответа ДАО в ответ для сервиса получения системного журнала
 */
public class SystemJournalResponseMapper implements Mapper<LogModel, SystemJournalResponse> {

    private final ModelMapper mapper;

    public SystemJournalResponseMapper() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }

    @Override
    public SystemJournalResponse map(LogModel logModel) {
        return this.mapper.map(logModel, SystemJournalResponse.class);
    }
}
