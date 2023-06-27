package Aufgabe7;

import java.util.ArrayList;

public class Tour {
    private Stadt startStadt;
    private Stadt zielStadt;
    private String ware;


    public Tour(Stadt startStadt, Stadt zielStadt, String ware) {
        this.startStadt = startStadt;
        this.zielStadt = zielStadt;
        this.ware = ware;
    }

    public ArrayList<Stadt> getPfad(){
        boolean[] besucht = new boolean[Verbindungsdaten.Staedte.values().length];
        return getPfad(zielStadt,besucht);}

    private ArrayList<Stadt> getPfad(Stadt aktuelleStadt, boolean besucht[]){

        ArrayList<Stadt> pfad = new ArrayList<>();

        if(aktuelleStadt.hashCode()==startStadt.hashCode() && aktuelleStadt.equals(startStadt)){
            pfad.add(aktuelleStadt);
            return pfad;
        }
        besucht[aktuelleStadt.getId().ordinal()]=true;

        for (Verbindungsdaten.Staedte nachbarStadt: aktuelleStadt.getNachbarn()) {
           if (!besucht[nachbarStadt.ordinal()]){
               Stadt nachbar = new Stadt(nachbarStadt);
               ArrayList<Stadt> teilPfad = getPfad(nachbar,besucht);
               if (teilPfad != null){
                   pfad.add(aktuelleStadt);
                   pfad.addAll(teilPfad);
                   return pfad;
               }
            }
        }
        return null;
    }

















/*


    private ArrayList<Stadt> getPfad(Stadt anfangsStadt) {
        boolean[] besuchteStaedte = new boolean[Verbindungsdaten.Staedte.values().length];
        ArrayList<Stadt> pfad = new ArrayList<>();
        pfad.add(anfangsStadt);

        if (anfangsStadt.equals(zielStadt)) {
            return pfad;
        }

        besuchteStaedte[anfangsStadt.getId().ordinal()] = true;

        for (Verbindungsdaten.Staedte nachbarStadt : anfangsStadt.getNachbarn()) {
            if (!besuchteStaedte[nachbarStadt.ordinal()]) {
                besuchteStaedte[nachbarStadt.ordinal()] = true;
                ArrayList<Stadt> result = getPfad(new Stadt(nachbarStadt));
                if (result != null) {
                    pfad.addAll(result);
                    return pfad;
                }
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String path = "";
        for (Stadt stadt : pfad) {
            path += stadt.toString() + " -> ";
        }
        path = path.substring(0, path.length() - 4); // Entferne das letzte " -> "
        return path;
    }

   public ArrayList<Stadt> getPfad(){
       return getPfad(zielStadt);}
/*
    private ArrayList<Stadt> getPfad(Stadt anfangsStadt) {
        boolean[] besuchteStaedte = new boolean[Verbindungsdaten.Staedte.values().length];
        ArrayList<Stadt> pfad = new ArrayList<>();
        pfad.add(anfangsStadt);

        if (anfangsStadt.equals(zielStadt)) {
            return pfad;
        }

        for (Verbindungsdaten.Staedte nachbarStadt : anfangsStadt.getNachbarn()) {
            if (!besuchteStaedte[nachbarStadt.ordinal()]) {
                besuchteStaedte[nachbarStadt.ordinal()] = true;
                if (nachbarStadt.equals(zielStadt)) {
                    pfad.add(nachbarStadt);
                    return pfad;
                }
                ArrayList<Stadt> subPfad = getPfad(nachbarStadt);
                if (subPfad != null) {
                    pfad.addAll(subPfad);
                    return pfad;
                }
            }
        }

        return null;
    }




    private ArrayList<Stadt> getPfad(Stadt anfangsStadt){
        boolean[] besuchteStaedte = new boolean[Verbindungsdaten.Staedte.values().length];
        ArrayList<Stadt> pfad = new ArrayList<>();
        pfad.add(startStadt);

        if (anfangsStadt.equals(zielStadt)) {
            return pfad;
        }
        for(Verbindungsdaten.Staedte nachbarStadt : anfangsStadt.getNachbarn()){
            if(!besuchteStaedte[nachbarStadt.ordinal()]){
              ArrayList<Stadt> subPfad = getPfad(nachbarStadt);
                if(subPfad !=null){
                    pfad.add(anfangsStadt);
                    return pfad;
                }
            }

        }

        private ArrayList<Stadt> getPfad(Stadt anfangsStadt){
            boolean[] besuchteStaedte = new boolean[Verbindungsdaten.Staedte.values().length];
            ArrayList<Stadt> pfad = new ArrayList<>();
            pfad.add(startStadt);

            if (anfangsStadt.equals(zielStadt)) {
                return pfad;
            }
            for(Verbindungsdaten.Staedte nachbarStadt : anfangsStadt.getNachbarn()){
                if(!besuchteStaedte[nachbarStadt.ordinal()]){
                    if(nachbarStadt=zielStadt){
                        pfad.add(nachbarStadt);
                        return pfad;
                    }startStadt=nachbarStadt;
                    getPfad(nachbarStadt);}return null;





    }



/*


    private ArrayList getPfad(Stadt pfadStadt) {
        //muss ggf. auserhalb deklariert werden, alle werte sind false initial initialisiert
        boolean[] besuchteStaedte = new boolean[Verbindungsdaten.Staedte.values().length];
        ArrayList<Stadt> pfad = new ArrayList<>();
        pfad.add(startStadt);

        if (pfadStadt.equals(zielStadt)) {
            return pfad;
        }


        for (Verbindungsdaten.Staedte nachbarStadt : pfadStadt.getNachbarn()) {
            if (!besuchteStaedte[nachbarStadt.ordinal()]) {
                besuchteStaedte[nachbarStadt.ordinal()] = true;
                ArrayList<Stadt> teilpfad = getPfad(new Stadt(nachbarStadt));
                if (teilpfad != null) {
                    pfad.addAll(teilpfad);
                    return pfad;
                }
            }

        }
        return null;


    }*/}
