package com.clinton.token.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinton.token.model.Client;
import com.clinton.token.repository.ClientRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username != null && !username.trim().equals("")) {

			Client client = clientRepository.findByClientName(username.split("_")[0]);
			if (client == null) {
				throw new UsernameNotFoundException(" No user ");
			}
			return new User(client.getClientName(), client.getPassword(), new ArrayList<>());
		}

		return null;
	}

}
