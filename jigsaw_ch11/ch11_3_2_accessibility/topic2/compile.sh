javac -d build --module-source-path src $(find src -name '*.java')

java -p build -m privatetimeclient/com.internalclient.PrivateTimeClientExample