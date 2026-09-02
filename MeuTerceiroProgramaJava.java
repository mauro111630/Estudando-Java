/*
Requisitos do programa
-Tabuleiro 3x3 como matriz de char.
-Um método que imprime o tabuleiro de forma legível.
-Alternar entre jogador X e jogador O a cada rodada.
-Pedir linha e coluna da jogada.
-Impedir jogar numa posição já ocupada.
-Validar a entrada com try/catch e checar se linha/coluna estão entre 0 e 2.
-Depois de cada jogada, checar se aquele jogador venceu (3 iguais em linha, coluna ou nas duas diagonais).
-Se ninguém vencer e o tabuleiro encher, anunciar empate.
-Perguntar se quer jogar de novo ao final (reaproveite o while(true)).
*/

//back
void main(){
  char [][] tabuleiro = {
    {'_', '_', '_'},
    {'_', '_', '_'},
    {'_', '_', '_'}
  };
  mostrarTabuleiro(tabuleiro);
}
//front
void mostrarTabuleiro(char [][] tabuleiro){
  for(int linha = 0; linha < 3; linha++){
    for(int coluna = 0; coluna < 3; coluna++){
      IO.print(tabuleiro[linha][coluna] + " ");
    } 
  IO.println(" ");
  }
}
