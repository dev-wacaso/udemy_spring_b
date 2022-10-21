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

    @ModelAttribute(AttributeNames.PATH_MAPPINGS_HOME)
    public String pathMappingsHome() {
        log.info("pathMappingsHome");
        return PathMappings.HOME;
    }

    @ModelAttribute(AttributeNames.PATH_MAPPINGS_PLAY)
    public String pathMappingsPlay() {
        log.info("pathMappingsPlay");
        return PathMappings.PLAY;
    }

    @ModelAttribute(AttributeNames.PATH_MAPPINGS_START_OVER)
    public String pathMappingsStartOver() {
        log.info("pathMappingsStartOver");
        return PathMappings.START_OVER;
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

    @GetMapping(PathMappings.START_OVER)
    public String startOver(Model model) {
        log.info("startOver() called...");
        service.reset();

        return PathMappings.REDIRECT_PLAY;
    }

    @GetMapping(PathMappings.PLAY)
    public String doGetPlay(Model model) {
        log.info("doGetPlay() called...");

        return service.isGimeOver() ? WebViewNames.GIME_OVER : WebViewNames.PLAY;
    }

    @PostMapping(PathMappings.PLAY)
    public String doPostPlay(@RequestParam int guess) {
        log.info("doPostPlay() called...");
        service.checkGuess(guess);
        return PathMappings.REDIRECT_PLAY;
    }
}
