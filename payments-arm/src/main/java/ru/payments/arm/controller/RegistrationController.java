package ru.payments.arm.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.payments.arm.dto.request.RegistrationRequest;
import ru.payments.arm.dto.response.ArmResponse;
import ru.payments.arm.service.RegistrationService;

/**
 * Контроллер регистрации
 */
@RestController
@AllArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/signUp")
    public ResponseEntity<ArmResponse<Void>> registration(@RequestBody RegistrationRequest request) {
        registrationService.createUser(request);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
