import chars.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args){
        Battle b = new Battle();
        Victreebel p1 = new Victreebel("", 1);
        Weepinbell p2 = new Weepinbell("", 1);
        Bellsprout p3 = new Bellsprout("", 1);
        Farfetchd p4 = new Farfetchd("", 1);
        Skrelp p5 = new Skrelp("", 1);
        Dragalge p6 = new Dragalge("", 1);
        b.addAlly(p1);
        b.addFoe(p4);
        b.addAlly(p2);
        b.addFoe(p5);
        b.addAlly(p3);
        b.addFoe(p6);
        b.go();
    }
}
