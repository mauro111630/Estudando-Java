/*
Requisitos do programa Batalha Naval
[X] Tabuleiro 5x5 como matriz de char, tudo começa com '_'
[X] Uma segunda matriz 5x5, escondida, onde ficam 5 navios ('N') em posições aleatórias
[X] Um método que imprime SÓ o tabuleiro visível (o jogador nunca vê a matriz escondida)
[X] Pedir linha e coluna do "tiro" a cada rodada
[X] Validar a entrada com try/catch e checar se linha/coluna estão entre 0 e 4
[X] Impedir atirar de novo numa posição já atacada
[ ] Se acertar um navio: marcar 'X' no tabuleiro visível e avisar "Acertou!"
[ ] Se errar: marcar 'O' no tabuleiro visível e avisar "Água!"
[ ] Contar quantos navios já afundaram
[ ] Quando os 5 navios forem afundados, anunciar vitória e mostrar quantos tiros foram usados
[ ] Perguntar se quer jogar de novo ao final
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
}

void mostrarHUD(){
  IO.println("------------------------------------------------");
  IO.println("                   JOGO NAVAL                   ");
  IO.println("Tabuleiro 5x5");
  IO.println("Coordenadas Y e X");
  IO.println(" Y");
  IO.println("|0| | | | | |");
  IO.println("|1| | | | | |");
  IO.println("|2| | | | | |");
  IO.println("|3| | | | | |");
  IO.println("|4| | | | | |");
  IO.println("| |0|1|2|3|4| X");
  IO.println("------------------------------------------------");
}

void jogar(char [][] tabuleiro){
  //validação de entradas do usuário
  try{
    int linha = Integer.parseInt(IO.readln("Digite coodenada Y: "));
    int coluna = Integer.parseInt(IO.readln("Digite coordenada X: "));
    if(tabuleiro [linha][coluna] == '_'){
        tabuleiro [linha][coluna] = 'X'; 
        IO.println("Tiro dado na água (¬_¬)");
    }else{
        if(tabuleiro [linha][coluna] == 'X'){
          IO.println("Tiro dado da água, dnv (0_0)");
        }else{
          IO.println("ACERTOU em cheio!! (#o#)");  // aqui
        }
    }
  }catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
    IO.println("Resposta inválida!");
    jogar(tabuleiro);
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

void mostrarTabuleiro(char [][] tabuleiro){
  for(int linha = 0; linha < 5; linha++){
    for(int coluna = 0; coluna < 5; coluna++){
      IO.print(tabuleiro[linha][coluna] + " ");
    } 
  IO.println(" ");
  }
}
