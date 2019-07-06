package com.springfileupload;

import com.springfileupload.util.ImageOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UserController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private UserRepository repo;

    @Autowired
    private ImageOptimizer imageOptimizer;

    //This method is for display index page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws IOException{
        ModelAndView mv  = new ModelAndView();

        mv.addObject("list",repo.findAll());
        mv.setViewName("index");
        return mv;
    }

    @PostMapping("/upload") // new annotation since 4.3
    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException{
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            User user = new User();
            user.setFileName("new"+file.getOriginalFilename());
            user.setFileSize(file.getSize());
            user.setFilePath("images/"+"new"+file.getOriginalFilename());
            user.setFileExtension(file.getContentType());
            repo.save(user);
            System.out.println("============ Successfully Saved ============");
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded"+file.getOriginalFilename()+"'");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file,0.8f,200,250);
            // Get the file and save it somewhere
        }catch (IOException e){
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping(value = "/uploadStatus")
    public String uploadStatus(){
        return"success";
    }


}
