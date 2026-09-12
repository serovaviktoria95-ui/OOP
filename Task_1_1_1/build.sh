javac -d build/classes src/main/java/ru/nsu/kagaya/Task_1_1_1/*.java
javadoc -d build/docs src/main/java/ru/nsu/kagaya/Task_1_1_1/*.java
jar cf build/heapsort.jar -C build/classes .
java -cp build/classes ru.nsu.kagaya.Task_1_1_1.Main