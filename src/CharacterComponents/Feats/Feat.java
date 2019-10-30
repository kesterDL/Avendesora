package CharacterComponents.Feats;

public class Feat {
    FeatCategories catagory;
    Boolean prerequisite;
    String description;

    public FeatCategories getCatagory() {
        return catagory;
    }

    public void setCatagory(FeatCategories catagory) {
        this.catagory = catagory;
    }

    public Boolean getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Boolean prerequisit) {
        this.prerequisite = prerequisit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
