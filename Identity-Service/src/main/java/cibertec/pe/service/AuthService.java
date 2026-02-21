package cibertec.pe.service;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import cibertec.pe.config.CustomUserDetailsService;
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
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    // Crea el admin inicial automáticamente al iniciar el servicio
    @PostConstruct
    public void crearAdminInicial() {
        if (repository.findByEmail("admin@cibertec.pe").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setEmail("admin@cibertec.pe");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");
            repository.save(admin);
            System.out.println("Admin inicial creado: admin@cibertec.pe / admin123");
        }
    }
    
    public String saveUser(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        repository.save(usuario);
        return "Usuario registrado correctamente";
    }
    
    public String generateToken(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return jwtService.generateToken(userDetails);
    }
}