package k.te.kest.reps;

import k.te.kest.model.Resume;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Lazy
@Repository
public interface ResumeRep extends MongoRepository<Resume,String> {

    Resume getResumeBy_id(String id);

    void deleteBy_id(String id);
}
