package com.isquibly.controller;

import com.isquibly.service.GimeService;
import com.isquibly.util.AttributeNames;
import com.isquibly.util.PathMappings;
import com.isquibly.util.WebViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class WebController {
    private final GimeService service;

    @Autowired
    public WebController(GimeService service) {
        this.service = service;
    }

    @ModelAttribute(AttributeNames.MAIN_MESSAGE)
    public String mainMessage() {
//        return "service.getMainMessage()";
        return service.getMainMessage();
    }

    @ModelAttribute(AttributeNames.RESULT_MESSAGE)
    public String resultMessage() {
//        return "service.getResultMessage()";
        return service.getResultMessage();
    }

    @ModelAttribute(AttributeNames.FORM_ACTION_HOME)
    public String formActionHome() {
        log.info("formActionHome");
        return PathMappings.HOME;
    }

    @ModelAttribute(AttributeNames.FORM_ACTION_PLAY)
    public String formActionPlay() {
        log.info("formActionPlay");
        return PathMappings.PLAY;
    }


//    @ModelAttribute(AttributeNames.PLAY_URL)
//    public String playUrl() {
////        return "service.getResultMessage()";
//        return "GOT IT!";
////        return PathMappings.PLAY;
//    }

//    @ModelAttribute
//    public void addAttributes(Model model) {
//        model.addAttribute("playUrl", "applesauce");
//    }

    @GetMapping(PathMappings.PLAY)
    public String doGetPlay(Model model) {
        log.info("doGetPlay() called...");
//        model.addAttribute("playUrl", "cheeseburger");
//        model.addAttribute(AttributeNames.MAIN_MESSAGE, service.getMainMessage());
//        model.addAttribute(AttributeNames.RESULT_MESSAGE, service.getResultMessage());
        return service.isGimeOver() ? WebViewNames.GIME_OVER : WebViewNames.PLAY;
    }

    @PostMapping(PathMappings.PLAY)
    public String doPostPlay(@RequestParam int guess) {
        log.info("doPostPlay() called...");
        service.checkGuess(guess);
        return PathMappings.REDIRECT_PLAY;
    }
}
