# Sistemas Distribuídos

## Equipe 1

* Geise Saunier
* Iano Maciel
* Rafael Guedes
* Taynara Costa

## Especificação do trabalho

  1. O foco do sistema deve girar em torno de duas frentes: Cliente e Servidor;
  2. O usuário deverá solicitar 5 espaços de memória;
  3. Ao chegar no limite de espaço suficiente, essa informação será armazenada na SWAP;
  4. Quando tiver espaço suficiente na memória principal, a SWAP mandará essas infomações novamente para serem armazenadas lá;
  5. Critérios de funcionamento: o algoritmo deverá leva emconsideração o tamanho dos processos e a prioridade. O tempo poderá ser definido pela equipe.

A estrutura do trabalho descrito acima pode ser representada pela Figura 1 abaixo:

![Distributed Systems drawio](https://user-images.githubusercontent.com/71051791/164568877-d2c729f0-fae6-4941-a80d-658a145d72e1.png)

## Solução 


## Casos de teste 

### Entrada

A primeira linha de um conjunto de teste contém um número inteiro não negativo, N, que indica o número de processos a serem lidos e colocados na fila de prontos (o valor N = 0 indica o final da entrada). Seguem-se N linhas, cada uma contendo três (3) números inteiros não negativos X, Y e Z que representam o tempo de ingresso do processo (X), o tempo de duração do processo (Y) e a prioridade do processo (Z). Os processos são numerados sequencialmente a partir de 1, na ordem em que aparecem na entrada. É importante ressaltar que quanto menor o valor numérico de Z, maior é a prioridade do processo.

### Saída

Para cada conjunto de teste da entrada, são produzidas quatro linhas na saída. A primeira linha deve contém um identificador do conjunto de teste, no formato “Teste n”, onde n é numerado a partir de 1. A segunda linha contém o tempo médio de execução (turnaround) de todos os processos desse conjunto de teste, no formato “Tempo médio de execução: n”, onde n é a média do tempo de execução. A terceira linha contém o tempo médio de espera de todos os processos desse conjunto de teste, no formato “Tempo médio de espera: n”, onde n é a média do tempo de espera. A quarta e última linha contém a ordem de escalonamento (execução) dos processos, no formato “P1 P2 P3 P4”.  

Os exemplos de casos de teste estão exemplificados na tabela abaixo:

| Exemplo de Entrada (Prioridade)                                                                         	| Exemplo de Saída (Prioridade)                                                                                                                                                                     	|
|---------------------------------------------------------------------------------------------------------	|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| 4 <br>0 5 2<br>0 2 0<br>1 4 2<br>3 3 3<br>6 <br>0 1 8<br>0 2 6<br>0 3 6<br>0 3 4<br>0 5 6<br>0 7 1<br>0 	| Teste 1<br>Tempo médio de execução: 7,50s<br>Tempo médio de espera: 4,00s<br>P2 P1 P3 P4<br> <br>Teste 2<br>Tempo médio de execução: 14,17s<br>Tempo médio de espera: 10,67s<br>P6 P4 P2 P3 P5 P1 	|
