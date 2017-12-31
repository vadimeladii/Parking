package md.utm.fcim.usermanagement.business

import md.utm.fcim.usermanagement.business.dto.User
import org.springframework.validation.annotation.Validated
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Validated
interface UserBusiness {
    fun retrieve(): List<User?>

    fun retrieveById(@NotNull id: Long) : User?

    fun create(@Valid user: User?): User?
}