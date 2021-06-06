package c.t.ttes.services;

import c.t.ttes.dto.RulerDTO;
import c.t.ttes.models.Ruler;
import c.t.ttes.repositories.RulerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RulerServiceImpl implements RulerService {
    @Autowired
    private RulerRep rulerRep;

    @Override
    public boolean addNew(RulerDTO rulerDTO) {
        try {
            rulerRep.save(Ruler.builder()
                    .age(rulerDTO.getAge())
                    .name(rulerDTO.getName())
                    .build());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Ruler> getAllLazy() {
        List<Ruler> list;
        list = rulerRep.getAllLazy();
        return list;
    }

    @Override
    public List<Ruler> getTop() {
        List<Ruler> list;
        list = rulerRep.getTopTen();
        return list;
    }

    @Override
    public boolean getByName(String name) {
        Optional<Ruler> ruler = rulerRep.getByName(name);
        if (ruler.isPresent()) {
            return true;
        }
        return false;
    }


}
