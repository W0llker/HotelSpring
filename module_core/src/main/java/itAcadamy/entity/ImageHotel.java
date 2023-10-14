package itAcadamy.entity;

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
    private String name;
    @Lob
    private byte[] image;
}
