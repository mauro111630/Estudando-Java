import java.util.ArrayList;

void main(){
  //lista 
  ArrayList<String> tarefas = new ArrayList<>();
  while(true){  
    //FrontEnd
    IO.println("");
    IO.println("");
    IO.println("-----------------------------------------------------");
    IO.println("LISTA DE TAREFAS");
    mostrarTarefas(tarefas);
    IO.println("");
    IO.println("[1] ADICIONAR");
    IO.println("[2] REMOVER");
    //validação da resposta do usuário
    try{  
      int escolhaMenu = Integer.parseInt(IO.readln("Digite sua opção:")); //String para int
      switch(escolhaMenu){
        case 1 -> adicionarTarefa(tarefas);
        case 2 -> removerTarefa(tarefas);
        default -> IO.println("inválido");
      }
    }catch(NumberFormatException e) {
      IO.println("inválido");
    }
  }    
}

void removerTarefa(ArrayList<String> tarefas){
  //front
  IO.println("");
  IO.println("");
  IO.println("-----------------------------------------------------");
  IO.println("LISTA DE TAREFAS/REMOVER");
  //back
  int tarefaDigitada = Integer.parseInt(IO.readln("Digite o Nº da sua tarefa:"));
  tarefas.remove(tarefaDigitada - 1 );
}

void adicionarTarefa(ArrayList<String> tarefas){
  //front
  IO.println("");
  IO.println("");
  IO.println("-----------------------------------------------------");  
  IO.println("LISTA DE TAREFAS/ADICIONAR");
  //back
  String tarefaDigitada = IO.readln("Digite sua tarefa:");
  tarefas.add(tarefaDigitada);
}

void mostrarTarefas(ArrayList<String> tarefas){
  for(int i = 0; tarefas.size() > i; i++){
    IO.println("(" + (i + 1) + ")" + tarefas.get(i));
  }
}

