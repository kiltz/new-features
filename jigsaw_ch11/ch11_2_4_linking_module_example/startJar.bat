
jar --create --file lib/jigsawapp.jar --main-class com.inden.javaprofi.MessageExample -C build/jigsawapp .
jar --create --file lib/services.jar --module-version 1.0 -C build/services .

java -p lib -m jigsawapp