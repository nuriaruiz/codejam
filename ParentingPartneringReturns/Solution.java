package ParentingPartneringReturns;

import java.io.*;
import java.util.*;

public class Solution {
    private static class Activity implements Comparable{
        private Integer ini;
        private Integer fin;
        private Integer order;


        public Activity(Integer ini, Integer fin, Integer order) {
            this.ini = ini;
            this.fin = fin;
            this.order = order;
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
            return "Inicio: "+this.ini+" , Fin: "+this.fin+" , Orden: "+this.order;
        }


        @Override
        public int compareTo(Object obj) {
            if (obj == this) { return 0; }
            Activity otherActivity = (Activity) obj;
            return (this.ini < otherActivity.ini ) ? -1: (this.ini > otherActivity.ini) ? 1:0 ;
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
                List<Activity> listActivities = new ArrayList<>();
                for (int iAct = 0; iAct<numActividades; iAct++) {
                    data = myReader.nextLine();
                    String[] numerosFila = data.split("\\s");
                    Activity nextAct = new Activity(Integer.parseInt(numerosFila[0].trim()), Integer.parseInt(numerosFila[1].trim()), iAct);
                    listActivities.add(nextAct);
                }
                Collections.sort(listActivities);
                StringBuilder result = new StringBuilder("");
                result.setLength(numActividades);
                for (Activity nextAct: listActivities){
                    if (!listActividadesC.contains(nextAct) || listActividadesC.isEmpty()) {
                        listActividadesC.add(nextAct);
                        result.setCharAt(nextAct.order, 'C');
                    } else if (!listActividadesJ.contains(nextAct) || listActividadesJ.isEmpty()){
                        listActividadesJ.add(nextAct);
                        result.setCharAt(nextAct.order, 'J');
                    } else {
                        result.setLength(0);
                        break;
                    }
                }

                if (result.length() > 0) {
                    outputString = outputString.concat(result.toString());
                }else{
                    outputString = "Case #"+(c+1)+": "+"IMPOSSIBLE";
                }
                listCasesResults.add(outputString);

            }
            // Recorremos las listas de actividades
            for (String c: listCasesResults){
                System.out.println(c);
            }
            myReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
