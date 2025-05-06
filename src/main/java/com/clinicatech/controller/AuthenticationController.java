package com.clinicatech.controller;

import com.clinicatech.model.Usuario;
import com.clinicatech.repository.UsuarioRepository;
import com.clinicatech.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario user = usuarioRepository.findByUsername(usuario.getUsername());

        if (user != null && passwordEncoder.matches(usuario.getPassword(), user.getPassword())) {
            String token = jwtTokenProvider.generateToken(user.getUsername());
            return ResponseEntity.ok("Bearer " + token);
        } else {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos.");
        }
    }
}
