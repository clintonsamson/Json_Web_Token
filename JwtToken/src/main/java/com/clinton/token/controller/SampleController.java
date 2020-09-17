package com.clinton.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinton.token.model.Auth;
import com.clinton.token.util.JwtTokenUtil;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	private JwtTokenUtil jwtTokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/run")
	private String getRun() {
		return "Ready";
	}

	@PostMapping("/authenticate")
	private String genarateToken(@RequestBody Auth auth) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken((auth.getUserName() + "_" + "CLIENT"), auth.getPassWord()));
		} catch (Exception e) {
			return "Invalid user";
		}
		return jwtTokenUtils.generateToken(auth.getUserName());
	}
}
