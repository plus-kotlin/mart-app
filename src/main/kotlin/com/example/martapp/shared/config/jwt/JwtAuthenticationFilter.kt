package com.example.martapp.shared.config.jwt

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.SignatureException
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.util.*


@RequiredArgsConstructor
@Component
class JwtAuthenticationFilter(
    private val userDetailsService: UserDetailsService,
    private val jwtTokenUtil: JwtTokenUtil
) : OncePerRequestFilter() {
    var HEADER_STRING = "Authorization"
    var TOKEN_PREFIX = "Bearer "

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header: String = request.getHeader(HEADER_STRING)
        var username: String? = null
        var authToken: String? = null
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX, "")
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken)
            } catch (e: IllegalArgumentException) {
                logger.error("an error occured during getting username from token", e)
            } catch (e: ExpiredJwtException) {
                logger.warn("the token is expired and not valid anymore", e)
            } catch (e: SignatureException) {
                logger.error("Authentication Failed. Username or Password not valid.")
            }
        } else {
            logger.warn("couldn't find bearer string, will ignore the header")
        }
        if (username != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = userDetailsService!!.loadUserByUsername(username)
            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails, null, Arrays.asList(SimpleGrantedAuthority("ROLE_ADMIN"))
                )
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                logger.info("authenticated user $username, setting security context")
                SecurityContextHolder.getContext().authentication = authentication
            }
        }
        filterChain.doFilter(request, response)
    }
}
