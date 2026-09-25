/*
Requisitos do programa - Campo Minado
[X] Tabuleiro 8x8 como matriz de char, tudo começa oculto (ex: '#')
[] Uma segunda matriz 8x8, escondida, com 10 minas ('M') em posições aleatórias
[ ] Um método que, para uma casa sem mina, conta quantas minas existem nas até 8 casas vizinhas (cuidado com os limites do tabuleiro!)
[ ] Um método que imprime SÓ o tabuleiro visível
[ ] Pedir linha e coluna da casa a revelar
[ ] Validar a entrada com try/catch e checar se linha/coluna estão entre 0 e 7
[ ] Impedir revelar de novo uma casa já revelada
[ ] Se a casa tiver mina: revelar todas as minas no tabuleiro e anunciar "Você perdeu!"
[ ] Se a casa tiver 0 minas vizinhas: revelar automaticamente, em cascata, todas as vizinhas vazias (aqui é recursão de verdade — com caso base, sem repetir o problema do catch da Batalha Naval)
[ ] Se a casa tiver minas por perto: revelar só ela, mostrando o número
[ ] Verificar vitória: quando todas as casas sem mina estiverem reveladas
[ ] Perguntar se quer jogar de novo ao final
*/

import java.util.random.*;

void main(){
  //Dois tabuleiros, o da superfície para mostrar ao jogador e o interior para armazenar a posição das bombas
  char [][] tabuleiroSuperficie = {
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'}
  };
  char [][] tabuleiroInterior = {
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#'}
  };
  aletorizarMinas(tabuleiroInterior);
  mostrarTabuleiro(tabuleiroInterior);
  IO.println("-------------------------------------");
  IO.println("");
  aletorizarMinas(tabuleiroInterior);
  mostrarTabuleiro(tabuleiroInterior);
}

void aletorizarMinas(char [][] tabuleiro){
  limparTabela(tabuleiro);
  //gerador de aleatório. 
  RandomGenerator g = RandomGenerator.of("L64X1024MixRandom");
  //limitadores do gerador de aleatórios para tabela
  int qtdEmbaralhar = 10; //personalizável
  int indiceControle = 0; //sempre zero
  while(indiceControle < qtdEmbaralhar){
    int inicioAleatorio = 0; //começar daqui 
    int fimAleatorio = 8;    //terminar aqui - Gerador de aleatório  
    //aletorizando coordenada da tabela
    int colunaAleatorio = g.nextInt(inicioAleatorio, fimAleatorio);
    int linhaAleatorio = g.nextInt(inicioAleatorio, fimAleatorio);
    //validando posição
    if(tabuleiro[linhaAleatorio][colunaAleatorio] == '#'){
      tabuleiro[linhaAleatorio][colunaAleatorio] = 'M';
      indiceControle++;
    }  
  }
}

void limparTabela(char [][] tabuleiro){
  for(int linha = 0; linha < 8; linha++){
    for(int coluna = 0; coluna < 8; coluna++){
        tabuleiro[linha][coluna] = '#';  
    } 
  }
}

void mostrarTabuleiro(char [][] tabuleiro){
  for(int linha = 0; linha < 8; linha++){
    for(int coluna = 0; coluna < 8; coluna++){
      IO.print(tabuleiro[linha][coluna] + " ");
    } 
  IO.println(" ");
  }
}

