package kr.ac.ks.twitterclone;

import kr.ac.ks.twitterclone.controller.FileUploadController;
import kr.ac.ks.twitterclone.model.User;
import kr.ac.ks.twitterclone.service.TwitterCloneUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.security.Principal;

public class TwitterCloneUtil {
    private static String noIcon;

    public static String[] imageExtensions = {"jpg", "jpeg", "png", "gif"};

    public static User getLoginuserFromPrincipal(Principal principal) {
        Authentication authentication = (Authentication) principal;
        TwitterCloneUserDetails userDetails = TwitterCloneUserDetails.class.cast(authentication.getPrincipal());
        return userDetails.getuser();
    }

    public static void updateAuthenticate(Principal principal, User newUser) {
        Authentication oldAuth = (Authentication) principal;
        Authentication newAuth = new UsernamePasswordAuthenticationToken(new TwitterCloneUserDetails(newUser), oldAuth.getCredentials(), oldAuth.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }

    public static String getNoIcon() {
        if (noIcon == null)
            noIcon = MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", "noicon.png").build().toString();
        return noIcon;
    }
}
