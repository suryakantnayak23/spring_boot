package com.org.practice.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j //lombok annotation for log messages
public class AuthenticationEvent {
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent ) {
        log.info("login successful for user:{} "+successEvent.getAuthentication().getName());//in the log message, we are getting the name of the user who logged in successfully
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent)  {
        log.info("login fail for user:{} due to :{}"+failureEvent.getAuthentication().getName());
        failureEvent.getException().getMessage();
    }

}
