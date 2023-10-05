package com.example.martapp.shared.config.security

import com.example.martapp.shared.config.jwt.JwtAuthenticationEntryPoint
import com.example.martapp.shared.config.jwt.JwtAuthenticationFilter
import com.example.martapp.shared.config.util.HtmlCharacterEscapes
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@EnableWebSecurity(debug = true) // 디버깅 용도로 debug 옵션을 추가했습니다.
class WebSecurityConfig(
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val jwtRequestFilter: JwtAuthenticationFilter,
    private val accessDeniedHandler: AccessDeniedHandler,
) {

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf { disable() }
            headers { frameOptions { disable() } }
            cors { }
            authorizeRequests {
                authorize(HttpMethod.POST, "/user", authenticated)

                /** 아래 네개 형태를 조합하여 사용
                // 인증과정 필요함
                //authorize(HttpMethod.GET,"test/url", authenticated)

                // 인증과정 필요 없음
                //authorize(HttpMethod.GET,"test/url", permitAll)

                // 그 외 모든 요청은 인증과정 필요
                //authorize(anyRequest, authenticated)

                // 그 외 모든 요청은 허용
                authorize(anyRequest, permitAll)
                 **/
                authorize(anyRequest, permitAll)
            }
            // 정상적인 토큰이 없을 경우
            exceptionHandling {
                authenticationEntryPoint = jwtAuthenticationEntryPoint
            }
            // 정상적인 토큰이지만 권한이 다른 경우
            exceptionHandling {
                accessDeniedHandler
            }
            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }

        }

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build();  // build를 호출하여 Security Filter Chain 객체를 반환합니다.
    }

    @Bean
    fun encodePassword(): BCryptPasswordEncoder? = BCryptPasswordEncoder()

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = CorsConfiguration()
        configuration.addAllowedOriginPattern("*")
        configuration.allowedMethods =
            mutableListOf("GET", "POST", "PUT", "PATCH", "OPTIONS", "DELETE")
        configuration.allowedHeaders = mutableListOf("*")
        configuration.allowCredentials = true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

    // Spring Boot는 Jackson 라이브러리가 포함되어 있어서 자동으로 MappingJackson2HttpMessageConverter를 사용하여 JSON으로 변환한다.
    @Bean
    fun jsonEscapeConverter(): MappingJackson2HttpMessageConverter {
        val objectMapper = Jackson2ObjectMapperBuilder.json().build<ObjectMapper>()
        objectMapper.factory.setCharacterEscapes(HtmlCharacterEscapes())

        return MappingJackson2HttpMessageConverter(objectMapper);
    }
}