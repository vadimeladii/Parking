package md.utm.fcim.usermanagement.webservice.converter

import com.google.common.base.Converter
import md.utm.fcim.usermanagement.business.dto.User
import md.utm.fcim.usermanagement.webservice.view.UserView
import org.springframework.stereotype.Component

@Component
class UserViewConverter : Converter<User, UserView>() {
    override fun doBackward(view: UserView): User {
        return User(
                id = view.id,
                username = view.username,
                password = view.password,
                idParkingLot = view.idParkingLot)
    }

    override fun doForward(dto: User): UserView {
        return UserView(
                id = dto.id,
                username = dto.username,
                password = dto.password,
                idParkingLot = dto.idParkingLot)
    }
}
