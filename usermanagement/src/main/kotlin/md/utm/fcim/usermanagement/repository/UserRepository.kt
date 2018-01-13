package md.utm.fcim.usermanagement.repository

import md.utm.fcim.usermanagement.repository.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}