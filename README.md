# CompilerJava
Instrucciones de ejecución
1. Tener cargados las librerias JFlex.jar, java_cup.jar y java-cup-11a.jar en el proyecto para que se reconozca su implementación y uso.
2. Ajustar las rutas (paths) del archivo Compiler.java de acuerdo a donde se encuentra la carpeta del proyecto; por ejemplo,
            String ruta1="C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/Lexer.flex";
  inicialmente la carpetea del proyecto se encuentra en Desktop con usuario moy_r_000, por lo que deberan ser ajustados a donde se encuentre.
3. Al hacer cambios y volver a ejecutar, primero correr archivo Compiler.java, detener ejecucion y posteriormente correr IDE.java.
4. Para ejecutar programa desde cmd es necesario construir todo el proyecto y obtener el ejecutable 'Compiler.jar'
  Para ello basta darle click derecho a la taza café del proyecto (de apache netbeans) -> build
  Así mismo dentro de la carpeta del proyecto con nombre 'dist' se encuentra dicho ejecutable y 
  desde un cmd (en esta ruta) ejecutamos: java - jar Compiler.jar archivo.txt
  teniendo este archivo.txt tambien dentro de esta carpeta 'dist'.
