package md.utm.fcim.usermanagement.webservice.view

import com.fasterxml.jackson.annotation.JsonProperty

data class UserView (
        val id: Long? = null,
        val username: String,
        val password: String,
        @JsonProperty(value = "parking_lot")
        val idParkingLot: Long? = null)