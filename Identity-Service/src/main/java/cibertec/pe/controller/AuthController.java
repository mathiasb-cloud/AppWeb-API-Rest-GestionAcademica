package cibertec.pe.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import cibertec.pe.model.Usuario;
import cibertec.pe.model.dto.AuthRequest;
import cibertec.pe.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService service;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    // Login público
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String token = service.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }
    
    // Auto-registro de alumnos (público)
    @PostMapping("/register/alumno")
    public ResponseEntity<String> registerAlumno(@RequestBody Usuario usuario) {
        
        usuario.setRole("ALUMNO");
        String resultado = service.saveUser(usuario);
        return ResponseEntity.ok(resultado);
    }
    
    // Solo ADMIN puede crear docentes
    @PostMapping("/register/docente")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> registerDocente(@RequestBody Usuario usuario) {
        
        usuario.setRole("DOCENTE");
        String resultado = service.saveUser(usuario);
        return ResponseEntity.ok(resultado);
    }
    
    // Solo ADMIN puede crear otros admins
    @PostMapping("/register/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> registerAdmin(@RequestBody Usuario usuario) {
        
        usuario.setRole("ADMIN");
        String resultado = service.saveUser(usuario);
        return ResponseEntity.ok(resultado);
    }
    
    
    @GetMapping("/test")
    public String test() {
        return "Auth service funcionando";
    }
}