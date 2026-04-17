package br.com.edbruno.apiusuarios.controller;

import br.com.edbruno.apiusuarios.dto.LoginRequestDTO;
import br.com.edbruno.apiusuarios.dto.LoginResponseDTO;
import br.com.edbruno.apiusuarios.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        LoginResponseDTO response = authService.login(dto);
        return ResponseEntity.ok(response);
    }
}