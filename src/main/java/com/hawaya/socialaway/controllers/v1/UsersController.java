package com.hawaya.socialaway.controllers.v1;

import com.hawaya.socialaway.domains.User;
import com.hawaya.socialaway.payloads.CreateUserRequest;
import com.hawaya.socialaway.payloads.QueryUsersRequest;
import com.hawaya.socialaway.repostories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("v1/api")
public class UsersController {
    UserRepository userRepository;

    @Autowired
    public void UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        try {
            User _user = userRepository.save(new User( createUserRequest.getName(),createUserRequest.getInfo(),
                    createUserRequest.getEmail(),createUserRequest.getGender(),createUserRequest.getPreferences(),
                    createUserRequest.getLocation()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users/query")
    public ResponseEntity<Object> queryUsers(@Valid @RequestBody QueryUsersRequest payload, @RequestHeader("X-UserID")
            String userID) {
        try {
            if (userID.equals("")){
                return new ResponseEntity<>("invalid user id or missing", HttpStatus.UNAUTHORIZED);
            }

            User user = userRepository.findById(userID).get();
            QueryUsersByLocation q = new QueryUsersByLocation(payload.getLocation().get(0),payload.getLocation().get(1),
                    payload.getDistance(),userID, payload.getPage(),payload.getLimit(),user.getPreferences() );
            List<User> users = userRepository.listByGEOLocation(q);
            return new ResponseEntity<>(users,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleMessageNotFoundExceptions(HttpMessageNotReadableException ex) {
        Map<String, String> errors = new HashMap<>();
       errors.put("error","missing request body");
        return errors;
    }
}
