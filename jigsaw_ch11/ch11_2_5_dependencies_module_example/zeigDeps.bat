@echo off
jdeps lib/*.jar

pause
echo Zusammenfassung:
jdeps -s lib/*.jar

pause
echo Dotties:
jdeps -dotoutput graphs lib/*.jar

set PATH=%PATH%;D:\java\graphviz\bin
dot -Tpng -Gdpi=300 graphs/summary.dot > summary.png
dot -Tpng -Gdpi=300 graphs/jigsawapp.jar.dot > jigsawapp.png
