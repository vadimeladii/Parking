package md.utm.fcim.usermanagement.business.converter

import com.google.common.base.Converter
import md.utm.fcim.usermanagement.business.dto.Role
import md.utm.fcim.usermanagement.repository.entity.RoleEntity
import org.springframework.stereotype.Component

@Component
class RoleConverter : Converter<RoleEntity, Role>() {
    override fun doBackward(dto: Role): RoleEntity {
        return RoleEntity(
                id = dto.id,
                name = dto.name)
    }

    override fun doForward(entity: RoleEntity): Role {
        return Role(
                id = entity.id,
                name = entity.name)
    }
}