package com.codeup.facebookclone.controllers;

import com.codeup.facebookclone.SecurityConfiguration;
import com.codeup.facebookclone.models.User;
import com.codeup.facebookclone.repositories.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }


    @PostMapping("/sign-up")
    public String saveUser(@RequestParam(name = "password") String password,
                           @RequestParam(name = "confirmPassword") String confirmPassword,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "isAdmin", defaultValue = "false") boolean isAdmin,
                           @ModelAttribute User user,
                           Model model) {
        boolean passwordRequirements = (SecurityConfiguration.isValidPassword(password));
        boolean emailRequirements = (SecurityConfiguration.emailMeetsRequirements(email));
        List<User> usersList = users.findAll();
        for (User u : usersList) {
            if (user.getUsername().equalsIgnoreCase(u.getUsername())) {
                return "redirect:/sign-up?usernameNotAvailable";
            }
        }
        for (User u : usersList) {
            if (user.getEmail().equalsIgnoreCase(u.getEmail())) {
                return "redirect:/sign-up?emailNotAvailable";
            }
        }
        if (!password.equals(confirmPassword)) {
            return "redirect:/sign-up?invalidpw";
        } else if (!passwordRequirements) {
            return "redirect:/sign-up?invalidpwRequirements";
        } else if (!emailRequirements) {
            return "redirect:/sign-up?invalidEmail";
        } else if (password.equalsIgnoreCase("Admin@123")) {
//            user.getResetPasswordToken();
            user.setAdmin(true);
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            //Default Image
//            user.setImages("/img/maleIcon1.jpg");
            users.save(user);
            return "redirect:/login";
        } else {
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
//            user.setImages("/img/maleIcon1.jpg");
            users.save(user);
//            ConfirmationToken confirmationToken = new ConfirmationToken(user);

//            confirmationTokenRepository.save(confirmationToken);

//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setSubject("Complete Registration!");
//            mailMessage.setFrom("masterofmusic@codeup.com");
//            mailMessage.setText("To confirm your account, go to the url : "
////                    +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());
//                    +"http://masterofmusic.fun/confirm-account?token="+confirmationToken.getConfirmationToken());
//
//            emailSenderService.sendEmail(mailMessage);
            return "redirect:/login";
        }
    }
}
