package md.utm.fcim.usermanagement.business.impl

import com.google.common.io.BaseEncoding
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.sql.Date
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class TokenHandler {

    private val secretKey: SecretKey

    init {
        val jwtKey = "jwt123456789"
        val decode = BaseEncoding.base64().decode(jwtKey)
        this.secretKey = SecretKeySpec(decode, 0, decode.size, "AES")
    }

    fun extractUsername(token: String): String {
        val claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
        val body = claimsJws.body
        return body.get("username", String::class.java).toString()

    }

    fun generateAccessToken(id: Long, localDateTime: LocalDateTime): String {
        return Jwts.builder()
                .setId(id.toString())
                .setExpiration(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact()
    }

    fun generateAccessToken(username: String, localDateTime: LocalDateTime): String {
        return Jwts.builder()
                .setClaims(generateMapFromString(username))
                .setExpiration(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact()
    }

    private fun generateMapFromString(username: String): Map<String, Any> {
        val map = HashMap<String, Any>()
        map.put("username", username)
        return map
    }
}
