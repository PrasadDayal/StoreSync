package com.example.Inventory.controller;

import com.example.Inventory.model.User;
import com.example.Inventory.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(User user, HttpServletRequest request) {

        // Username uniqueness check
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            request.setAttribute("error", "Username already exists");
            return "login";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // default role

        userRepository.save(user);

        // 🔐 AUTO LOGIN
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                );

        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:/dashboard";
    }
}
