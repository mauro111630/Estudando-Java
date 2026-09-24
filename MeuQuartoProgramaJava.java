/*
Requisitos do programa Batalha Naval
[X] Tabuleiro 5x5 como matriz de char, tudo começa com '_'
[X] Uma segunda matriz 5x5, escondida, onde ficam 5 navios ('N') em posições aleatórias
[X] Um método que imprime SÓ o tabuleiro visível (o jogador nunca vê a matriz escondida)
[X] Pedir linha e coluna do "tiro" a cada rodada
[X] Validar a entrada com try/catch e checar se linha/coluna estão entre 0 e 4
[X] Impedir atirar de novo numa posição já atacada
[X] Se acertar um navio: marcar 'X' no tabuleiro visível e avisar "Acertou!"
[X] Se errar: marcar 'O' no tabuleiro visível e avisar "Água!"
[X] Contar quantos navios já afundaram
[X] Quando os 5 navios forem afundados, anunciar vitória e mostrar quantos tiros foram usados
[X] Perguntar se quer jogar de novo ao final
*/

import java.util.random.*;
  
void main(){
  //estrutura básica do jogo
  char [][] baseTabuleiro = {
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'}
  };
  char [][] naviosTabuleiro = {
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'},
    {'_', '_', '_', '_', '_'}
  };
  boolean i = true;
  while(i == true){
    aletorizarNavios(naviosTabuleiro);
    limparTabela(baseTabuleiro);
    int contadorNavios = 0;
    int contadorTiros = 0;
    jogar(naviosTabuleiro, baseTabuleiro, contadorNavios, contadorTiros);
    i = fimJogo();
  }
 }

boolean fimJogo(){
  try{
    IO.println("Jogar de novo?");
    IO.println("[1] SIM");
    IO.println("[2] NÃO");
    int resposta = Integer.parseInt(IO.readln("Digite sua resposta: "));
    switch(resposta) {
      case 1 -> {return true;}
      case 2 -> {
        IO.println("Tchau!");
        return false;
      }
      default -> {
        IO.println("Resposta inválida!");
        return fimJogo();
      }
    }
  }catch(NumberFormatException e){
    IO.println("Resposta inválida!");
    return fimJogo();
  }  
}

void mostrarHUD(char [][] base){
  IO.println("------------------------------------------------");
  IO.println("                   JOGO NAVAL                   ");
  IO.println("Tabuleiro 5x5");
  IO.println("Coordenadas Y e X");
  IO.println(" Y");
  
  IO.print("|0|");
  for(int i = 0; i<5; i++){            //mostrar a tabela de forma mais intuitiva
    IO.print(base[0][i] +"|");
  }
  IO.println("");
  IO.print("|1|");
  for(int i = 0; i<5; i++){         
    IO.print(base[1][i] +"|");
  }
  IO.println("");  
  IO.print("|2|");
  for(int i = 0; i<5; i++){         
    IO.print(base[2][i] +"|");
  }
  IO.println("");
  IO.print("|3|");
  for(int i = 0; i<5; i++){         
    IO.print(base[3][i] +"|");
  }
  IO.println("");  
  IO.print("|4|");
  for(int i = 0; i<5; i++){         
    IO.print(base[4][i] +"|");
  }
  IO.println("");  
  IO.println("| |0|1|2|3|4| X");
  IO.println("------------------------------------------------");
}

void jogar(char [][] navios, char [][] base, int naviosDestruidos, int tirosDados){
  //controle do jogo
  boolean i = true;
  while(i == true){
    mostrarHUD(base);
    IO.println("Navios destruídos = " + naviosDestruidos);
    IO.println("Tiros dados = " + tirosDados);
    //validação de entradas do usuário
    try{
      int linha = Integer.parseInt(IO.readln("Digite coodenada Y: "));
      int coluna = Integer.parseInt(IO.readln("Digite coordenada X: "));
      //condições das possibilidades de jogada, são duas: na água ou navio. Mas também tem a de jogar onde já jogou.
      if(navios [linha][coluna] == 'N' && base [linha][coluna] == '_'){ //corrigindo bug de atirar no mesmo navio pra ganhar
        IO.println("ACERTOU em cheio!! (#o#)");
        base [linha][coluna] = 'X';
        naviosDestruidos++;
        tirosDados++;
      }else{
        if(base[linha][coluna] == 'O' || base[linha][coluna] == 'X' ){
          IO.println("Já atirou aqui!, escolha outra coordernada."); 
        }else{
          base [linha][coluna] = 'O';
          IO.println("Tiro dado na água (¬_¬)");
          tirosDados++;
        }  
      }
    }catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
      IO.println("Resposta inválida!");
      jogar(navios, base, naviosDestruidos, tirosDados);
    }   
    if(naviosDestruidos == 5){
      IO.println("Todos os 5 navios foram destruídos" );
      IO.println("Foram dados " + tirosDados + " tiros");
      IO.println("Ganhou!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      i = false;
    }
  }
}
void aletorizarNavios(char [][] tabuleiro){
  limparTabela(tabuleiro);
  //embaralhando 5 navios
  int i = 0;
  while(i < 5){
    //gerador de aleatório. 
    RandomGenerator g = RandomGenerator.of("L64X1024MixRandom");
    //limitadores do gerador de aleatórios para tabela 5x5
    int inicioAleatorio = 0;
    int fimAleatorio = 5;
    //aletorizando coordenada da tabela
    int colunaAleatorio = g.nextInt(inicioAleatorio, fimAleatorio);
    int linhaAleatorio = g.nextInt(inicioAleatorio, fimAleatorio);
    //validando posição
    if(tabuleiro[linhaAleatorio][colunaAleatorio] == '_'){
      tabuleiro[linhaAleatorio][colunaAleatorio] = 'N';
      i++;
    }  
  }
}

void limparTabela(char [][] tabuleiro){
  for(int linha = 0; linha < 5; linha++){
    for(int coluna = 0; coluna < 5; coluna++){
        tabuleiro[linha][coluna] = '_';  
    } 
  }
}


