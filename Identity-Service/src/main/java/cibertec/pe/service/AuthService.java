package cibertec.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cibertec.pe.model.Usuario;
import cibertec.pe.repository.IUsuarioRepository;

@Service
public class AuthService {
    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(Usuario usuario) {
        try{
        	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            repository.save(usuario);
            return "Usuario registrado.";
        } catch (Exception e) {
            System.out.println("Usuario no registrado:".concat(e.getMessage()));
            return "Usuario No registrado.";
        }
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
