package md.utm.fcim.usermanagement.webservice.converter

import com.google.common.base.Converter
import md.utm.fcim.usermanagement.business.dto.User
import md.utm.fcim.usermanagement.webservice.view.UserView
import org.springframework.stereotype.Component

@Component
class UserViewConverter(val roleViewConverter: RoleViewConverter) : Converter<User, UserView>() {

    override fun doBackward(view: UserView): User {
        return User(
                id = view.id,
                username = view.username,
                password = view.password,
                idParkingLot = view.idParkingLot,
                roles = view.roles.map { roleViewConverter.reverse().convert(it) }.toSet())
    }

    override fun doForward(dto: User): UserView {
        return UserView(
                id = dto.id,
                username = dto.username,
                password = dto.password,
                idParkingLot = dto.idParkingLot,
                roles = dto.roles.map { roleViewConverter.convert(it) }.toSet())
    }
}
