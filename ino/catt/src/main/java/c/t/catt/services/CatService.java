package c.t.catt.services;

import c.t.catt.dto.CattDTO;

import java.util.List;

public interface CatService {
    List<CattDTO> getAll();

    void upVote(Long id);

    List<CattDTO> getTop();
}
