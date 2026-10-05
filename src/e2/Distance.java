package e2;

import java.util.Arrays;

public class Distance {
    /**
     * Given the layout of a class with available sites marked with an ’A’ and
     * invalid sites marked with a ’.’, returns the resulting layout with the
     * sites occupied by the students marked with a ’#’ following two rules :
     * - Students occupy an empty seat if there are no other adjacent students .
     * - A student leaves a seat empty if he/ she has 4 or more adjacent students .
     * @param layout The initial layout .
     * @return The resulting layout .
     * @throws IllegalArgumentException if the initial layout is invalid (is null ,
     * is ragged , includes characters other than ’.’ or ’A ’)).
     */

    private static void roundingPeople(char [][] layout, char [][] layoutComodin, int i, int j){
        int k,z, ocupados=0;
        for(k=Math.max(0,i-1);k<Math.min(layout.length,i+2);k++){
            for(z=Math.max(0,j-1);z<Math.min(layout[k].length,j+2);z++) {
                if(k!=i || z!=j){
                    if(layout[k][z]=='#'){
                        ++ocupados;;
                        if(ocupados>=4){
                            layoutComodin[i][j]='A';
                            return;
                        }
                    }
                }
            }
        }
        layoutComodin[i][j]='#';
    }

    private static void roundingPeople2(char [][] layout, char[][] layoutComodin, int i, int j){
        int k,z, ocupados=0;
        for(k=Math.max(0,i-1);k<Math.min(layout.length,i+2);k++){
            for(z=Math.max(0,j-1);z<Math.min(layout[k].length,j+2);z++) {
                if(k!=i || z!=j){
                    if(layout[k][z]=='#'){
                        layoutComodin[i][j]='A';
                        return;
                    }
                }
            }
        }
        layoutComodin[i][j]='#';
    }

    private static boolean comprobacion (char [][] layout, char [][] layoutComodin){
        int i,j;
        for(i=0;i<=(layout.length-1);i++){
            for(j=0;(j<=layout[i].length-1);j++){
                if(layout[i][j]!=layoutComodin[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    public static char [][] seatingPeople ( char [][] layout )throws IllegalArgumentException {
        int i, j;

        if (layout == null) {
            throw new IllegalArgumentException("The layout is null");
        }
        for(i=0;i<=layout.length-1;i++){
            for(j=0;j<=layout[i].length-1;j++){
                if((layout[i][j]!='A' && layout[i][j]!='.') || layout[0].length!=layout[i].length){
                    throw new IllegalArgumentException("The layout is invalid");
                }
            }
        }

        boolean result=false;
        do{

            char [][] layoutComodin= new char[layout.length][layout[0].length];

            for(i=0;i<=layout.length-1;i++){
                for(j=0;j<=layout[i].length-1;j++){
                    if(layout[i][j]=='#'){

                        roundingPeople(layout, layoutComodin, i, j);
                    }else if(layout[i][j]=='A'){

                        roundingPeople2(layout, layoutComodin, i, j);
                    }else{
                        layoutComodin[i][j]=layout[i][j];
                    }
                }
            }

            result = comprobacion(layout,layoutComodin);

            for(i=0;i<=(layout.length-1);i++){
                for(j=0;(j<=layout[i].length-1);j++){
                    layout[i][j]=layoutComodin[i][j];
                }
            }

        }while(!result);

        return layout;

    }
}