package k.te.kest.services;

import k.te.kest.model.Resume;
import k.te.kest.reps.ResumeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServImpl implements ResumeServ {

    @Autowired
    private ResumeRep resumeRep;

    @Override
    public void deleteResumeById(String id) {
        resumeRep.deleteBy_id(id);
    }

    @Override
    public Resume getResumeById(String id) {
        return resumeRep.getResumeBy_id(id);
    }

    @Override
    public List<Resume> getAllResumes() {
        return resumeRep.findAll();
    }

    @Override
    public void addNewResume(Resume resume) {
        resumeRep.save(resume);
    }

    @Override
    public void changeResumeEmail(String id, String email) {
        Resume resume = resumeRep.getResumeBy_id(id);
        resume.setEmail(email);
        resumeRep.save(resume);
    }

    @Override
    public void changeResumePhoneNumber(String id, String phone) {
        Resume resume = resumeRep.getResumeBy_id(id);
        resume.setPhoneNumber(phone);
        resumeRep.save(resume);
    }

    @Override
    public void changeResumeInfo(String id, String info) {
        Resume resume = resumeRep.getResumeBy_id(id);
        resume.setAboutMe(info);
        resumeRep.save(resume);
    }
}
