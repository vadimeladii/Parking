package md.utm.fcim.usermanagement.business.impl

import md.utm.fcim.usermanagement.business.UserBusiness
import md.utm.fcim.usermanagement.business.converter.UserConverter
import md.utm.fcim.usermanagement.business.dto.User
import md.utm.fcim.usermanagement.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserBusinessImpl(val repository: UserRepository,
                       val converter: UserConverter) : UserBusiness {
    override fun retrieve(): List<User?> {
        return repository.findAll().map { userEntity -> converter.convert(userEntity) }
    }

    override fun retrieveById(id: Long): User? {
        return converter.convert(repository.findOne(id))
    }

    override fun create(user: User?): User? {
        return converter.convert(repository.save(converter.reverse().convert(user)))
    }
}