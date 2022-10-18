package com.isquibly.controller;

import com.isquibly.service.GimeService;
import com.isquibly.util.PathMappings;
import com.isquibly.util.WebViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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

    @ModelAttribute("mainMessage")
    public String handleMainMessage() {
        return "service.getMainMessage()";
//        return service.getMainMessage();
    }

    @ModelAttribute("resultMessage")
    public String handleResultMessage() {
        return "service.getResultMessage()";
//        return service.getResultMessage();
    }

    @GetMapping(PathMappings.PLAY)
    public String handlePlay(Model model) {
        return service.isGimeOver() ? WebViewNames.GIME_OVER : WebViewNames.PLAY;
    }

//    @PostMapping(PathMappings.PLAY)
//    @Autowired
//    public String handleGuess(@RequestParam int guess, Model model) {
//        service.checkGuess(guess);
//        return PathMappings.REDIRECT_PLAY;
//    }
}
