package md.utm.fcim.notification

import org.springframework.stereotype.Component

@Component
class NotificationControllerImpl : NotificationController {
    override fun test(): String {
        return "kotlin"
    }
}