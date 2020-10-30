package br.desafio.sorts;

import jdk.swing.interop.SwingInterOpUtils;
import org.json.JSONObject;

import java.util.ArrayList;

public class Sorts {

    public ArrayList sortNumber(int cresc_0_decresc_1, ArrayList arrayListNumber1){

        ArrayList arrayListNumber = new ArrayList();

        ArrayList arrayListNotNumber = new ArrayList();

        ArrayList arrayListRetorno = new ArrayList();

        //Tratamento de valores que não sejam números
        for ( int i =0; i < arrayListNumber1.size(); i++){

            if(arrayListNumber1.get(i).getClass() == Integer.class || arrayListNumber1.get(i).getClass() == Double.class){
                arrayListNumber.add(arrayListNumber1.get(i));
            }else{
                arrayListNotNumber.add(arrayListNumber1.get(i));
            }
        }

        Object numero[] = new Object[arrayListNumber.size()];

        try{
            arrayListNumber.get(0);
        }catch (Exception e){
            return arrayListRetorno;
        }

        // Ordenação de inteiros
        if( cresc_0_decresc_1 == 0){
            if(arrayListNumber.get(0).getClass() != String.class){
                int i, j;
                Object aux;

                //Transforma o arrayList em um vetor de objects
                for ( i = 0; i < arrayListNumber.size(); i++){
                    numero[i] = arrayListNumber.get(i);
                }

                // Selection Sort
                for(i = 0; i < arrayListNumber.size()-1; i++){
                    for(j=i; j < arrayListNumber.size(); j++){

                        if(numero[j].getClass() == Integer.class && numero[i].getClass() == Integer.class){

                            if((Integer)numero[j] < (Integer)numero[i] ){
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }

                        }else if(numero[j].getClass() == Integer.class && numero[i].getClass() == Double.class){
                            if((Integer)numero[j] < (Double)numero[i] ){
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }
                        }else if(numero[j].getClass() == Double.class && numero[i].getClass() == Integer.class){
                            if((Double)numero[j] < (Integer)numero[i] ){
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }
                        }else {
                            if((Double)numero[j] < (Double) numero[i] ){
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }
                        }
                    }
                }

                for ( i = 0; i < numero.length; i++){
                    arrayListRetorno.add(numero[i]);
                }

            }

        }else{
            if(arrayListNumber.get(0).getClass() != String.class) {
                int i, j;
                Object aux;

                for (i = 0; i < arrayListNumber.size(); i++) {
                    numero[i] = arrayListNumber.get(i);
                }

                // Selection Sort
                for (i = 0; i < (arrayListNumber.size()-1); i++) {
                    for (j = i; j < arrayListNumber.size(); j++) {


                        if (numero[j].getClass() == Integer.class && numero[i].getClass() == Integer.class) {

                            if ((Integer) numero[j] > (Integer) numero[i]) {
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }

                        } else if (numero[j].getClass() == Integer.class && numero[i].getClass() == Double.class) {
                            if ((Integer) numero[j] > (Double) numero[i]) {
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }
                        } else if (numero[j].getClass() == Double.class && numero[i].getClass() == Integer.class) {
                            if ((Double) numero[j] > (Integer) numero[i]) {
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }
                        } else {
                            if ((Double) numero[j] > (Double) numero[i]) {
                                aux = numero[i];
                                numero[i] = numero[j];
                                numero[j] = aux;
                            }
                        }
                    }
                }

                for (i = 0; i < numero.length; i++) {
                    arrayListRetorno.add(numero[i]);
                }
            }
        }

        //Adiciona os valores que não são números no final do arrayListRetorno
        for(int i = 0; i < arrayListNotNumber.size(); i++){
            arrayListRetorno.add(arrayListNotNumber.get(i));
        }

        return arrayListRetorno;

    }

    public ArrayList sortStringOrdemAlfabetica (ArrayList arrayListString){

        String stringValores[] = new String[arrayListString.size()];
        String stringAux;
        ArrayList arrayListRetorno = new ArrayList();

        // Transforma o array em um vetor de string
        for ( int i = 0; i < arrayListString.size(); i++){

            String valorDeCampoString = (String) arrayListString.get(i);

            //Tratamento de espaço no primeiro indice da String
            Character primeiroCaracter = valorDeCampoString.charAt(0);
            if( primeiroCaracter.equals(' ')){
                StringBuilder stringBuilder = new StringBuilder(valorDeCampoString);
                valorDeCampoString = stringBuilder.deleteCharAt(0).toString();
            }

            stringValores[i] = valorDeCampoString;
        }

        //Ordenação
        for (int i = 0; i < arrayListString.size(); i++) {
            for (int j = i + 1; j < arrayListString.size(); j++) {
                if (stringValores[i].compareTo(stringValores[j]) > 0) {
                    stringAux = stringValores[i];
                    stringValores[i] = stringValores[j];
                    stringValores[j] = stringAux;
                }
            }
        }

        // Transforma o vetor de string em array
        for ( int i = 0; i < stringValores.length; i++){
            arrayListRetorno.add(stringValores[i]);
        }

        return arrayListRetorno;

    }
}
