import java.util.ArrayList;
import java.util.Scanner;
public class filaPrioridade{


    static class Tarefa{

        private int id;
        private int prioridade;
        private String descricao;
        public Tarefa(int id, int prioridade, String descricao){
            this.prioridade=prioridade;
            this.id=id;
            this.descricao=descricao;
        }

        public int verPrioridade(){
            return prioridade;
        }

        @Override
        public String toString(){
            return "ID:"+id+" | Descrição: "+descricao +" | Prioridade: "+prioridade;
        }

    }

    public static Tarefa buscarPrioridade(ArrayList<Tarefa> filaPrioridade){
        Tarefa maior = filaPrioridade.get(0);
        for (int i = 0; i < filaPrioridade.size(); i++){
            if (maior.verPrioridade()<filaPrioridade.get(i).verPrioridade()){
                maior = filaPrioridade.get(i);
            }
        }
        return maior;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Tarefa> filaPrioridade = new ArrayList<>();
        int op, id = 1;
        do {
            System.out.println("========MENU========");
            System.out.println("1- Inserir Tarefa");
            System.out.println("2- Listar Tarefas");
            System.out.println("3- Ver tarefa com maior Prioridade");
            System.out.println("4- Remover tarefa");
            System.out.println("5- Sair");
            System.out.print("Escolha uma Opção: ");
            op = input.nextInt();

            switch (op){
                case 1:
                    System.out.print("Descrição da Tarefa: ");
                    String descricao = input.next();
                    System.out.print("Prioridade(1-Maior/0-Menor)");
                    int prioridade = input.nextInt();
                    Tarefa nova = new Tarefa(id, prioridade, descricao);
                    filaPrioridade.add(nova);
                    id++;

                    System.out.println("Tarefa inserida com sucesso.");
                    break;
                case 2:
                    if (!filaPrioridade.isEmpty()){
                        System.out.println(filaPrioridade);
                    }else{
                        System.out.println("Fila Vazia");
                    }
                    break;
                case 3:
                    if (!filaPrioridade.isEmpty()){
                        Tarefa maiorPrioridade = buscarPrioridade(filaPrioridade);
                        System.out.println(maiorPrioridade);
                    }else
                        System.out.println("Fila Vazia");
                    break;
                case 4:
                    if (!filaPrioridade.isEmpty()){
                        Tarefa removida = buscarPrioridade(filaPrioridade);
                        filaPrioridade.remove(removida);
                        System.out.println("Tarefa Removida: "+removida);

                    }else
                        System.out.println("Fila Vazia");
                    break;
                case 5:
                    System.out.println("Saindooo");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }while (op != 5);
    }

}
