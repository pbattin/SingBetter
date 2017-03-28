package model;

/**
 * Created by prestonbattin on 3/28/17.
 */
public enum Notes {
    A("A"),
    B_FLAT("Bb"),
    B("B"),
    C("C"),
    C_SHARP("C#"),
    D("D"),
    D_SHARP("D#"),
    E("E"),
    F("F"),
    F_SHARP("F#"),
    G("G"),
    G_SHARP("G#");

    private final String name;

    private Notes(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
