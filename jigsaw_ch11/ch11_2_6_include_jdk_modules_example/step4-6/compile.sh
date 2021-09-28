javac -d build --module-source-path src $(find src -name '*.java')

java -p build -m timeclient/com.client.CurrentTimeSwingExample