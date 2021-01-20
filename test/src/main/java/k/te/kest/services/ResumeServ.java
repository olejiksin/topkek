package k.te.kest.services;


import k.te.kest.model.Resume;

import java.util.List;

public interface ResumeServ {
    void deleteResumeById(String id);

    Resume getResumeById(String id);

    List<Resume> getAllResumes();

    void addNewResume(Resume resume);


    void changeResumeEmail(String id, String email);

    void changeResumePhoneNumber(String id, String phone);

    void changeResumeInfo(String id, String info);
}
