set PATH=%PATH%;D:\java\graphviz\bin

jdeps --module-path build -dotoutput graphs build/timeclient build/timeserver

dot -Tpng -Gdpi=300 graphs/summary.dot > summary.png
start summary.png