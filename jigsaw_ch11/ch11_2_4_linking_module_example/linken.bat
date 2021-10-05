del /S /Q exec_example

jlink --module-path %JAVA_HOME%/jmods;lib --add-modules jigsawapp --launcher jigsawapp=jigsawapp/com.inden.javaprofi.MessageExample --output exec_example

exec_example\bin\jigsawapp.bat