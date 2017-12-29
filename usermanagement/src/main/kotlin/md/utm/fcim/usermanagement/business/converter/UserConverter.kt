package md.utm.fcim.usermanagement.business.converter

import com.google.common.base.Converter
import md.utm.fcim.usermanagement.business.dto.User
import md.utm.fcim.usermanagement.repository.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserConverter : Converter<UserEntity, User>() {
    override fun doForward(entity: UserEntity): User {
        return User(
                id = entity.id,
                username = entity.username,
                password = entity.password,
                idParkingLot = entity.idParkingLot)
    }

    override fun doBackward(dto: User): UserEntity {
        return UserEntity(
                id = dto.id,
                username = dto.username,
                password = dto.password,
                idParkingLot = dto.idParkingLot)
    }
}