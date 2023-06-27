package Aufgabe7;

public class Stadt {
    private Verbindungsdaten.Staedte id;
    private String[] nachbarn;

    public Stadt (Verbindungsdaten.Staedte id){
        this.id=id;
        this.nachbarn = Verbindungsdaten.VERBINDUNGEN[id.ordinal()];
    }

    public int getAnzahlNachbarn() {
        int anzahlNachbarn = 0;
        for (String nachbar : nachbarn) {
            if (nachbar != "") {
                anzahlNachbarn++;
            }
        }
        return anzahlNachbarn;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    public Verbindungsdaten.Staedte[] getNachbarn(){
        int anzahlNachbarn=getAnzahlNachbarn();
        Verbindungsdaten.Staedte[] nachbarStaedte =new Verbindungsdaten.Staedte[anzahlNachbarn];
        int index=0;
        for(int i=0;i<nachbarn.length;i++){
            if(!nachbarn[i].equals("")){
                nachbarStaedte[index]= Verbindungsdaten.Staedte.values()[i];
                index++;
            }
        }return nachbarStaedte;
    }

    public Verbindungsdaten.Staedte getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()){
            return false;
        }
        Stadt object = (Stadt) obj;
        return (getId() == object.getId());
    }
}
