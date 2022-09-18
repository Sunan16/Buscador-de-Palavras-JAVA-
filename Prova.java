package prova;

import javax.swing.JOptionPane;

public class Prova {

    public static void main(String[] args) {
        int resp;
        do{
            String frase = JOptionPane.showInputDialog("Insira a frase: "); 
            frase = frase + " ";       // Eu tive que adicionar esse espaço pq nao consegui fazer o vetor parar
            frase = frase.toUpperCase();
            char[] fraseVetor = frase.toCharArray();
            String palavraBusca = JOptionPane.showInputDialog("Regras para a busca de palavras!\n"
                    + "1° a palavra tem que ser menor que o texto procurado, vai funcinar o programa, mas não vai achar nada!\n"
                    + "2° não utilize caracter especiais\n"
                    + "Digite uma palavra que deseja buscar no texto: ");
            palavraBusca = palavraBusca.toUpperCase();
            char[] palavraVetor = palavraBusca.toCharArray();
            if(frase == null || palavraBusca == null){
                System.exit(0);                           // Estava com um erro, essa condição tira esse erro
            }
            
            int f = fraseVetor.length;
            int p = palavraVetor.length;
            int indiceF = f - 1;
            int indiceP = p - 1;
            int ocorrencias = 0;
            
            for(int t = 0; t < f; ++t){
                int T = t;
                int i = 0;
                if(f >= t){
                    while(palavraVetor[i] == fraseVetor[t] && indiceF > t){
                        if (t < indiceF && i < indiceP){
                            i++;
                            t++;
                        }else if(indiceP == i){
                            ocorrencias++;
                            break;
                        }else if(i > indiceP || t > indiceF){
                            break;
                        }
                    }
                }
                t = T;
            }
            JOptionPane.showMessageDialog(null, "Essa palavra ocorre " + ocorrencias + " vez(es)");
        resp = JOptionPane.showInternalConfirmDialog(null, "Deseja continuar?", "Continuar?", JOptionPane.YES_NO_OPTION);
        }while(resp == JOptionPane.YES_OPTION);
        System.out.println(" ");
        System.out.println("Obrigado por buscar!");
        System.exit(0);
    }
    
}
