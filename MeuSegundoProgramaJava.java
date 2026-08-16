void main() {
//back end
  char [][] assentos = {
      {'_', '_', '_', '_', '_'},
      {'_', '_', '_', '_', '_'},
      {'_', '_', '_', '_', '_'},
      {'_', '_', '_', '_', '_'},
      {'_', '_', '_', '_', '_'}
    };
  while (true) { // mantém o código funcionando
    

//front end
    IO.println("--------------------------------------------------------");
    IO.println("                     CINEMA                             ");
    IO.println("     Digite o número correspondente a sua escolha       ");
    IO.println("[1] mapa");
    IO.println("[2] assento");
    IO.println("[3] fatura");
    IO.println("[4] sair");
    IO.println("--------------------------------------------------------");
    int num = Integer.parseInt(IO.readln("Número: ")); //recebe o valor do usuário e transforma em inteiro

//back end
    switch (num) {
      case 1:
        mapa(assentos);
      break;
      case 2:
        assento();
      break;
      case 3:
        fatura();
      break;
      case 4:
        sair();
      break;
      default:
        IO.println("Digito inválido");
      break;
    }
  }
}

void mapa(char [] [] assentos){ //mostra o mapa
  // loop que vai mostrar cada caracter de cada index da tabela assentos
  for (int l = 0; l < 5; l++){    //l de linha
    for (int c = 0; c <5; c++){   //c de coluna
      IO.print(assentos[l][c] + " ");
    }    
    IO.println(" ");
  }
}
// adições futuras
void assento() {
    IO.println("Função de reservar assento em breve...");
}

void fatura() {
    IO.println("Função de faturamento em breve... ");
}

void sair() {
    IO.println("Saindo do sistema... Até logo!");
    // Para fechar o programa de verdade, podemos usar:
    System.exit(0); 
}

