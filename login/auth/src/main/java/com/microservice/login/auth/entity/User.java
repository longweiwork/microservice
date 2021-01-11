package com.microservice.login.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

/**
 * @author lw
 * @date 2020/11/25 11:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    private String id;
    private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**账户默认为过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**账户默认未锁定
     * @return
     */
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
