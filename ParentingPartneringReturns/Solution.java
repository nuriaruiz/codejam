package ParentingPartneringReturns;

import java.io.*;
import java.util.*;

public class Solution {
    private static class Activity {
        private Integer ini;
        private Integer fin;

        public Activity(Integer ini, Integer fin) {
            this.ini = ini;
            this.fin = fin;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) { return true; }
            if (obj == null || obj.getClass() != this.getClass()) { return false; }
            Activity actividad = (Activity) obj;
            // another option: Math.max(this.ini, actividad.ini) < Math.min(this.fin, actividad.fin)
            return this.ini < actividad.fin && this.fin > actividad.ini;
        }

        @Override
        public String toString() {
            return "Inicio: "+this.ini+" , Fin: "+this.fin;
        }
    }

    public static void main(String[] args) {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        try {
            String data = myReader.nextLine();
            Integer numRows = Integer.parseInt(data);
            List<String> listCasesResults = new ArrayList<>();

            for (int c = 0; c < numRows; c++) {
                data = myReader.nextLine();
                Integer numActividades = Integer.parseInt(data);

                List<Activity> listActividadesJ = new ArrayList<>();
                List<Activity> listActividadesC = new ArrayList<>();

                String outputString = "Case #"+(c+1)+": ";
                for (int iAct = 0; iAct<numActividades; iAct++){
                    data = myReader.nextLine();
                    String[] numerosFila = data.split("\\s");
                    Activity nextAct = new Activity(Integer.parseInt(numerosFila[0].trim()), Integer.parseInt(numerosFila[1].trim()));
                    if (!listActividadesC.contains(nextAct) || listActividadesC.isEmpty()) {
                        listActividadesC.add(nextAct);
                        outputString = outputString.concat("C");
                    } else if (!listActividadesJ.contains(nextAct) || listActividadesJ.isEmpty()){
                        listActividadesJ.add(nextAct);
                        outputString = outputString.concat("J");
                    } else {
                        outputString = "Case #"+(c+1)+": IMPOSSIBLE";
                        for (int i=iAct; i< numActividades-iAct; i++){
                            data = myReader.nextLine();
                        }
                        break;
                    }
                }
                listCasesResults.add(outputString);
            }
            for (String c: listCasesResults){
                System.out.println(c);
            }
            myReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
