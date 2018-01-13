package md.utm.fcim.usermanagement.business.dto

import org.springframework.security.core.userdetails.UserDetails

data class UserSecurity(private val authorities: Set<Role?>,
                   private val password: String,
                   private val username: String,
                   private val accountNonExpired: Boolean,
                   private val accountNonLocked: Boolean,
                   private val credentialsNonExpired: Boolean,
                   private val enabled: Boolean) : UserDetails {

    override fun getAuthorities(): Set<Role?> {
        return authorities
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    override fun getUsername(): String {
        return username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return credentialsNonExpired
    }

    override fun getPassword(): String {
        return password
    }

    override fun isAccountNonExpired(): Boolean {
        return accountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return accountNonLocked
    }
}
