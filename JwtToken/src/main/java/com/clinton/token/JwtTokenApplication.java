package com.clinton.token;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.clinton.token.model.Client;
import com.clinton.token.repository.ClientRepository;

@SpringBootApplication
public class JwtTokenApplication {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@PostConstruct
	private void init() {
//		List<Client> clients = Stream.of(new Client(Long.valueOf(101), "admin1", bcryptPasswordEncoder.encode("admin"), null))
//				.collect(Collectors.toList());
//		clientRepository.saveAll(clients);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenApplication.class, args);
	}

}
