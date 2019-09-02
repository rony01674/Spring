package com.demoproject.controller.memberManagement;

import com.demoproject.entity.memberManagement.Member;
import com.demoproject.repository.attendanceManagement.ClassScheduleRepo;
import com.demoproject.repository.membershipManagement.MemberRepo;
import com.demoproject.repository.membershipManagement.MembersGoalRepo;
import com.demoproject.repository.membershipTypeManagement.MembershipTypeRepo;
import com.demoproject.util.ImageOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class GymMemberController {

    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private MemberRepo repo;

    @Autowired
    private MembersGoalRepo goalRepo;

    @Autowired
    private MembershipTypeRepo typeRepo;

    @Autowired
    private ClassScheduleRepo classRepo;

    @Autowired
    private ImageOptimizer imageOptimizer;


    @GetMapping(value = "/add-member")
    public String addMember(Model model) {
        model.addAttribute("members", new Member());
        model.addAttribute("goal", this.goalRepo.findAll());
        model.addAttribute("msType", this.typeRepo.findAll());
        model.addAttribute("classTime", this.classRepo.findAll());
        return "gym-member/add-member";
    }

    @PostMapping(value = "/add-member")
    public String saveMember(@Valid Member members, @RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return "gym-member/add-member";
        }
        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            ;
            Member member = new Member();
            member.setFileName(file.getOriginalFilename());
            member.setFileSize(file.getSize());
            member.setFilePath("images/" + file.getOriginalFilename());
            member.setFileExtension(file.getContentType());
            this.repo.save(members);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded" + file.getOriginalFilename() + "'");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.8f, 200, 250);
            // Get the file and save it somewhere
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("members", new Member());
        model.addAttribute("goal", this.goalRepo.findAll());
        model.addAttribute("msType", this.typeRepo.findAll());
        model.addAttribute("classTime", this.classRepo.findAll());
        return "redirect:/members-list";
    }


    @GetMapping(value = "/members-list")
    public String showGymMemberList(Model model) {

        model.addAttribute("members", new Member());
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("goal", this.goalRepo.findAll());
        model.addAttribute("msType", this.typeRepo.findAll());
        model.addAttribute("classTime", this.classRepo.findAll());
        return "gym-member/members-list";
    }

    @GetMapping(value = "/edit-member/{mId}")
    public String editView(Model model, @PathVariable("mId") Long id) {
        model.addAttribute("memberEdit", this.repo.getOne(id));
        return "gym-member/edit-member";
    }

    @PostMapping("/edit-member/{mId}")
    public String edit(@Valid Member member, @PathVariable("mId") Long id) {
        this.repo.save(member);
        return "redirect:/member-list";
    }

    @GetMapping(value = "/member-profile")
    public String memberProfile() {
        return "gym-member/member-profile";
    }
}
