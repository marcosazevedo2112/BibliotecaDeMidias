#Biblioteca de Midias v2000
Apos eu ter perdido meu antigo projeto de LLP(Biblioteca de midias v1000), decidi criar a versão v2000, mais bonita, com mais performance e com novas funções!
____

##Para rodar
é recomendado usar o [IntelliJ IDEA da jetbrains](https://www.jetbrains.com/pt-br/idea/ "link do IntelliJ IDEA no site da JetBrains") com o Java SDK 17(Usado por mim), porém acredito que deva funcionar em versões anteriores, pois não utiliza nenhuma classe ou função nova da linguagem.

##Arquivo de biblioteca
Quando se usa as funções 5 e 6 é criado(caso não exista) um arquivo chamado ```"biblioteca.txt"``` no *Working Directory*  que segue a seguinte estrutura:

```Tipo -!- Nome -!- Preço -!- Codigo -!- Sinopse/Nfaixas```

Pelo fato de usar ````-!-```` como separador entra os valores, não é permitido usar o mesmo(````-!-````) em nomes ou sinopses de midias.
Exemplo de um simples arquivo de biblioteca valida:
````
model.DVD -!- As aventuras de tintim -!- 9.99 -!- 797438 -!- sinopse1 -!- 
model.DVD -!- As aventuras de tintim 2 -!- 19.99 -!- 824624 -!- sinopse2 -!- 
model.DVD -!- As aventuras de tintim 3 -!- 29.99 -!- 127170 -!- sinopse3 -!- 
````

Para facilitar a visualização esse arquivo também pode ser visto como uma tabela:

| Tipo(String 'model.DVD' 'model.CD') |       Nome(String)       | Preço(double) | Codigo(int) | Sinopse(String)/Nfaixas(int) |
|:-----------------------------------:|:------------------------:|:-------------:|:-----------:|:----------------------------:|
|              model.DVD              |  As aventuras de tintim  |     9.99      |   797438    |           Exemplo1           |
|              model.DVD              | As aventuras de tintim 2 |     19.99     |   824624    |           Exemplo2           |
|              model.DVD              | As aventuras de tintim 3 |     29.99     |   127170    |           Exemplo3           |
|             `model.CD`              |       Baile - FBC        |     22.90     |   578890    |              12              |


##Screenshots
