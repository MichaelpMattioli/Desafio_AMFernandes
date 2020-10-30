package br.desafio.sorts;

import org.json.JSONObject;

import java.util.ArrayList;

public class Sorts {

    public ArrayList sortNumber(int cresc_0_decresc_1, ArrayList arrayListNumber){

        ArrayList arrayListRetorno = new ArrayList();

        Integer inteiro[] = new Integer[arrayListNumber.size()];
        Float flutuante[] = new Float[arrayListNumber.size()];

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
            if(arrayListNumber.get(0).getClass() == Integer.class){
                int i, j, aux;

                for ( i = 0; i < arrayListNumber.size(); i++){
                    inteiro[i] = Integer.parseInt(arrayListNumber.get(i).toString());
                }

                for(i = 0; i < (arrayListNumber.size()); i++){ // Selection Sort
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
        }else{
            if(arrayListNumber.get(0).getClass() == Integer.class){
                int i, j, aux;

                for ( i = 0; i < arrayListNumber.size(); i++){
                    inteiro[i] = Integer.parseInt(arrayListNumber.get(i).toString());
                }

                for(i = 0; i < (arrayListNumber.size()); i++){ // Selection Sort
                    for(j=i; j<arrayListNumber.size(); j++){
                        if(inteiro[j] > inteiro[i]){
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
        }


        // Ordenação de pontos flutuantes
        if(cresc_0_decresc_1 == 0){
            if(arrayListNumber.get(0).getClass() == Float.class){
                Integer i, j;
                float aux;

                for ( i = 0; i < arrayListNumber.size(); i++){
                    flutuante[i] = Float.parseFloat(arrayListNumber.get(i).toString());
                }

                for(i = 0; i < (arrayListNumber.size()); i++){ // Selection Sort
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
        }else{
            if(arrayListNumber.get(0).getClass() == Float.class){
                Integer i, j;
                float aux;

                for ( i = 0; i < arrayListNumber.size(); i++){
                    flutuante[i] = Float.parseFloat(arrayListNumber.get(i).toString());
                }

                for(i = 0; i < (arrayListNumber.size()); i++){ // Selection Sort
                    for(j=i; j<arrayListNumber.size(); j++){
                        if(flutuante[j] > flutuante[i]){
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
        }

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
