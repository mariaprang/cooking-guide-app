package cookingguide.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private int id;

    @Column(name = "recipe_name")
    private String name;

    @Column(name = "recipe_portion")
    private int portion;

    @Column(name = "calories")
    private int calories;
    @Column(name = "origin_description")
    private String originDescription;
    private String imageURL;


    private String category;

    // *** add the description here ***
    //private String imagePath;

    //Added @OneToMany Annotation for the list of ingredient
    @OneToMany(
            targetEntity = Ingredient.class, mappedBy = "recipe",
            fetch = FetchType.LAZY)
    private List<Ingredient> ingredientList = new ArrayList<>();


    @ManyToOne()
    @JoinColumn(name = "rec_user_id", referencedColumnName = "user_id")
    private User user;

    public Recipe() {
    }

    public Recipe(String name, int portion, int calories,
                  String originDescription, String imageURL, String category) {

        this.name = name;
        this.ingredientList = new ArrayList<Ingredient>();
        this.portion = portion;
        this.originDescription = originDescription;
        this.calories = calories;
        this.imageURL = imageURL;
        this.category = category;
        //this.imagePath = imagePath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // ***I should chang my ingredient to ingredientList to match the @OneToMany Annotation***
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getOriginDescription() {
        return originDescription;
    }

    public void setOriginDescription(String originDescription) {
        this.originDescription = originDescription;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", portion=" + portion +
                ", calories=" + calories +
                ", originDescription='" + originDescription + '\'' +
                ", ingredientList=" + ingredientList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && portion == recipe.portion && calories == recipe.calories && Objects.equals(name, recipe.name) && Objects.equals(originDescription, recipe.originDescription) && Objects.equals(ingredientList, recipe.ingredientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portion, calories, originDescription, ingredientList);
    }

    //    public String getImagePath() {
//        return imagePath;
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }


}
