# Roteiro Prático sobre Remote Method Invocation (RMI)
Roteiro prático sobre Remote Method Invocation (RMI)

# Como executar


Compile os arquivos do lado do cliente:

```
cd client
javac *.java
```

Na pasta `client``, inicie também o registry:

```
rmiregistry 9400 &
```

Em seguida, compile o código do lado do servidor e execute:

```
cd server
javac *.java
java Server
```

Execute uma chamada remota na pasta `client` e observe a saída:
```
java Client
```

