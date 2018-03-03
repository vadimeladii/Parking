package md.utm.fcim.notification.impl

import md.utm.fcim.notification.NotificationController
import org.springframework.stereotype.Component

@Component
class NotificationControllerImpl : NotificationController {

    override fun test(): String {
        return "kotlin"
    }
}