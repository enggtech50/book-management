package com.techh.engg.books.management.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldNameConstants
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "library-book-mapping")
public class BookMapping {

  @Id
  @With
  private String id;

  @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Mapping id.", example = "HP")
  @NotBlank(message = "mappingId is required")
  String mappingId;

  @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Title of the book.",
  example = "Lord of the Rings: Fellowship of the Ring")
  private String title;

  @Schema(description = "Author of the book.", example = "J.R.R. Tolkein")
  private String author;

  @Schema(description = "Publisher of the book.", example = "Allen & Unwin")
  private String publisher;

  @Schema(description = "Date of the publishing.", example = "29 July 1954")
  private String publicationDate;

  @Schema(description = "Categories described for the book.", example = "Science fiction")
  @NotBlank(message = "genre is required")
  private String genre;

  @Schema(description = "Number of copies available.", example = "10")
  Integer availableCopies;

  Instant createTs;
  Instant lastUpdatedTs;
}
