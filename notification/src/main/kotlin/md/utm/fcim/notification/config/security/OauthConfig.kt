package md.utm.fcim.notification.config.security

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableOAuth2Sso
@Configuration
class OauthConfig : WebSecurityConfigurerAdapter() {


    @Throws(Exception::class)
    protected fun configure(http: HttpSecurity) {

        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated()

    }
}
