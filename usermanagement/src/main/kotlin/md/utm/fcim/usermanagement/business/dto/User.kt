package md.utm.fcim.usermanagement.business.dto

import javax.validation.constraints.NotNull

data class User(val id: Long?,
                @NotNull
                val username: String,
                @NotNull
                val password: String,
                val idParkingLot: Long?)
