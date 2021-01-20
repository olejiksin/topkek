package k.te.kest.controller;

import k.te.kest.dto.ResumeDTO;
import k.te.kest.model.Resume;
import k.te.kest.services.ResumeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {
    @Autowired
    private ResumeServ resumeServ;

    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public List<Resume> getAllResume() {
        return resumeServ.getAllResumes();
    }

    @RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
    public Resume getResumeById(@PathVariable("id") String id) {
        return resumeServ.getResumeById(id);
    }

    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    public ResponseEntity<Object> createNew(ResumeDTO dto) {
        resumeServ.addNewResume(Resume.builder()
                .aboutMe(dto.getAbout())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhone())
                .skills(dto.getSkills())
                .build());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/resume/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteResume(@PathVariable("id") String id) {
        resumeServ.deleteResumeById(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/changeEmail/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> changeEmail(@PathVariable("id") String id, @RequestBody String email) {
        resumeServ.changeResumeEmail(id, email);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/changePhone/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> changePhone(@PathVariable("id") String id, @RequestBody String phone) {
        resumeServ.changeResumePhoneNumber(id,phone);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/changeInfo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> changeAboutInfo(@PathVariable("id") String id,@RequestBody String info) {
        resumeServ.changeResumeInfo(id, info);
        return ResponseEntity.ok().build();
    }


}
