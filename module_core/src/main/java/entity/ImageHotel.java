package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageHotel {
    //  ?Тип фотографии?
    private String name;
    @Lob
    private String image;
}
