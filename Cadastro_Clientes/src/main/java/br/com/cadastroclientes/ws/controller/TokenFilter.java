package br.com.cadastroclientes.ws.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException{
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Autorization");
		
		if(header==null || !header.startsWith("Beare ")) {
			throw new ServletException("Token inexistente ou invalido");
		}
		
		String token = header.substring(7);
		
		try {
			Jwts.parser().setSigningKey("cript").parseClaimsJws(token).getBody();
		}catch (SignatureException x) {
			throw new ServletException("Token Invalido");
		}
		
		chain.doFilter(request, response);
		
		
	}
	
}
