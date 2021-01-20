package k.te.kest.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "testCol")
@Builder
@Data
public class Resume {
    @Id
    private String _id;

    @Indexed
    private String email;
    private String phoneNumber;
    private String aboutMe;
    private ArrayList<String> skills;
}
