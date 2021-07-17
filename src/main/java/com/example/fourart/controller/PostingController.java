package com.example.fourart.controller;

import com.example.fourart.entity.Posting;
import com.example.fourart.form.PostingForm;
import com.example.fourart.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @GetMapping(value = "/posting/new")
    public String createForm(Model model){
        model.addAttribute("form",new PostingForm());
        return "posting/createTeamForm";
    }

    @PostMapping(value = "/posting/new")
    public String create(PostingForm form){
        Posting posting = new Posting();
        postingService.savePosting(posting);
        return "redirect:/teams";
    }

    @GetMapping(value = "/postings")
    public String list(Model model){
        //postingService에서 findPostings 구현
        List<Posting> teams = postingService.findPostings();
        return "";
    }
    @GetMapping(value ="/postings/{postingId}/edit")
    public String editPostingForm(@PathVariable("postingId") Long postingId, Model model){
        Posting team = (Posting) postingService.findOne(postingId);
        PostingForm form = new PostingForm();
        model.addAttribute("form",form);
        return "posting/updatePostingForm";
    }
    @PostMapping(value = "/postings/{postingId}/edit")
    public String updatePosting(@ModelAttribute("form") PostingForm form){

        postingService.updatePosting(form.getId(),form.getTitle(),form.getContent());
        return "redirect:/postings";
    }

}
