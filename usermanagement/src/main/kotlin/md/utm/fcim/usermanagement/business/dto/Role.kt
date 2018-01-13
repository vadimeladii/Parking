package md.utm.fcim.usermanagement.business.dto

import org.springframework.security.core.GrantedAuthority
import javax.validation.constraints.NotNull

data class Role(val id: Long?,
                @NotNull
                val name: String) : GrantedAuthority {

    override fun getAuthority(): String {
        return name
    }
}