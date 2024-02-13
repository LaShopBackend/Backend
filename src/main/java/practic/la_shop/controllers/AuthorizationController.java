package practic.la_shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import practic.la_shop.dto.AccountDto;
import practic.la_shop.models.Account;
import practic.la_shop.requests.SignInRequest;
import practic.la_shop.responces.SignInResponse;
import practic.la_shop.requests.SignUpRequest;
import practic.la_shop.responces.SignUpResponse;
import practic.la_shop.services.impl.SignUpServiceImpl;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final SignUpServiceImpl signUpService;


//    @GetMapping("/signUp")
//    public String getSignUpPage(Model model) {
//        model.addAttribute("accountDto", new AccountDto());
//        return "signUp";
//    }

//    @PostMapping("/signUp")
//    public String signUp(@Valid AccountDto dto, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute(dto);
//            return "signUp";
//        }
//        signUpService.signUp(dto);
//        return "redirect:/signIn";
//    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(@Valid AccountDto accountDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(accountDto);
            return "deleteAccount";
        }
        signUpService.deleteAccount(accountDto);
        return "redirect:/signIn";
    }

    @PostMapping("/signIn")
    public ResponseEntity<SignInResponse> signIn(@Valid @RequestBody SignInRequest signInRequest) {
        Optional<Account> userOptional = signUpService.validEmailAndPassword(signInRequest.getEmail(), signInRequest.getPassword());
        if (userOptional.isPresent()) {
            Account account = userOptional.get();
            return ResponseEntity.ok(new SignInResponse(account.getId(), account.getEmail(), account.getRole().name()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public SignUpResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (signUpService.hasUserWithEmail(signUpRequest.getEmail())) {
            throw new IllegalArgumentException("DublicateUser");
        }

        AccountDto accountDto = mapSignUpRequestToAccountDto(signUpRequest);
        signUpService.signUp(accountDto);
        return new SignUpResponse(accountDto.getEmail(), accountDto.getPhoneNumber(), accountDto.getPassword());
    }

    AccountDto mapSignUpRequestToAccountDto(SignUpRequest signUpRequest) {
        return AccountDto.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .password(signUpRequest.getPassword())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .role(Account.Role.USER.name())
                .accountState(Account.State.NOT_CONFIRMED.name())
                .personalSale(0)
                .build();
    }
}
