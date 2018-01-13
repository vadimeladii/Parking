package md.utm.fcim.usermanagement.webservice.converter

import com.google.common.base.Converter
import md.utm.fcim.usermanagement.business.dto.Role
import md.utm.fcim.usermanagement.webservice.view.RoleView
import org.springframework.stereotype.Component

@Component
class RoleViewConverter : Converter<Role, RoleView>() {
    override fun doBackward(view: RoleView): Role {
        return Role(id = view.id,
                    name = view.name)
    }

    override fun doForward(dto: Role): RoleView {
        return RoleView(id = dto.id,
                        name = dto.name)
    }
}