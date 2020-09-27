package com.depeexi.securitytest.config;

import com.depeexi.securitytest.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Resource
    private UserDetailsService userDetailsService;

    @Value("${jwt.header}")
    private String tokenHeader;
//
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String requestHeader  =  request.getHeader(this.tokenHeader);
        String authToken = null;
        String username = null;
        logger.info(requestHeader);
        //当前请求中包含令牌
        if(requestHeader!=null && requestHeader.startsWith(this.tokenHead)){
            authToken = requestHeader.substring(tokenHead.length());
            try {
                //根据令牌信息获取用户名
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            }catch (IllegalArgumentException e){
                logger.error("an error occured during getting username from the token ",e);
            }catch (ExpiredJwtException e){
                logger.error("the token is Expried and not invalid anymore",e);
            }

        }else{
            logger.error("couldn't find Beared String,will ignore the request");
        }
        logger.info("checking Authentication with username : " + username);

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails =  userDetailsService.loadUserByUsername(username
            );
            if(jwtTokenUtil.validateToken(authToken,userDetails)){
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info("authorication user: "+username+", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request,response);
    }

}
