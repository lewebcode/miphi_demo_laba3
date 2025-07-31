package org.miphi.learn.service;

import org.miphi.learn.model.Country;
import org.miphi.learn.model.User;
import org.miphi.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersByCountries(List<String> countryNames) {
        List<Country> countries = countryNames.stream()
                .map(String::toUpperCase)
                .map(Country::valueOf)
                .collect(Collectors.toList());
        return userRepository.findByCountryInOrderByCountryAsc(countries);
    }
}
