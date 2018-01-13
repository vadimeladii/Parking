package md.utm.fcim.usermanagement.webservice.impl

import md.utm.fcim.usermanagement.business.UserBusiness
import md.utm.fcim.usermanagement.business.dto.UserLogin
import md.utm.fcim.usermanagement.webservice.UserController
import md.utm.fcim.usermanagement.webservice.converter.UserViewConverter
import md.utm.fcim.usermanagement.webservice.view.UserView
import org.springframework.stereotype.Component
import javax.ws.rs.core.Response

@Component
class UserControllerImpl(val business: UserBusiness,
                         val converter: UserViewConverter) : UserController {
    override fun retrieve(): Response {
        return Response.ok()
                .entity(business.retrieve().map { converter.convert(it) })
                .build()
    }

    override fun retrieveById(id: Long): Response {
        return Response.ok()
                .entity(converter.convert(business.retrieveById(id)))
                .build()
    }

    override fun create(userView: UserView): Response {
        return Response.ok()
                .entity(converter.convert(business.create(converter.reverse().convert(userView))))
                .build()
    }

    override fun login(userLogin: UserLogin): Response {
        return Response.ok()
                .entity(business.login(userLogin))
                .build()
    }
}
