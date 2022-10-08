# L3S5G7-COO-ALMEIDA-BOUSSERT

## 1. Quick introduction of the project

## 2. *HowTo* 

### 2.1 Get the project
	
```
git clone https://gitlab-etu.fil.univ-lille.fr/neo.almeida.etu/l3s5g7-coo-almeida-boussert.git
# OU
git clone git@gitlab-etu.fil.univ-lille.fr:neo.almeida.etu/l3s5g7-coo-almeida-boussert.git
```

### 2.2 Generate project's documentation 

To generate project's documentation, you just have to execute theses commands :

```
find src/fr/main -type f -name "*.java" | xargs javadoc -d doc/
```

### 2.3 Generate sources

Root folder
```
javac -sourcepath src ./src/fr/main/java/*.java -d ./bin
```

### 2.4 Execute sources

Root folder
```
java -classpath bin fr.main.java.HelloWorld
```

### 2.5 Generate tests
Root folder
```
javac -cp .\dependencies\junit-platform-console-standalone-1.9.0.jar -sourcepath src .\src\fr\test\java\*.java -d .\bin\
```

### 2.6 Execute tests

java -jar .\dependencies\junit-platform-console-standalone-1.9.0.jar -class-path bin --scan-class-path

### 2.7 Generate JAR 

To generate project's JAR, you just have to execute theses commands :
```
jar -cvfe Program.jar fr.main.java.HelloWorld -C bin .
```

### 2.8 Execute JAR

To execute the JAR, you just have to execute theses commands :

```
java -jar .\Program.jar
```

## 3. Elements interessant du projet :

- *Design elements who can be interesting or important to show*
- *Presentations of the design patterns implemented*
- *All points that allow us to enhance our project* 