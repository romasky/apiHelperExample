package apiHelperExample;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RepoItem {
    String id;
    String name;
    @SerializedName("full_name")   //чтобы указать, что в нашем json имя приходит под таким key
    String fullName;
    String description;
}
