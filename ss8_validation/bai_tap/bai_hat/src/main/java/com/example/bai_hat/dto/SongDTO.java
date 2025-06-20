package com.example.bai_hat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO implements Validator {

    private String name;
    private String artist;
    private String genre;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO song = (SongDTO) target;
        String basicRegex = "^[a-zA-Z0-9À-ỹ\\s]+$";
        String genreRegex = "^[a-zA-Z0-9À-ỹ\\s,]+$";
        if (song.name == null || song.name.trim().isEmpty()) {
            errors.rejectValue("name", "song.name.blank", "Tên bài hát không được để trống");
        } else {
            if (song.name.length() > 800) {
                errors.rejectValue("name", "song.name.length", "Tên bài hát không được vượt quá 800 ký tự");
            }
            if (!song.name.matches(basicRegex)) {
                errors.rejectValue("name", "song.name.invalidChars", "Tên bài hát không được chứa ký tự đặc biệt");
            }
        }
        if (song.artist == null || song.artist.trim().isEmpty()) {
            errors.rejectValue("artist", "song.artist.blank", "Nghệ sĩ thể hiện không được để trống");
        } else {
            if (song.artist.length() > 300) {
                errors.rejectValue("artist", "song.artist.length", "Nghệ sĩ thể hiện không được vượt quá 300 ký tự");
            }
            if (!song.artist.matches(basicRegex)) {
                errors.rejectValue("artist", "song.artist.invalidChars", "Nghệ sĩ không được chứa ký tự đặc biệt");
            }
        }
        if (song.genre == null || song.genre.trim().isEmpty()) {
            errors.rejectValue("genre", "song.genre.blank", "Thể loại không được để trống");
        } else {
            if (song.genre.length() > 1000) {
                errors.rejectValue("genre", "song.genre.length", "Thể loại không được vượt quá 1000 ký tự");
            }
            if (!song.genre.matches(genreRegex)) {
                errors.rejectValue("genre", "song.genre.invalidChars", "Thể loại chỉ được chứa chữ, số, khoảng trắng và dấu phẩy (,)");
            }
        }
    }
}
