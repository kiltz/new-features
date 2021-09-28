mkdir lib
echo packen
jar --create --file lib/jigsawapp.jar -C build/jigsawapp .
jar --create --file lib/services.jar --module-version 1.0 -C build/services .

echo ausführen
java -p lib -m jigsawapp/com.inden.javaprofi.MessageExample
