package cookingguide.models;

public enum Badge {

    NEWBIE("Newbie"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private String badgeWording;

    private Badge(String badgeWording){
        this.badgeWording = badgeWording;
    }

    public String getBadgeWording() {
        return badgeWording;
    }
}
