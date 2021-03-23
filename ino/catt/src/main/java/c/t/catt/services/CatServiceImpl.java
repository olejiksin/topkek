package c.t.catt.services;

import c.t.catt.dto.CattDTO;
import c.t.catt.models.Cat;
import c.t.catt.repos.CatRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRep catRep;

    @Override
    public List<CattDTO> getAll() {
        List<CattDTO> list = new ArrayList<>();
        for (Cat cat : catRep.getAll()) {
            list.add(CattDTO.builder()
                    .id(cat.getId())
                    .imgUrl(cat.getImgurl())
                    .name(cat.getName())
                    .build());
        }
        return list;
    }

    @Override
    public void upVote(Long id) {
        Optional<Cat> cat = catRep.getById(id);
        if (cat.isPresent()) {
            cat.get().setVotes(cat.get().getVotes() + 1);
            catRep.save(cat.get());
        }
    }

    @Override
    public List<CattDTO> getTop() {
        List<CattDTO> list = new ArrayList<>();
        for (Cat cat : catRep.getAllByOrderByVotesDesc()) {
            list.add(CattDTO.builder()
                    .id(cat.getId())
                    .imgUrl(cat.getImgurl())
                    .name(cat.getName())
                    .build());
        }
        return list;
    }
}
