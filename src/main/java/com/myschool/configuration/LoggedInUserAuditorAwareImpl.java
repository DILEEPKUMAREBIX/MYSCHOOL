package com.myschool.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class LoggedInUserAuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO: need to replace below name with logged in user details
		return Optional.of("Dileep");
	}
}