package com.teoh.api.service;

import com.teoh.api.model.Caso;
import com.teoh.api.repository.CasoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoService {

    private final CasoRepository casoRepository;

    public CasoService(CasoRepository casoRepository) {
        this.casoRepository = casoRepository;
    }

    public List<Caso> findAll() {
        return casoRepository.findAll();
    }

    public Caso findById(Integer id) {
        return casoRepository.findById(id).orElse(null);
    }

    public Caso save(Caso caso) {
        return casoRepository.save(caso);
    }

    public void deleteById(Integer id) {
        casoRepository.deleteById(id);
    }
}
