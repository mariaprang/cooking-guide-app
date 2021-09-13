package cookingguide.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ingredient_id")
    private int id;

    private String ingredientName;
    private double amount;
    private UnitOfMeasurements unitOfMeasurements;

    @ManyToOne()
    @JoinColumn(name = "ingr_rec_id", referencedColumnName = "recipe_id")
    private Recipe recipe;

    public Ingredient(){}

    public Ingredient(String ingredientName, double amount, UnitOfMeasurements unitOfMeasurements) {
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.unitOfMeasurements = unitOfMeasurements;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public int getId() {
        return id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        ingredientName = ingredientName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UnitOfMeasurements getUnitOfMeasurements() {
        return unitOfMeasurements;
    }

    public void setUnitOfMeasurements(UnitOfMeasurements unitOfMeasurements) {
        this.unitOfMeasurements = unitOfMeasurements;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", IngredientName='" + ingredientName + '\'' +
                ", amount=" + amount +
                ", unitOfMeasurements=" + unitOfMeasurements +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(ingredientName, that.ingredientName) && unitOfMeasurements == that.unitOfMeasurements;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredientName, amount, unitOfMeasurements);
    }
}
