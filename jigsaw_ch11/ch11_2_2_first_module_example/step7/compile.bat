
javac -d build/services src/services/*.java src/services/com/services/api/*.java src/services/com/services/impl/*.java

rem javac -d build/jigsawapp src/jigsawapp/*.java src/jigsawapp/com/inden/javaprofi/*.java

javac -d build/jigsawapp -p build src/jigsawapp/*.java src/jigsawapp/com/inden/javaprofi/*.java

java -p build -m jigsawapp/com.inden.javaprofi.MessageExample