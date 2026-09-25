/*
Requisitos do programa - Campo Minado
[X] Tabuleiro 8x8 como matriz de char, tudo começa oculto (ex: '#')
[X] Uma segunda matriz 8x8, escondida, com 10 minas ('M') em posições aleatórias
[X] Um método que, para uma casa sem mina, conta quantas minas existem nas até 8 casas vizinhas (cuidado com os limites do tabuleiro!)
[X] Um método que imprime SÓ o tabuleiro visível
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
  mostrarHUD(tabuleiroInterior);
  IO.print("Coordenada Y:");
  int coordenadaY = jogar();
  IO.print("Coordenada X:");
  int coordenadaX = jogar();
  int qtdBombasPerto = conferir8CasasEmVolta(tabuleiroInterior, coordenadaY, coordenadaX);
  IO.print("Bombas perto:" + qtdBombasPerto);

 
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

//método para testar o código
void mostrarTabuleiro(char [][] tabuleiro){
  for(int linha = 0; linha < 8; linha++){
    for(int coluna = 0; coluna < 8; coluna++){
      IO.print(tabuleiro[linha][coluna] + " ");
    } 
  IO.println(" ");
  }
}

int conferir8CasasEmVolta(char [][] tabuleiro, int coordenadaY, int coordenadaX){
  int qtdBombas = 0;
  // posição fora do tabuleiro, o try/catch ignora e continua
  /*
    Fiz algumas contas e descobrir que são um total de 8 possibilidades(8 casas em volta da casa recebida), e alguns de padrões surgem, 
    e ai concluir as seguinter afirmações:
    ((1+-Y),(1+-X)) -> mesmo sinal entre grandezas, duas possibilidades
    ((1+-Y),(1+-X)) -> diferentes sinais entre grandezas, duas possibilidades
    ((Y),(1+-X)) -> duas possibilidades
    ((1+-Y),(X)) -> duas possibilidades
    totalizando as 8 possibilidades, obrigado Deus Jeová pelas minhas faculdades mentais.
  */
  try{
    if(tabuleiro[coordenadaY + 1][coordenadaX + 1] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){}
  
  try{
    if(tabuleiro[coordenadaY - 1][coordenadaX - 1] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){} 
  
  try{
    if(tabuleiro[coordenadaY + 1][coordenadaX - 1] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){} 
    
  try{
    if(tabuleiro[coordenadaY - 1][coordenadaX + 1] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){} 
  
  try{
    if(tabuleiro[coordenadaY][coordenadaX + 1] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){} 
    
  try{
    if(tabuleiro[coordenadaY][coordenadaX - 1] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){} 
  
  try{
    if(tabuleiro[coordenadaY + 1][coordenadaX] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){} 
  
  try{
    if(tabuleiro[coordenadaY - 1][coordenadaX] == 'M'){
      qtdBombas++;
    }
  }catch(ArrayIndexOutOfBoundsException e){} 
  
  return qtdBombas;
}

void mostrarHUD(char [][] base){
  IO.println("------------------------------------------------");
  IO.println("            JOGO CAMPO MINADO                   ");
  IO.println("Tabuleiro 5x5");
  IO.println("Coordenadas Y e X");
  IO.println(" Y");
  
  IO.print("|0|");
  for(int i = 0; i<8; i++){            //mostrar a tabela de forma mais intuitiva
    IO.print(base[0][i] +"|");
  }
  IO.println("");
  IO.print("|1|");
  for(int i = 0; i<8; i++){         
    IO.print(base[1][i] +"|");
  }
  IO.println("");  
  IO.print("|2|");
  for(int i = 0; i<8; i++){         
    IO.print(base[2][i] +"|");
  }
  IO.println("");
  IO.print("|3|");
  for(int i = 0; i<8; i++){         
    IO.print(base[3][i] +"|");
  }
  IO.println("");  
  IO.print("|4|");
  for(int i = 0; i<8; i++){         
    IO.print(base[4][i] +"|");
  }
  IO.println("");  
  IO.print("|5|");
  for(int i = 0; i<8; i++){         
  IO.print(base[5][i] +"|");
  }
  IO.println("");
  IO.print("|6|");
  for(int i = 0; i<8; i++){         
  IO.print(base[6][i] +"|");
  }
  IO.println("");
  IO.print("|7|");
  for(int i = 0; i<8; i++){         
  IO.print(base[7][i] +"|");
  }
  IO.println(""); 
  
  
  IO.println("| |0|1|2|3|4|5|6|7| X");
  IO.println("------------------------------------------------");
}
//entrada de valor do usuário
int jogar(){
  //variáveis locais
  int respostaJogada = 0;      
  boolean controleJogo = true; 
  //controle do jogo
  while(controleJogo == true){
    boolean statusResposta = true;
    //validação de entradas do usuário
    try{
      respostaJogada = Integer.parseInt(IO.readln(""));
    }catch(NumberFormatException e) {
      IO.println("Resposta inválida!");
      statusResposta = false;
    }   
    if(statusResposta == true){  //Validando se o jogador digitou um valor válido
      controleJogo = false;
    }
  }
  return respostaJogada;
}
