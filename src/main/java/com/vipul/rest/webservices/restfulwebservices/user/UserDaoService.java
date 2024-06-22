package com.vipul.rest.webservices.restfulwebservices.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Adam",LocalDateTime.now().minusYears(30)));
		users.add(new User(++usersCount,"Eve",LocalDateTime.now().minusYears(25)));
		users.add(new User(++usersCount,"Jim",LocalDateTime.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
}
