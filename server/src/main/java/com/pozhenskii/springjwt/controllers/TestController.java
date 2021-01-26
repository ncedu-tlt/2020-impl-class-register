package com.pozhenskii.springjwt.controllers;

import com.pozhenskii.springjwt.models.User;
import com.pozhenskii.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@PostMapping("/photo")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public void photoUpload(@RequestParam("file")MultipartFile multipartFile,
							  @RequestParam("id")long integer) throws IOException {
		User user = userRepository.findById(integer).get();
		user.setPhoto("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(multipartFile.getBytes()));
		updatePhoto(user);
	}

	@PutMapping("/updatePhoto")
	public void updatePhoto(User user) {
		userRepository.save(user);
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
