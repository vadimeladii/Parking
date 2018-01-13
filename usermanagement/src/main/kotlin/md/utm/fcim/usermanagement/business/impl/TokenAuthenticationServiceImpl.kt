package md.utm.fcim.usermanagement.business.impl

import md.utm.fcim.usermanagement.business.dto.UserAuthentication
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class TokenAuthenticationServiceImpl(val userSecurityServiceImpl: UserSecurityServiceImpl,
                                     val tokenHandler: TokenHandler) {

    private var AUTH_TOKEN_HEADER = "X-Auth-Token"

    fun getAuthentication(request: HttpServletRequest): Authentication? {
        return if(!request.getHeader(AUTH_TOKEN_HEADER).isNullOrEmpty()) {
            request.getHeader(AUTH_TOKEN_HEADER)
                    .let { tokenHandler.extractUsername(it) }
                    .let { userSecurityServiceImpl.loadUserByUsername(it) }
                    .let { UserAuthentication(it) }
        } else {
            null
        }
    }
}
