package com.example.fourart.controller;

import com.example.fourart.entity.Posting;
import com.example.fourart.form.PostingForm;
import com.example.fourart.service.PostingService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
@Api(tags={"게시판 API"})
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
    @GetMapping(value = "/posting/wanted/new")
    public String createWantedForm(Model model){
        model.addAttribute("form",new PostingForm());
        return "posting/createTeamForm";
    }

    @PostMapping(value = "/posting/wanted/new")
    public String createWanted(PostingForm form){
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
    @PostMapping(value="/posting/delete")
    public void deletePosting(Long id){
        postingService.deletePost(id);
    }
    @PostMapping(value="/posting/{postingId}/viewCountPlus")
    public Long viewCountPlus(@PathVariable("postingId") Long postingId){
        return 0l;
    }

}
