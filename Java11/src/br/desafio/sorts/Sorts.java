package br.desafio.sorts;

import java.util.ArrayList;

public class Sorts {

    public ArrayList sortNumber(int cresc_0_decresc_1, ArrayList arrayListNumber){

        ArrayList arrayListRetorno = new ArrayList();

        Integer inteiro[] = new Integer[arrayListNumber.size()];
        Float flutuante[] = new Float[arrayListNumber.size()];


        if( cresc_0_decresc_1 == 0){

        }

        if(arrayListNumber.get(0).getClass() == Integer.class){
            int i, j, aux;

            for ( i = 0; i < arrayListNumber.size(); i++){
                inteiro[i] = Integer.parseInt(arrayListNumber.get(i).toString());
            }

            for(i = 0; i < (arrayListNumber.size()-1); i++){ // Selection Sort
                for(j=i; j<arrayListNumber.size(); j++){
                    if(inteiro[j] < inteiro[i]){
                        aux = inteiro[i];
                        inteiro[i] = inteiro[j];
                        inteiro[j] = aux;
                    }
                }
            }

            for ( i = 0; i < inteiro.length; i++){
                arrayListRetorno.add(inteiro[i]);
            }
        }

        if(arrayListNumber.get(0).getClass() == Float.class){
            Integer i, j;
            float aux;

            for ( i = 0; i < arrayListNumber.size(); i++){
                flutuante[i] = Float.parseFloat(arrayListNumber.get(i).toString());
            }

            for(i = 0; i < (arrayListNumber.size()-1); i++){ // Selection Sort
                for(j=i; j<arrayListNumber.size(); j++){
                    if(flutuante[j] < flutuante[i]){
                        aux = flutuante[i];
                        flutuante[i] = flutuante[j];
                        flutuante[j] = aux;
                    }
                }
            }

            for ( i = 0; i < inteiro.length; i++){
                arrayListRetorno.add(inteiro[i]);
            }
        }

        return arrayListRetorno;

    }

    public ArrayList sortStringOrdemAlfabetica (ArrayList arrayListString){

        String stringValores[] = new String[arrayListString.size()];
        String stringAux;
        ArrayList arrayListRetorno = new ArrayList();

        for ( int i = 0; i < arrayListString.size(); i++){
            stringValores[i] = (String) arrayListString.get(i);
        }

        for (int i = 0; i < arrayListString.size(); i++) {
            for (int j = i + 1; j < arrayListString.size(); j++) {
                if (stringValores[i].compareTo(stringValores[j]) > 0) {
                    stringAux = stringValores[i];
                    stringValores[i] = stringValores[j];
                    stringValores[j] = stringAux;
                }
            }
        }

        for ( int i = 0; i < stringValores.length; i++){
            arrayListRetorno.add(stringValores[i]);
        }

        return arrayListRetorno;

    }
}
