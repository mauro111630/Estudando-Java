/*
Requisitos do programa
[x]Tabuleiro 3x3 como matriz de char.
[x]Um método que imprime o tabuleiro de forma legível.
[x]Alternar entre jogador X e jogador O a cada rodada.
[x]Pedir linha e coluna da jogada.
[x]Impedir jogar numa posição já ocupada.
[-]Validar a entrada com try/catch e checar se linha/coluna estão entre 0 e 2.
[x]Depois de cada jogada, checar se aquele jogador venceu (3 iguais em linha, coluna ou nas duas diagonais).
[x]Se ninguém vencer e o tabuleiro encher, anunciar empate.
[x]Perguntar se quer jogar de novo ao final.
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
  controlarJogo(tabuleiro);
}

void terminarJogo(char [][] tabuleiro){
  IO.println("-------------------------------");
  IO.println("[1] reiniciar");
  IO.println("[2] acabar");
  int resposta = Integer.parseInt(IO.readln("Digite um dos valores acima: "));
  switch (resposta) {
    case 1 -> reiniciarJogo(tabuleiro);
    case 2 -> IO.println("tchau!");
    default -> terminarJogo(tabuleiro);
  }  
}

void reiniciarJogo(char [][] tabuleiro){
  for(int linha = 0; linha < 3; linha++){
    for(int coluna = 0; coluna < 3; coluna++){
        tabuleiro [linha][coluna] = '_';  
    } 
  }
  controlarJogo(tabuleiro);
}
//back
void controlarJogo(char [][] tabuleiro){
  jogar1(tabuleiro);//o máx é 9 jogadas, então coloquei 1 jogada de fora pro loop ser 4x2 que é 8 jogadas no loop mais essa da linha comentada
  for(int maxJogadas = 0; maxJogadas < 4; maxJogadas++){
    boolean ganhou1 = conferirQuemGanhou(tabuleiro);
    if(ganhou1 == true){
      mostrarTabuleiro(tabuleiro);
      IO.println("ganhou");
      break;
    }
    jogar2(tabuleiro);
    boolean ganhou2 = conferirQuemGanhou(tabuleiro);
    if(ganhou2 == true){
      mostrarTabuleiro(tabuleiro);
      IO.println("ganhou");
      break;
    }
    jogar1(tabuleiro);
  }
  boolean empate = conferirQuemGanhou(tabuleiro);
  if(empate == false){
      mostrarTabuleiro(tabuleiro);
      IO.println("empatou");
    }
  terminarJogo(tabuleiro);
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
//back
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

