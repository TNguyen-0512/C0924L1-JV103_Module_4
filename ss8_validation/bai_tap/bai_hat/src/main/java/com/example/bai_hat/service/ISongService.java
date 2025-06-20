package com.example.bai_hat.service;

import com.example.bai_hat.user.Song;
import java.util.List;

public interface ISongService {
   List<Song> findAll();
   void save(Song song);
   void delete(Integer id);
    Song findById(Integer id);
}
