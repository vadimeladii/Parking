package md.utm.fcim.usermanagement.business.impl

import md.utm.fcim.usermanagement.business.UserBusiness
import md.utm.fcim.usermanagement.business.dto.UserSecurity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserSecurityServiceImpl(val userBusiness: UserBusiness) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val retrieveByUserName = userBusiness.retrieveByUserName(username)
        if (retrieveByUserName != null) {
            return UserSecurity(
                    retrieveByUserName.roles,
                    retrieveByUserName.password,
                    retrieveByUserName.username,
                    accountNonExpired = true,
                    accountNonLocked = true,
                    credentialsNonExpired = true,
                    enabled = true)
        } else {
            throw UsernameNotFoundException("user" + username + "wasn't fount")
        }
    }
}