package md.utm.fcim.usermanagement.business.impl

import javassist.NotFoundException
import md.utm.fcim.usermanagement.business.UserBusiness
import md.utm.fcim.usermanagement.business.converter.UserConverter
import md.utm.fcim.usermanagement.business.dto.Token
import md.utm.fcim.usermanagement.business.dto.User
import md.utm.fcim.usermanagement.business.dto.UserLogin
import md.utm.fcim.usermanagement.repository.UserRepository
import md.utm.fcim.usermanagement.repository.entity.UserEntity
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserBusinessImpl(val repository: UserRepository,
                       val converter: UserConverter,
                       val tokenHandler: TokenHandler) : UserBusiness {

    override fun retrieve(): List<User?> {
        return repository.findAll().map { userEntity -> converter.convert(userEntity) }
    }

    override fun retrieveById(id: Long): User? {
        return converter.convert(repository.findOne(id))
    }

    override fun create(user: User?): User? {
        return converter.convert(repository.save(converter.reverse().convert(user)))
    }

    override fun retrieveByUserName(username: String): User? {
        return converter.convert(repository.findByUsername(username))
    }

    override fun login(userLogin: UserLogin): Token? {
        return repository.
                findByUsername(userLogin.username)
                ?.let { createTokenByUsername(it) }
                ?: throw NotFoundException("User Entity with username: ${userLogin.username} not fount")
    }

    fun createTokenByUsername(userEntity: UserEntity): Token {
        return Token(token = tokenHandler.generateAccessToken(
                username = userEntity.username,
                localDateTime = LocalDateTime.now().plusHours(4L)!!))
    }
}
