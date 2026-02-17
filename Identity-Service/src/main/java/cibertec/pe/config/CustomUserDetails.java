package cibertec.pe.config;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cibertec.pe.model.Usuario;
import io.jsonwebtoken.lang.Collections;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;

    public CustomUserDetails(Usuario usuario) {
        this.username = usuario.getName();
        this.password = usuario.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
