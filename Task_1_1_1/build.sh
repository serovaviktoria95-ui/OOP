javac -d build/classes src/main/java/ru/nsu/vserova/task111/*.java
javadoc -d build/docs src/main/java/ru/nsu/vserova/task111/*.java
jar cf build/heapsort.jar -C build/classes .
java -cp build/classes ru.nsu.vserova.task111.Main