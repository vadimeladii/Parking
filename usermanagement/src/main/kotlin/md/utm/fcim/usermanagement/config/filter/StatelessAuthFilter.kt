package md.utm.fcim.usermanagement.config.filter

import md.utm.fcim.usermanagement.business.impl.TokenAuthenticationServiceImpl
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@Component
class StatelessAuthFilter(val tokenAuthService: TokenAuthenticationServiceImpl) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        SecurityContextHolder.getContext().authentication = tokenAuthService.getAuthentication(request = request as HttpServletRequest)
        chain.doFilter(request, response)
    }
}