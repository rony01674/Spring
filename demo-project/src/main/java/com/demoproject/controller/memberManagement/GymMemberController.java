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
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/members-list")
    public String showGymMemberList(Model model) {

        model.addAttribute("members", new Member());
        model.addAttribute("list",this.repo.findAll());
        model.addAttribute("goal", this.goalRepo.findAll());
        model.addAttribute("msType", this.typeRepo.findAll());
        model.addAttribute("classTime", this.classRepo.findAll());
        return "gym-member/members-list";
    }

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
                             RedirectAttributes redirectAttributes, Model model) throws IOException {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select your photo");
            return "redirect:/add-member";
        }
        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            ;
            Member member = new Member();
            member.setFileName("new" + file.getOriginalFilename());
            member.setFileSize(file.getSize());
            member.setFilePath("images/" + "new" + file.getOriginalFilename());
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
        return "gym-member/add-member";
    }

    @GetMapping(value = "/member-profile")
    public String memberProfile() {
        return "gym-member/member-profile";
    }
}
