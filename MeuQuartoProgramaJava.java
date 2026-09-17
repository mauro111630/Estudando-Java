/*
Requisitos do programa Batalha Naval
[X] Tabuleiro 5x5 como matriz de char, tudo começa com '_'
[X] Uma segunda matriz 5x5, escondida, onde ficam 5 navios ('N') em posições aleatórias
[X] Um método que imprime SÓ o tabuleiro visível (o jogador nunca vê a matriz escondida)
[ ] Pedir linha e coluna do "tiro" a cada rodada
[ ] Validar a entrada com try/catch e checar se linha/coluna estão entre 0 e 4
[ ] Impedir atirar de novo numa posição já atacada
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
  aletorizarNavios(naviosTabuleiro);
  mostrarHUD();
  mostrarTabuleiro(baseTabuleiro);
}

void mostrarHUD(){
  IO.println("------------------------------------------------");
  IO.println("                   JOGO NAVAL                   ");
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
