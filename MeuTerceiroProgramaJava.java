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
  //front
  IO.println("-------------------------------");
  IO.println("-------JOGO DA VELHA-----------");
  IO.println("-------------------------------");
  //back
  parar:
  for (int maxJogadas = 0; maxJogadas < 9; maxJogadas++){   //Controle do jogo, quem joga e quando termina. O máximo de jogadas é 9.
    jogar1(tabuleiro);
    boolean alguemGanhou = conferirQuemGanhou(tabuleiro); //controle do jogo
    if (alguemGanhou == true){
      IO.println("Ganhou!");
      mostrarTabuleiro(tabuleiro);
      break parar;
    }
    jogar2(tabuleiro);
    if (alguemGanhou == true){
      IO.println("Ganhou!");
      mostrarTabuleiro(tabuleiro);
      break parar;
    }
  }
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

void jogar1(char [][] tabuleiro){
  //front
  IO.println("-------------------------------");
  mostrarTabuleiro(tabuleiro);
  IO.println("Jogador 1");
  IO.println("[Obs.: Digite entre 0 e 2]");
  int linha = Integer.parseInt(IO.readln("Digite a linha:"));
  int coluna = Integer.parseInt(IO.readln("Digite a coluna:"));
  //back
  if (tabuleiro [linha][coluna] == '_'){
        tabuleiro [linha][coluna] = 'X'; 
        IO.println("Jogada feita!");
    }else{
        IO.println("Preenchido, tente outro");
        jogar1(tabuleiro);
    }
}

void jogar2(char [][] tabuleiro){
  //front
  IO.println("-------------------------------");
  mostrarTabuleiro(tabuleiro);
  IO.println("Jogador 2");
  IO.println("[Obs.: Digite entre 0 e 2]");
  int linha = Integer.parseInt(IO.readln("Digite a linha:"));
  int coluna = Integer.parseInt(IO.readln("Digite a coluna:"));
  //back
  if (tabuleiro [linha][coluna] == '_'){
        tabuleiro [linha][coluna] = 'O'; 
        IO.println("Jogada feita!");
    }else{
        IO.println("Preenchido, tente outro");
        jogar2(tabuleiro);
    }
}

boolean conferirQuemGanhou(char [][] tabuleiro){
  for (int linha = 0; linha < 3; linha++){
    for (int coluna = 0; coluna < 3; coluna++){
      //possibilidades horizontais
      if (tabuleiro[linha][0]  == 'X' && tabuleiro[linha][1]  == 'X' && tabuleiro[linha][2]  == 'X' ){
        return true;
      }
      //possibilidades verticais
      if (tabuleiro[0][coluna]  == 'X' && tabuleiro[1][coluna]  == 'X' && tabuleiro[2][coluna]  == 'X' ){
        return true;
      }
      //possibilidades diagonais
      if (tabuleiro[0][0]  == 'X' && tabuleiro[1][1]  == 'X' && tabuleiro[2][2]  == 'X' ){
        return true;
      }
      if (tabuleiro[0][2]  == 'X' && tabuleiro[1][1]  == 'X' && tabuleiro[2][0]  == 'X' ){
        return true;
      }
      //Possibilidades do O
      //possibilidades horizontais
      if (tabuleiro[linha][0]  == 'O' && tabuleiro[linha][1]  == 'O' && tabuleiro[linha][2]  == 'O' ){
        return true;
      }
      //possibilidades verticais
      if (tabuleiro[0][coluna]  == 'O' && tabuleiro[1][coluna]  == 'O' && tabuleiro[2][coluna]  == 'O' ){
        return true;
      }
      //possibilidades diagonais
      if (tabuleiro[0][0]  == 'O' && tabuleiro[1][1]  == 'O' && tabuleiro[2][2]  == 'O' ){
        return true;
      }
      if (tabuleiro[0][2]  == 'O' && tabuleiro[1][1]  == 'O' && tabuleiro[2][0]  == 'O' ){
        return true;
      }
    }
  } 
  return false;
}

