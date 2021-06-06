package c.t.ttes.services;

import c.t.ttes.dto.RulerDTO;
import c.t.ttes.models.Ruler;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RulerService {
    boolean addNew(RulerDTO rulerDTO);

    List<Ruler> getAllLazy();

    List<Ruler> getTop();

    boolean getByName(String name);
}
