package md.utm.fcim.usermanagement.business.dto

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserAuthentication(val user: UserDetails) : Authentication {

    private var authenticated: Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return this.user.authorities
    }

    override fun setAuthenticated(isAuthenticated: Boolean) {
        this.authenticated = isAuthenticated
    }

    override fun getName(): String {
        return this.user.username
    }

    override fun getCredentials(): Any {
        return this.user.password
    }

    override fun getPrincipal(): Any {
        return this.user
    }

    override fun isAuthenticated(): Boolean {
        return this.authenticated
    }

    override fun getDetails(): Any {
        return this.user
    }
}