package br.desafio.sorts;

import org.json.JSONObject;

import java.util.ArrayList;

public class Sorts {

    public ArrayList sortNumber(int cresc_0_decresc_1, ArrayList arrayListNumber1){

        ArrayList arrayListNumber = arrayListNumber1;
        ArrayList arrayListNotNumber = new ArrayList();

        //Tratamento de valores que não sejam números
        for ( int i =0; i < arrayListNumber.size()-1; i++){

            if(arrayListNumber.get(i).getClass() != Integer.class && arrayListNumber.get(i).getClass() != Double.class){
                arrayListNotNumber.add(arrayListNumber.get(i));
                arrayListNumber.remove(i);
            }
        }


        ArrayList arrayListRetorno = new ArrayList();

        Integer inteiro[] = new Integer[arrayListNumber.size()];
        Float flutuante[] = new Float[arrayListNumber.size()];
        Object numero[] = new Object[arrayListNumber.size()];

        // Tratamento de numeros que são tenham formato Strings
        if(arrayListNumber.get(0).getClass() == String.class){

            boolean isPossibleInteger = false;
            boolean isPossibleFloat = false;

            ArrayList arrayListAux = new ArrayList();

            try{
                arrayListNumber.forEach(number ->{
                    if(number.equals("")){
//                        arrayListAux.add(number);
                    }else{
                        Integer stringToNumber = Integer.parseInt((String) number);
                    }

                });
                isPossibleInteger = true;
            }catch (Exception e){
                e.printStackTrace();
            }

            if(isPossibleInteger == true){

                arrayListNumber.forEach(number ->{
                    if(number.equals("")){
                    }else{
                    int stringToNumber = Integer.parseInt((String) number.toString());

                    arrayListAux.add(stringToNumber);
                    }
                });

                arrayListNumber.clear();

                arrayListAux.forEach(number ->{
                    arrayListNumber.add(number);
                });
            }



        }

        // Ordenação de inteiros
        if( cresc_0_decresc_1 == 0){
            if(arrayListNumber.get(0).getClass() != String.class){
                int i, j;
                Object aux;

                for ( i = 0; i < arrayListNumber.size(); i++){
                    numero[i] = arrayListNumber.get(i);
                }

                for(i = 0; i < (arrayListNumber.size()); i++){ // Selection Sort
                    for(j=i; j<arrayListNumber.size(); j++){



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

                for ( i = 0; i < inteiro.length; i++){
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

                for (i = 0; i < (arrayListNumber.size()); i++) { // Selection Sort
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

                for (i = 0; i < inteiro.length; i++) {
                    arrayListRetorno.add(numero[i]);
                }
            }
        }

        //Adiciona os valores que não são números no final do arrayListRetorno
        arrayListNotNumber.forEach(item -> arrayListRetorno.add(item));

        return arrayListRetorno;

    }

    public ArrayList sortStringOrdemAlfabetica (ArrayList arrayListString){

        String stringValores[] = new String[arrayListString.size()];
        String stringAux;
        ArrayList arrayListRetorno = new ArrayList();

        // Transforma o array em um vetor de string
        for ( int i = 0; i < arrayListString.size(); i++){
            stringValores[i] = (String) arrayListString.get(i);
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

//    public ArrayList sortEquals(ArrayList arrayList, int sortAlfa_1_notSortAlfa_0){
//
//        ArrayList arrayListOrdemAlfa = new ArrayList();
//
//        if( sortAlfa_1_notSortAlfa_0 == 1){
//            arrayListOrdemAlfa = sortStringOrdemAlfabetica(arrayList);
//        }
//
//
//        for(int i = 0; i < arrayList.size(); i++){
//
//            if(!listaCamposConteudo.contains(jsonObjectAux.get(campo))){
//                listaCamposConteudo.add(jsonObjectAux.get(campo));
//            }
//
//        }
//
//
//    }
}
