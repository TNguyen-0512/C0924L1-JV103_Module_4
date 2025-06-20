package com.example.bai_hat.controller;

import com.example.bai_hat.service.SongService;
import com.example.bai_hat.user.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("")
    public String showListSong(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "songs/list";
    }

    @GetMapping("/songs/add")
    public String showCreateForm(Model model) {
        model.addAttribute("songDTO", new Song());
        return "songs/add";
    }

    @PostMapping("/songs/add")
    public String createSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("success", "✅ Bài hát đã được thêm thành công!");
        return "redirect:/";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        songService.delete(id);
        redirectAttributes.addFlashAttribute("success", "🗑️ Bài hát đã được xóa!");
        return "redirect:/";
    }
    @GetMapping("/songs/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Song song = songService.findById(id);
        if (song != null) {
            model.addAttribute("song", song);
            return "songs/edit";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/songs/{id}")
    public String viewSong(@PathVariable Integer id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "songs/views";
    }
}
