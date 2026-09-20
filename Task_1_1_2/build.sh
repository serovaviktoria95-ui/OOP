javac -d build/classes src/main/java/ru/nsu/vserova/task112/*.java
javadoc -d build/docs src/main/java/ru/nsu/vserova/task112/*.java
jar cf build/game.jar -C build/classes .
java -cp build/classes ru.nsu.vserova.task112.Main