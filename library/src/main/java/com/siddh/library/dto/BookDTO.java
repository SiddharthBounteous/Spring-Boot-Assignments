package com.siddh.library.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Integer bookId;

    @NotBlank(message = "Book Name is required")
    private String  bookName;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "Author Name is required")
    private String author;
}
