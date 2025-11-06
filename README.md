# Conversor de Medidas com RMI (Java)

Este projeto implementa um **Conversor de Medidas distribuído** em Java utilizando o **RMI (Remote Method Invocation)**, permitindo a execução de métodos remotos entre cliente e servidor.

---

## Funcionalidades

O sistema realiza conversões em diferentes categorias:

- **Temperatura:** Celsius ↔ Fahrenheit  
- **Distância:** Km ↔ Milhas, Metros ↔ Centímetros  
- **Peso:** Quilogramas ↔ Libras  
- **Tempo:** Horas ↔ Minutos  
- **Altura:** Metros ↔ Pés  

O servidor processa as conversões e exibe no console logs de cada operação solicitada pelos clientes.

---

## Estrutura

rmi-application/  
├── ClientConverter.java # Aplicação cliente (interface de usuário)  
├── ServerConverter.java # Servidor RMI com as implementações de conversão  
├── Converter.java # Interface remota (definição dos métodos)  
└── README.md

---

## Tecnologias utilizadas

- **Java SE**
- **Java RMI (Remote Method Invocation)**

---

## Como executar

### Executando em **um único computador**

1. **Compilar os arquivos Java**

	`javac *.java`

2. **Iniciar o servidor**

	`java ServerConverter` 

> O servidor cria um registro RMI na porta **2001** e fica aguardando conexões de clientes locais.

3. **Executar o cliente (em outro terminal)**

	`java ClientConverter` 

> O cliente se conecta ao servidor via `localhost` (padrão) e apresenta um menu interativo.

### Executando em **computadores diferentes (rede local)**

> Esta opção demonstra o real comportamento distribuído da aplicação RMI.

#### No computador SERVIDOR

1.  Descubra o **endereço IP local** da máquina servidor:
    
    -   No Windows: `ipconfig`
        
    -   No Linux/macOS: `ifconfig`
        
    
    Exemplo:
    
    `IPv4 Address: 192.168.0.105` 
    
2.  **Edite a linha no `ServerConverter.java`**, substituindo `localhost` pelo IP da máquina servidor:
    
    `System.setProperty("java.rmi.server.hostname", "192.168.0.105");
    Naming.rebind("rmi://192.168.0.105:2001/Converter", stub);` 
    
3.  Compile novamente e execute o servidor:
    
    `javac *.java
    java ServerConverter` 
    
    > O servidor ficará aguardando chamadas remotas na rede.

#### No computador CLIENTE

1.  Copie os arquivos `ClientConverter.java` e `Converter.java` para o computador cliente.  
    (não é necessário o `ServerConverter.java`).
    
2.  Compile:
    
    `javac *.java` 
    
3.  Execute o cliente informando o IP do servidor como argumento:
    
    `java ClientConverter 192.168.0.105` 
    
    > O cliente se conectará ao servidor remoto pela porta **2001** via RMI.

### Dica importante

Se houver bloqueios de conexão:

-   Verifique o **firewall** e permita conexões Java/RMI na porta **2001**.
    
-   Certifique-se de que **ambos os computadores estão na mesma rede**.

## Exemplo de uso
```
=== CONVERSOR DE MEDIDAS ===
1 - Celsius -> Fahrenheit
2 - Fahrenheit -> Celsius
3 - Km -> Milhas
4 - Milhas -> Km
...
Escolha uma opcao: 1
Digite o valor a converter: 25
25.00 °C = 77.00 °F
```
No console do servidor:
`Convertendo  25.0 °C  para  Fahrenheit`


## Conceito principal

O projeto demonstra o uso de **RMI (Remote Method Invocation)**, tecnologia que permite a chamada de métodos em objetos localizados em diferentes máquinas, tornando possível a comunicação entre aplicações distribuídas em Java.

## Autoria

Desenvolvido por **Aliana Wakassugui de Paula e Silva, Jamile Hassen Sá e José Lucas Hoppe Macedo**  
Universidade Estadual do Oeste do Paraná (UNIOESTE)  
Disciplina: **Sistemas Distribuídos**
