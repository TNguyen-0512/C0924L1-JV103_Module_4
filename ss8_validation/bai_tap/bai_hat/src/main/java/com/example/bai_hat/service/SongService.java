package com.example.bai_hat.service;

import com.example.bai_hat.repository.ISongRepository;
import com.example.bai_hat.user.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Integer id) {
        songRepository.deleteById(id.intValue());
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id.intValue()).orElse(null);
    }
}
